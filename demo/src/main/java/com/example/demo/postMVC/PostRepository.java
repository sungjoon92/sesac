package com.example.demo.postMVC;

import com.example.demo.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    List<Post> posts = new ArrayList<Post>();
    private Long id = 0L;

    // 저장. create
    public Post savePost(Post newPost) {
//        String title = newPost.getTitle();
//        String content = newPost.getContent();
//        Post post = new Post(++id, title, content);
        Post post = new Post(++id,newPost.getTitle(), newPost.getContent());
        posts.add(post);
        return post;
    }// savePost() end

    // 게시글 전체 조회
    public List<Post> readPost() {
        return posts;
    }// readPost() end

    // 게시글 조회
    public Post readPostById(Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }// if end
        }// for end
        return null;
    }// readPostById() end

    // 게시글 수정
    public Post updatePost(Long id, Post newPost) {

        String title = newPost.getTitle();
        String content = newPost.getContent();

        for (Post post : posts) {
            post.setTitle(title);
            post.setContent(content);
            return post;
        }
        return null;
    }

    // 게시글 삭제
    public void deletePost(Post post) {
        posts.remove(post);
    }// deletePost() end


//    public String  deletePost(Long id) {
//        for (Post post : posts) {
//            if (post.getId().equals(id)) {
//                posts.remove(post);
//                return post.getId() + " 페이지 삭제 완료";
//            }// if end
//        }// for end
//        return "페이지가 존재하지 않습니다.";
//    }// deletePost() end

}
