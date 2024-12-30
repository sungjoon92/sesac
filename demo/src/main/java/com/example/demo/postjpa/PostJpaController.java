package com.example.demo.postjpa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa/posts")
public class PostJpaController {
//    PostService postService = new PostService();

    // DI
    private final PostJpaService postJpaService;

    public PostJpaController(PostJpaService postJpaService) {
        this.postJpaService = postJpaService;
    }

    // 게시글 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostJpa createPost(@RequestBody PostJpa newPostJpa) {
        return postJpaService.createPost(newPostJpa);
    }// createPost() end

    // 게시글 조회
    @GetMapping
    public List<PostJpa> readPost() {
        return postJpaService.readPost();
    }// readPost() end

    // 해당 게시글 조회
    @GetMapping("{id}")
    public PostJpa readPostById(@PathVariable Long id) {
        return postJpaService.readPostById(id);
    }// readPostById() end

    // 해당 게시글 수정
    @PutMapping("{id}")
    public PostJpa updatePost(@PathVariable Long id, @RequestBody PostJpa newPostJpa) {
        return postJpaService.updatePost(id, newPostJpa);
    }// updatePost() end

    // 해당 게시글 삭제
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String  deletePost(@PathVariable Long id) {
        postJpaService.deletePost(id);
        return "삭제 완료";
    }// deletePost() end
}// class end
