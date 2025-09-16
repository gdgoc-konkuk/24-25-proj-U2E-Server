package Konkuk.U2E.domain.news.service;

import Konkuk.U2E.global.openApi.gemini.GeminiClient;
import Konkuk.U2E.global.openApi.gemini.dto.request.AiNewsRequest;
import Konkuk.U2E.global.openApi.gemini.dto.response.AiNewsResponse;
import Konkuk.U2E.global.openApi.gemini.dto.response.RelatedArticle;
import Konkuk.U2E.global.openApi.gemini.exception.GeminiInvalidResponseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsInsightService {

    private final GeminiClient geminiClient;
    private final ObjectMapper mapper = new ObjectMapper();

    public AiNewsResponse analyze(AiNewsRequest req) {
        String locale = (req.locale() == null || req.locale().isBlank()) ? "ko" : req.locale();

        String systemPrompt = """
        You are an expert climate reporter assistant.
        Return ONLY valid JSON that matches this schema (no markdown):
        {
          "solution": "string, 1 concise, practical mitigation measure tailored to the article",
          "related": [
            {"title": "string", "url": "string"},
            {"title": "string", "url": "string"},
            {"title": "string", "url": "string"}
          ]
        }
        Language: %s
        Output must be actionable (no generic platitudes). If URLs are uncertain, return best authoritative sources.
        """.formatted(locale);

        String userPrompt = """
        기사 본문:
        ---
        %s
        ---

        요구사항:
        1) 이 기사에서 다루는 환경 문제(예: 산불 위험)에 대해 시민/지자체가 바로 실행할 수 있는 '핵심 솔루션 1가지'만 제시.
           - 한 문단, 2~4문장, 구체적 행동/운영 포인트 포함.
        2) 같은 주제를 다룬 '관련 뉴스 3개'의 제목과 URL을 제시.
           - 가급적 최근 영국/유럽 공신력 매체 우선, 없으면 국제 기관/정부도 허용.
        """.formatted(req.body());

        String jsonText = geminiClient.generateContentJson(systemPrompt, userPrompt);

        // JSON → DTO로 변환
        try {
            JsonNode root = mapper.readTree(jsonText);

            if (!root.has("solution") || !root.has("related")) {
                throw new GeminiInvalidResponseException("필수 필드(solution/related) 누락. text=" + jsonText);
            }

            String solution = root.path("solution").asText();
            if (solution == null || solution.isBlank()) {
                throw new GeminiInvalidResponseException("solution 값이 비어있음. text=" + jsonText);
            }

            List<RelatedArticle> related = new ArrayList<>();
            JsonNode arr = root.path("related");
            if (!arr.isArray()) {
                throw new GeminiInvalidResponseException("related가 배열이 아님. text=" + jsonText);
            }
            for (int i = 0; i < Math.min(3, arr.size()); i++) {
                JsonNode it = arr.get(i);
                String title = it.path("title").asText();
                String url = it.path("url").asText();
                if (title == null || title.isBlank() || url == null || url.isBlank()) {
                    throw new GeminiInvalidResponseException("related 항목의 title/url 누락. item=" + it.toString());
                }
                related.add(new RelatedArticle(title, url));
            }

            return new AiNewsResponse(solution, related);
        } catch (GeminiInvalidResponseException e) {
            throw e;
        } catch (Exception e) {
            throw new GeminiInvalidResponseException("JSON 역직렬화 실패: " + e.getMessage() + " | text=" + jsonText);
        }
    }

}
