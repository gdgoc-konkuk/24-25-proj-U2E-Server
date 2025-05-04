package Konkuk.U2E.domain.news.dto.response;

import Konkuk.U2E.domain.news.domain.ClimateProblem;
import Konkuk.U2E.domain.news.domain.News;

import java.util.List;

public record LatelyNews(
        Long newsId,
        List<String> regionList,
        List<ClimateProblem> climateList,
        String newsTitle
) {
    public static LatelyNews of(List<ClimateProblem> climateList, List<String> regionList, News news) {
        return new LatelyNews(
                news.getNewsId(),
                regionList,
                climateList,
                news.getNewsTitle()
        );
    }
}