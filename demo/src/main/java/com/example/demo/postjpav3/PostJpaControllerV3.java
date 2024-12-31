package com.example.demo.postjpav3;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa/v3/posts")
@RequiredArgsConstructor
public class PostJpaControllerV3 {
//    PostService postService = new PostService();

    private final PostJpaServiceV3 postJpaServicev3;

    // 게시글 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostJpaV3 createPost(@RequestBody PostJpaV3 newPostJpaV3) {
        return postJpaServicev3.createPost(newPostJpaV3);
    }// createPost() end

    // 게시글 조회
    @GetMapping
    public List<PostJpaV3> readPost() {
        return postJpaServicev3.readPost();
    }// readPost() end

    // 해당 게시글 조회
    @GetMapping("{id}")
    public PostJpaV3 readPostById(@PathVariable Long id) {
        return postJpaServicev3.readPostById(id);
    }// readPostById() end

    // 해당 게시글 수정
    @PutMapping("{id}")
    public PostJpaV3 updatePost(@PathVariable Long id, @RequestBody PostJpaV3 postValue) {
        return postJpaServicev3.updatePost(id, postValue);
    }// updatePost() end

    // 해당 게시글 삭제
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String  deletePost(@PathVariable Long id) {
        postJpaServicev3.deletePost(id);
        return "삭제 완료";
    }// deletePost() end
}// class end
