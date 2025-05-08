package Konkuk.U2E.domain.comment.controller;

import Konkuk.U2E.domain.comment.dto.request.PostCommentCreateRequest;
import Konkuk.U2E.domain.comment.dto.response.GetCommentsResponse;
import Konkuk.U2E.domain.comment.service.CommentService;
import Konkuk.U2E.global.annotation.LoginUser;
import Konkuk.U2E.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{newsId}")
    public BaseResponse<GetCommentsResponse> viewComments(@PathVariable("newsId") Long newsId) {
        return BaseResponse.ok(commentService.getCommentInfo(newsId));
    }

    @PostMapping
    public BaseResponse createComments(@LoginUser String username, @RequestBody PostCommentCreateRequest request) {
        commentService.createComment(username, request);
        return BaseResponse.ok();
    }
}
