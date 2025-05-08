package Konkuk.U2E.domain.comment.exception;

import Konkuk.U2E.global.response.status.ResponseStatus;

public class CommentCreateException extends RuntimeException {
    private final ResponseStatus exceptionStatus;

    public CommentCreateException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}
