package com.example.relation.domain.comment;

import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/comments")
public class CommentController {
    private final CommentService commentService;


    // 댓글 생성
    @Transactional
    @PostMapping
    public ResponseEntity<ApiResponse<CommentResponseDto>> createComment(
            @PathVariable Long postId,
            @Valid @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok(
                                "댓글이 정상적으로 작성되었습니다.",
                                "CREATED",
                                commentService.createComment(postId, requestDto)
                        )// ApiResponse.ok() end
                );// body() end
    }// createComment() end

    // 댓글 전체 조회
    @GetMapping
    public ResponseEntity<ApiResponse<List<CommentResponseDto>>> readComment() {
        ApiResponse<List<CommentResponseDto>> response = ApiResponse.ok(commentService.readComment());
        return ResponseEntity.ok(response);
    }

    // 댓글 일부 조회
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CommentResponseDto>> readCommentById(@PathVariable Long id){
        ApiResponse<CommentResponseDto> response = ApiResponse.ok(commentService.readCommentById(id));
        return ResponseEntity.ok(response);
    };


    @PutMapping("/{commentId}")
    public ResponseEntity<ApiResponse<CommentResponseDto>> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "댓글 수정 성공",
                        "UPDATE",
                        commentService.updateComment(postId, commentId, requestDto)
                )// ApiResponse.ok() end
        );// ResponseEntity.ok() end
    }// updateComment() end

}// class end
