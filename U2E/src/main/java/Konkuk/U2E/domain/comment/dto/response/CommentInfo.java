package Konkuk.U2E.domain.comment.dto.response;

public record CommentInfo(
        Long userId,
        String name,
        Long commentId,
        String contents
) { }