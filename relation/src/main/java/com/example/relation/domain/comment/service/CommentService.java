package com.example.relation.domain.comment.service;

import com.example.relation.domain.comment.entity.Comment;
import com.example.relation.domain.comment.repository.CommentRepository;
import com.example.relation.domain.comment.dto.request.CommentRequestDto;
import com.example.relation.domain.comment.dto.response.CommentResponseDto;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.repository.PostRepository;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 댓글 작성
    @Transactional
    public CommentResponseDto createComment(Long postId, CommentRequestDto requestDto) {
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

    // 댓글 수정
    @Transactional
    public CommentResponseDto updateComment(Long postId, Long commentId, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException());

        comment.update(requestDto);
        return CommentResponseDto.from(comment);
    }


}
