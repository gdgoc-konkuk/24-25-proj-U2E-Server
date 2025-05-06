package Konkuk.U2E.domain.user.dto.request;

public record LoginRequest(
        String name,
        String password
) {}