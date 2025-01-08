package com.example.relation.domain.comment;

import com.example.relation.domain.post.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentRequestDto {
    @NotBlank
    private String content;

    @Builder
    public Comment toEntity(Post post) {
        return Comment.builder()
                .content(this.content)
                .post(post)
                .build();
    }
}
