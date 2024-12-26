package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostApi {
    List<Post> posts = new ArrayList<Post>();
    private Long id = 0L;


    {
        // 인스턴스가 생성되었을 때 한번 실행된다
        // 초기값을 넣을 때 사용된다.
        posts.add(new Post(++id, "초기 제목", "초기 내용"));
    }

    // 글 생성
    @GetMapping("posts/create")
    public Post creaPost() {
        Post post = new Post(++id, "제목", "내용");
        posts.add(post);
        return post;
    }

    // 전체글 조회
    @GetMapping("/posts")
    public List<Post> readPosts() {
        return posts;
    }// readPosts end

    // 해당글 조회
    @GetMapping("/posts/{id}")
    public Post readPostById(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }// if end
        }// for end
        return null;
    }// readPostById() end


    @GetMapping("/posts/{id}/update")
    public Post updatePosts(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                post.setTitle("수정된 제목");
                post.setContent("수정된 내용");
                return post;
            }// if end
        }// for end
        return null;
    }// updatePosts() end

    @GetMapping("/posts/{id}/delete")
    public String deletePosts(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                posts.remove(post);
                return post.getId() + " 페이지 삭제 완료";
            }// if end
        }// for end
        return "존재하지 않는 페이지 입니다.";
    }// deletePosts() end
}// class end
