package com.example.relation.domain.comment.entity;

import com.example.relation.domain.comment.dto.request.CommentRequestDto;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.validator.NoProfanity;
import com.example.relation.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 커스텀 어노테이션
    @NoProfanity
//    @NoProfanity(message = "욕설이 포함되어 있습니다!")
    private String content;


    // post와의 연관관계
    // table : post_id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Comment(String content, Post post) {
        this.content = content;
        setPost(post);
    }

    // test용
    public void setPost(Post post) {
        this.post = post;
        post.getComments().add(this);
//        post.getComments().add(comment);
    }

    // 댓글 수정
    public Comment update(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
        return this;
    }


    
    
}
