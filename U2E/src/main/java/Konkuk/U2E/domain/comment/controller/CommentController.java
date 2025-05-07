package Konkuk.U2E.domain.comment.controller;

import Konkuk.U2E.domain.comment.dto.response.GetCommentsResponse;
import Konkuk.U2E.domain.comment.service.CommentService;
import Konkuk.U2E.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{newsId}")
    public BaseResponse<GetCommentsResponse> viewComments(@PathVariable("newsId") Long newsId) {
        return BaseResponse.ok(commentService.getCommentInfo(newsId));
    }
}
