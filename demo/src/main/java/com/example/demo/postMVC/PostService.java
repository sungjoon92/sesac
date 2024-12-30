package com.example.demo.postMVC;

import com.example.demo.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
//    PostRepository postRepository = new PostRepository();
    // DI
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    // 게시글 생성
    public Post createPost(Post newPost) {
        // 컨트롤러에서 data를 입력받은후
        // validate 체크
        validatePostDate(newPost);
        // post를 생성
        return postRepository.savePost(newPost);
    }// createPost() end`

    // 게시글 전체 조회
    public List<Post> readPost() {
        return postRepository.readPost();
    }// readPost() end

    // 게시글 조회
    public Post readPostById(Long id) {
        Post post = postRepository.readPostById(id);
        checkPostIsNull(post);
        return postRepository.readPostById(id);
    }// readPostById() end

    // 게시글 수정
    public Post updatePost(Long id, Post newPost) {
        Post post = postRepository.readPostById(id);
        checkPostIsNull(post);
        validatePostDate(newPost);
        return postRepository.updatePost(id, newPost);
    }// updatePost() end

    // 게시글 삭제
    public void deletePost(Long id) {
        Post post = postRepository.readPostById(id);
        checkPostIsNull(post);
        postRepository.deletePost(post);
    }// deletePost() end

    // post 가 null 인지
    public void checkPostIsNull(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("없는 id입니다");
        }// if end
    }

    // validation 체크
    public void validatePostDate(Post newPost) {

        String title = newPost.getTitle();
        String content = newPost.getContent();

        if (title == null || title.isBlank()) {
            throw new RuntimeException("title을 입력해주세요");
        }// if end

        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content를 입력해주세요");
        }// if end
        //validation 체크를 한 후

    }
}
