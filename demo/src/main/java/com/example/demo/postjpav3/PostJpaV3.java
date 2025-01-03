package com.example.demo.postjpav3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpaV3 {
    @Id
    // sql의 autoincrement 기능
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;


    public PostJpaV3 update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }

}

//복수