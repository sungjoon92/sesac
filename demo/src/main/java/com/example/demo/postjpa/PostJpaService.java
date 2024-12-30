package com.example.demo.postjpa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostJpaService {
//    PostRepository postRepository = new PostRepository();

    // DI
    private final PostJpaRepository postJpaRepository;

    public PostJpaService(PostJpaRepository postJpaRepository) {
        this.postJpaRepository = postJpaRepository;
    }


    // 게시글 생성
    public PostJpa createPost(PostJpa newPostJpa) {
        // 컨트롤러에서 data를 입력받은후
        // validate 체크
        validatePostDate(newPostJpa);
        // post를 생성
        return postJpaRepository.save(newPostJpa);
    }// createPost() end`

    // 게시글 전체 조회
    public List<PostJpa> readPost() {
        return postJpaRepository.findAll();
    }// readPost() end

    // 게시글 조회
    public PostJpa readPostById(Long id) {
        PostJpa post = postJpaRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("id가 없습니다"));;
        return post;
    }// readPostById() end

    // 게시글 수정
    public PostJpa updatePost(Long id, PostJpa updatePost) {
        PostJpa post = postJpaRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id가 없습니다"));
        validatePostDate(updatePost);

        String title = updatePost.getTitle();
        String content = updatePost.getContent();
        return postJpaRepository.save(post.update(title,content));
    }// updatePost() end

    // 게시글 삭제
    public void deletePost(Long id) {
        PostJpa post = postJpaRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id가 없습니다"));
        postJpaRepository.deleteById(id);
    }// deletePost() end


//    // validation 체크
    public void validatePostDate(PostJpa newPostJpa) {

        String title = newPostJpa.getTitle();
        String content = newPostJpa.getContent();

        if (title == null || title.isBlank()) {
            throw new RuntimeException("title을 입력해주세요");
        }// if end

        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content를 입력해주세요");
        }// if end
        //validation 체크를 한 후

    }
}
