package Konkuk.U2E.domain.user.dto.response;

public record LoginResponse(
        Long userId,
        String token
) {
    public static LoginResponse of(Long userId, String token) {
        return new LoginResponse(userId, token);
    }
}