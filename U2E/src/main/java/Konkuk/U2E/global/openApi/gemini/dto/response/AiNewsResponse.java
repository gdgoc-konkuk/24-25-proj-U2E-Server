package Konkuk.U2E.global.openApi.gemini.dto.response;

import java.util.List;

public record AiNewsResponse(
        String solution,                   // 환경문제 솔루션 1가지
        List<RelatedArticle> related       // 관련 뉴스 3개
) {}
