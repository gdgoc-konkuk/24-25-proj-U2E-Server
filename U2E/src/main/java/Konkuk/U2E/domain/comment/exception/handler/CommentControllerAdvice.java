package Konkuk.U2E.domain.comment.exception.handler;

import Konkuk.U2E.domain.comment.exception.CommentCreateException;
import Konkuk.U2E.global.response.BaseErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static Konkuk.U2E.global.response.status.BaseExceptionResponseStatus.COMMENT_CREATE_FAILED;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RestControllerAdvice(basePackages = "Konkuk.U2E.domain.comment")
public class CommentControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CommentCreateException.class)
    public BaseErrorResponse handleCommentCreateException(CommentCreateException e) {
        log.error("[handle_CommentCreateException]", e);
        return new BaseErrorResponse(COMMENT_CREATE_FAILED, e.getMessage());
    }
}
