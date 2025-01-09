package com.example.relation.domain.post.dto;

import com.example.relation.domain.comment.Comment;
import com.example.relation.domain.comment.CommentResponseDto;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.tag.Tag;
import com.example.relation.domain.tag.dto.TagResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostWithCommentAndTagResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final List<CommentResponseDto> comments;
//    private final List<String> tags;
    private final List<TagResponseDto> tags;

    public static PostWithCommentAndTagResponseDto from(Post entity, List<Comment> comments) {
        return PostWithCommentAndTagResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .comments(
                        entity.getComments().stream().map(CommentResponseDto::from).toList()
                )
                .tags(
                        entity.getPostTags().stream()
                        .map(
                                postTag -> TagResponseDto.from(postTag.getTag())
//                                postTag -> postTag.getTag().getName()
                        )
                        .toList()
                )
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}

