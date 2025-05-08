package Konkuk.U2E.domain.comment.service;

import Konkuk.U2E.domain.comment.domain.Comment;
import Konkuk.U2E.domain.comment.dto.request.PostCommentCreateRequest;
import Konkuk.U2E.domain.comment.dto.response.CommentInfo;
import Konkuk.U2E.domain.comment.dto.response.GetCommentsResponse;
import Konkuk.U2E.domain.comment.exception.CommentCreateException;
import Konkuk.U2E.domain.comment.repository.CommentRepository;
import Konkuk.U2E.domain.news.domain.News;
import Konkuk.U2E.domain.news.exception.NewsNotFoundException;
import Konkuk.U2E.domain.news.repository.NewsRepository;
import Konkuk.U2E.domain.user.domain.User;
import Konkuk.U2E.domain.user.exception.UserNotFoundException;
import Konkuk.U2E.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static Konkuk.U2E.global.response.status.BaseExceptionResponseStatus.*;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    public GetCommentsResponse getCommentInfo(Long newsId) {
        newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException(NEWS_NOT_FOUND));

        return GetCommentsResponse.of(commentRepository.findCommentsByNewsId(newsId).stream()
                .map(CommentInfo::of)
                .toList()
        );
    }

    public void createComment(String username, PostCommentCreateRequest request) {
        User user = userRepository.findUserByName(username);
        if (user == null) {
            throw new UserNotFoundException(USER_NOT_FOUND);
        }

        News news = newsRepository.findById(request.newsId())
                .orElseThrow(() -> new NewsNotFoundException(NEWS_NOT_FOUND));

        try {
            Comment comment = Comment.builder()
                    .contents(request.contents())
                    .news(news)
                    .user(user).build();

            commentRepository.save(comment);
        } catch (Exception e) {
            throw new CommentCreateException(COMMENT_CREATE_FAILED);
        }
    }

}