package com.example.demo.myjpasite.dto;

import com.example.demo.myjpasite.PostV4;
import lombok.Getter;
import lombok.NoArgsConstructor;

// title, content, author를 받아다가
// 우리의 Post로 만드는 역할을 하겠어.
@Getter
@NoArgsConstructor
public class PostCreateRequestDto {
    private String title;
    private String content;
    private String author;

    public PostV4 toEntity(){
        return PostV4.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .build();
//        return new PostV4(title, content, author);
    }
}
