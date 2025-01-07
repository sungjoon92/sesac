package com.example.relation.domain.post.component;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentResponseDto {
    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;

    public static CommentResponseDto from(Comment entity) {
        return CommentResponseDto.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .build();
    }

}
