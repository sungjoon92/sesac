package com.example.relation.domain.post.component;

import com.example.relation.domain.post.Post;
import com.example.relation.domain.post.PostRepository;
import com.example.relation.domain.post.dto.PostResponseDto;
import com.example.relation.global.exception.ResourceNotFoundException;
import com.example.relation.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 댓글 작성
    @Transactional
    public CommentResponseDto createComment(Long postId, CommentCreateRequestDto requestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException());
        Comment comment = requestDto.toEntity(post);
        return CommentResponseDto.from(commentRepository.save(comment));
    }

    // 댓글 전체 조회
    public List<CommentResponseDto> readComment(){
        return commentRepository.findAll().stream()
                .map(CommentResponseDto::from)
                .toList();
    };

    // 댓글 일부 조회
    public CommentResponseDto readCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        return CommentResponseDto.from(comment);
    }


}
