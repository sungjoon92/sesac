package com.example.demo.myjpasite;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostListResponseDto {
    private final Long id;
    private final String title;


    public static PostListResponseDto from(PostV4 entity) {
        return PostListResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }// from() end
}
