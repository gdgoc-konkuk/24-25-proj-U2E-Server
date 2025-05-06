package Konkuk.U2E.domain.news.service;

import Konkuk.U2E.domain.news.domain.Climate;
import Konkuk.U2E.domain.news.domain.ClimateProblem;
import Konkuk.U2E.domain.news.dto.response.GetLatelyNewsResponse;
import Konkuk.U2E.domain.news.dto.response.LatelyNews;
import Konkuk.U2E.domain.news.repository.ClimateRepository;
import Konkuk.U2E.domain.news.repository.NewsPinRepository;
import Konkuk.U2E.domain.news.repository.NewsRepository;
import Konkuk.U2E.domain.news.service.mapper.NewsMapperFactory;
import Konkuk.U2E.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsLatelyService {

    private final NewsRepository newsRepository;
    private final NewsMapperFactory newsMapperFactory;

    //news의 최신 뉴스 5개를 가져오는 서비스
    public GetLatelyNewsResponse getLatelyNews() {
        return GetLatelyNewsResponse.of(newsRepository.findTop5ByOrderByNewsDateDesc().stream()
                .map(newsMapperFactory.newsMappingFunction())
                .map(LatelyNews::of)
                .toList()
        );
    }
}
