package Konkuk.U2E.global.openApi.gemini;

import Konkuk.U2E.global.openApi.gemini.exception.GeminiCallFailedException;
import Konkuk.U2E.global.openApi.gemini.exception.GeminiInvalidResponseException;
import Konkuk.U2E.global.openApi.gemini.exception.GeminiMissingApiKeyException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatusCode;

@Component
@RequiredArgsConstructor
public class GeminiClient {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${gemini.api-key}")
    private String apiKey;

    @Value("${gemini.model}")
    private String model;

    @Value("${gemini.endpoint}")
    private String endpoint;

    private WebClient webClient() {
        return WebClient.builder()
                .baseUrl(endpoint)
                .defaultHeader("x-goog-api-key", apiKey)
                .build();
    }

    public String generateContentJson(String systemPrompt, String userPrompt) {
        // 0 설정 검증
        if (!StringUtils.hasText(apiKey)) {
            throw new GeminiMissingApiKeyException();
        }

        // 1 요청 페이로드
        var payload = """
        {
          "systemInstruction": {
            "role": "system",
            "parts": [{"text": %s}]
          },
          "contents": [{
            "role": "user",
            "parts": [{"text": %s}]
          }],
          "generationConfig": {
            "temperature": 0.4,
            "topK": 32,
            "topP": 0.95,
            "maxOutputTokens": 1024,
            "responseMimeType": "application/json"
          }
        }
        """.formatted(jsonEscape(systemPrompt), jsonEscape(userPrompt));

        String path = "/models/%s:generateContent".formatted(model);

        // 2 호출 + 상태코드별 매핑
        String raw = webClient()
                .post()
                .uri(uriBuilder -> uriBuilder.path(path).queryParam("key", apiKey).build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(payload)
                .retrieve()
                .onStatus(HttpStatusCode::isError, resp ->
                        resp.bodyToMono(String.class)
                                .defaultIfEmpty("")
                                .flatMap(body -> Mono.error(
                                        new GeminiCallFailedException("status=" + resp.statusCode() + ", body=" + body)
                                ))
                )
                .bodyToMono(String.class)
                .block();

        // 3 응답 파싱
        try {
            JsonNode root = objectMapper.readTree(raw);
            JsonNode candidates = root.path("candidates");
            if (!candidates.isArray() || candidates.isEmpty()) {
                throw new GeminiInvalidResponseException("candidates 비어있음. raw=" + raw);
            }
            JsonNode textNode = candidates.get(0)
                    .path("content").path("parts").get(0).path("text");

            if (textNode.isMissingNode() || !textNode.isTextual()) {
                throw new GeminiInvalidResponseException("parts[0].text 누락. raw=" + raw);
            }
            return textNode.asText();
        } catch (GeminiInvalidResponseException e) {
            throw e;
        } catch (Exception e) {
            throw new GeminiInvalidResponseException("JSON 파싱 실패: " + e.getMessage());
        }
    }

    private static String jsonEscape(String s) {
        return objectToJsonString(s);
    }

    private static String objectToJsonString(Object o) {
        try { return new ObjectMapper().writeValueAsString(o); }
        catch (Exception e) { throw new RuntimeException(e); }
    }

}
