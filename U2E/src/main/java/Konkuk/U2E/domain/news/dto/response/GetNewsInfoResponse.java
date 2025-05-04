package Konkuk.U2E.domain.news.dto.response;

import Konkuk.U2E.domain.news.domain.Climate;
import Konkuk.U2E.domain.news.domain.ClimateProblem;
import Konkuk.U2E.domain.news.domain.News;

import java.util.List;

public record GetNewsInfoResponse(
        List<ClimateProblem> climateList,
        List<String> regionList,
        String newsTitle,
        String newsUrl,
        String newsImageUrl,
        String newsBody,
        String newsDate
) {
    public static GetNewsInfoResponse of(List<ClimateProblem> climateList, List<String> regionList, News news) {
        return new GetNewsInfoResponse(climateList, regionList, news.getNewsTitle(), news.getNewsUrl(), news.getImageUrl(), news.getNewsBody(), news.getNewsDate().toString());
    }
}
