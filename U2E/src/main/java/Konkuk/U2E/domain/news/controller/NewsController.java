package Konkuk.U2E.domain.news.controller;

import Konkuk.U2E.domain.news.dto.response.GetLatelyNewsResponse;
import Konkuk.U2E.domain.news.service.NewsLatelyService;
import Konkuk.U2E.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsLatelyService newsLatelyService;

    @GetMapping("/lately")
    public BaseResponse<GetLatelyNewsResponse> viewLatelyNewsList() {
        return newsLatelyService.getLatelyNews();
    }
}
