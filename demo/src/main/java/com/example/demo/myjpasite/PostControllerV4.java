package com.example.demo.myjpasite;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v4/posts")
@RequiredArgsConstructor
public class PostControllerV4 {
    private final PostServicV4 postServicV4;

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postServicV4.createPost(postRequestDto);
    }

    @GetMapping
    public List<PostListResponseDto> readPost() {
        return postServicV4.readPost();
    }
}
