package com.example.relation.domain.example;


import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.PostRepository;
import com.example.relation.domain.post.dto.PostWithCommentResponseDtoV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

    private final PostRepository postRepository;

    @GetMapping("/basic/{postId}")
    public void LoadingExample1(@PathVariable Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        int commentSize = post.getComments().size();
    }

    // fetch JOIN해서 데이터를 한번에 가져올 수 있음
    @GetMapping("/fetch/{postId}")
    public void LoadingExample2(@PathVariable Long postId) {
        Post post = postRepository.findByIdWithCommentFetch(postId).orElseThrow();
        int commentSize = post.getComments().size();
    }

    @GetMapping("/nplus1/basic")
    public void LoadingExample3() {
        List<Post> posts = postRepository.findAll();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }

    @GetMapping("/nplus1/fetch")
    public void LoadingExample4() {
        List<Post> posts = postRepository.findAllWithCommentFetch();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }

    @GetMapping("/nplus1/entity-graph")
    public void LoadingExample5() {
        List<Post> posts = postRepository.findAllWithCommentEntityGraph();
        posts.stream().map(PostWithCommentResponseDtoV2::from).toList();
    }
}
