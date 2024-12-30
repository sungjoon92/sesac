package com.example.demo.postMVC;

import com.example.demo.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mvc/posts")
public class PostController {
//    PostService postService = new PostService();


    // DI
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시글 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post newPost) {
        return postService.createPost(newPost);
    }// createPost() end

    // 게시글 조회
    @GetMapping
    public List<Post> readPost() {
        return postService.readPost();
    }

    // 해당 게시글 조회
    @GetMapping("{id}")
    public Post readPostById(@PathVariable Long id) {
        return postService.readPostById(id);
    }

    // 해당 게시글 수정
    @PutMapping("{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post newPost) {
        return postService.updatePost(id, newPost);
    }

    // 해당 게시글 삭제
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
