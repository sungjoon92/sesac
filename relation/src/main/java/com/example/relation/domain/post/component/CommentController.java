package com.example.relation.domain.post.component;

import com.example.relation.domain.post.dto.PostResponseDto;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/components")
public class CommentController {
    private final CommentService commentService;


    // 댓글 생성
    @Transactional
    @PostMapping
    public ResponseEntity<ApiResponse<CommentResponseDto>> createComment(
            @PathVariable Long postId,
            @Valid @RequestBody CommentCreateRequestDto requestDto) {
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
    public ResponseEntity<ApiResponse<List<CommentResponseDto>>> createComment() {
        ApiResponse<List<CommentResponseDto>> response = ApiResponse.ok(commentService.readComment());
        return ResponseEntity.ok(response);
    }

    // 댓글 일부 조회
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CommentResponseDto>> readCommentById(@PathVariable Long id){
        ApiResponse<CommentResponseDto> response = ApiResponse.ok(commentService.readCommentById(id));
        return ResponseEntity.ok(response);
    };
}// class end
