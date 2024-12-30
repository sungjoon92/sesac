package com.example.demo.postjpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "postJpa")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostJpa {
    @Id
    // sql의 autoincrement 기능
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;


    public PostJpa update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }

}