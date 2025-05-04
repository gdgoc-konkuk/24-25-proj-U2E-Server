package Konkuk.U2E.domain.news.service;

import Konkuk.U2E.domain.news.domain.Climate;
import Konkuk.U2E.domain.news.domain.ClimateProblem;
import Konkuk.U2E.domain.news.domain.News;
import Konkuk.U2E.domain.news.dto.response.GetNewsInfoResponse;
import Konkuk.U2E.domain.news.exception.NewsNotFoundException;
import Konkuk.U2E.domain.news.repository.ClimateRepository;
import Konkuk.U2E.domain.news.repository.NewsPinRepository;
import Konkuk.U2E.domain.news.repository.NewsRepository;
import Konkuk.U2E.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static Konkuk.U2E.global.response.status.BaseExceptionResponseStatus.NEWS_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class NewsInfoService {

    private final NewsRepository newsRepository;
    private final ClimateRepository climateRepository;
    private final NewsPinRepository newsPinRepository;

    public BaseResponse<GetNewsInfoResponse> getNewsInfo(Long newsId) {

        News news = newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException(NEWS_NOT_FOUND));

        List<String> regionNameByNews = newsPinRepository.findRegionNameByNews(news.getNewsId());

        List<ClimateProblem> climateProblems = climateRepository.findClimatesByNews(news).stream()
                .map(Climate::getClimateProblem)
                .toList();

        return BaseResponse.ok(GetNewsInfoResponse.of(climateProblems, regionNameByNews, news));
    }
}
