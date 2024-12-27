package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
    private Long id;
    private String title;
    private String content;

    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    // 생성자 추가
    // 모든 필드에 대한 setter / getter 추가
}