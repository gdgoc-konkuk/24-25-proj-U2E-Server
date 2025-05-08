package Konkuk.U2E.domain.user.exception;

import Konkuk.U2E.global.response.status.ResponseStatus;
import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final ResponseStatus exceptionStatus;

    public UserNotFoundException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }
}
