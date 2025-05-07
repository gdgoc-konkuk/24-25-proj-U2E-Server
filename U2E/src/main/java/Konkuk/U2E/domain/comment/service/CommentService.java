package Konkuk.U2E.domain.comment.service;

import Konkuk.U2E.domain.comment.dto.response.CommentInfo;
import Konkuk.U2E.domain.comment.dto.response.GetCommentsResponse;
import Konkuk.U2E.domain.comment.repository.CommentRepository;
import Konkuk.U2E.domain.news.exception.NewsNotFoundException;
import Konkuk.U2E.domain.news.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static Konkuk.U2E.global.response.status.BaseExceptionResponseStatus.NEWS_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final NewsRepository newsRepository;

    public GetCommentsResponse getCommentInfo(Long newsId) {
        newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException(NEWS_NOT_FOUND));

        return GetCommentsResponse.of(commentRepository.findCommentsByNewsId(newsId).stream()
                .map(c -> new CommentInfo(
                        c.getUser().getUserId(),
                        c.getUser().getName(),
                        c.getCommentId(),
                        c.getContents()
                )).toList()
        );
    }
}
