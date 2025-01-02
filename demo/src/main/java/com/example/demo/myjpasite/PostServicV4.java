package com.example.demo.myjpasite;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServicV4 {

    private final PostRepositoryV4 postRepositoryV4;

    public PostServicV4(PostRepositoryV4 postRepositoryV4) {
        this.postRepositoryV4 = postRepositoryV4;
    }

    @Transactional
    public PostResponseDto createPost(PostRequestDto postRequestDto) {
        PostV4 post = postRepositoryV4.save(postRequestDto.toEntity());
        return PostResponseDto.from(post);
    }

    public List<PostResponseDto> readPost(PostRequestDto postRequestDto) {
//        List<PostV4> all = postRepositoryV4.findAll();
        return postRepositoryV4.findAll().stream()
                .map(PostResponseDto::from)
                .toList();
    }
}
