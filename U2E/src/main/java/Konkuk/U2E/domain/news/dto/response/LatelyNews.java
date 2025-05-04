package Konkuk.U2E.domain.news.dto.response;

import java.util.List;

public record LatelyNews(
        Long newsId,
        List<String> regionList,
        List<String> climateList,
        String newsTitle
) {
    public static LatelyNews of(Long newsId, List<String> regionList, List<String> climateList, String newsTitle) {
        return new LatelyNews(
                newsId,
                regionList,
                climateList,
                newsTitle
        );
    }
}