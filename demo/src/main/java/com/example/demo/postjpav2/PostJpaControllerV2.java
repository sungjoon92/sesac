package com.example.demo.postjpav2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v2/posts")
@RequiredArgsConstructor
public class PostJpaControllerV2 {
//    PostService postService = new PostService();

    private final PostJpaServiceV2 postJpaServicev2;

    // 게시글 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostJpaV2 createPost(@RequestBody PostJpaV2 newPostJpaV2) {
        return postJpaServicev2.createPost(newPostJpaV2);
    }// createPost() end

    // 게시글 조회
    @GetMapping
    public List<PostJpaV2> readPost() {
        return postJpaServicev2.readPost();
    }// readPost() end

    // 해당 게시글 조회
    @GetMapping("{id}")
    public PostJpaV2 readPostById(@PathVariable Long id) {
        return postJpaServicev2.readPostById(id);
    }// readPostById() end

    // 해당 게시글 수정
    @PutMapping("{id}")
    public PostJpaV2 updatePost(@PathVariable Long id, @RequestBody PostJpaV2 newPostJpaV2) {
        return postJpaServicev2.updatePost(id, newPostJpaV2);
    }// updatePost() end

    // 해당 게시글 삭제
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String  deletePost(@PathVariable Long id) {
        postJpaServicev2.deletePost(id);
        return "삭제 완료";
    }// deletePost() end
}// class end
