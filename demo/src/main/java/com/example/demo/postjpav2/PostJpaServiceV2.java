package com.example.demo.postjpav2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostJpaServiceV2 {
//    PostRepository postRepository = new PostRepository();

    // DI
    private final PostJpaRepositoryV2 postJpaRepositoryv2;

//    public PostJpaServiceV2(PostJpaRepositoryV2 postJpaRepositoryv2) {
//        this.postJpaRepositoryv2 = postJpaRepositoryv2;
//    }
//

    // 게시글 생성
    public PostJpaV2 createPost(PostJpaV2 newPostJpaV2) {
        // 컨트롤러에서 data를 입력받은후
        // validate 체크
        validatePostDate(newPostJpaV2);
        // post를 생성
        return postJpaRepositoryv2.save(newPostJpaV2);
    }// createPost() end`
//
//    // 게시글 전체 조회
//    public List<PostJpaV2> readPost() {
//        return postJpaRepositoryv2.findAll();
//    }// readPost() end
//
//    // 게시글 조회
//    public PostJpaV2 readPostById(Long id) {
//        PostJpaV2 post = postJpaRepositoryv2.findById(id)
//                .orElseThrow(()-> new IllegalArgumentException("id가 없습니다"));
//        return post;
//    }// readPostById() end
//
//    // 게시글 수정
//    public PostJpaV2 updatePost(Long id, PostJpaV2 updatePost) {
//        PostJpaV2 post = postJpaRepositoryv2.findById(id)
//                .orElseThrow(()->new IllegalArgumentException("id가 없습니다"));
//        validatePostDate(updatePost);
//
//        String title = updatePost.getTitle();
//        String content = updatePost.getContent();
//        return postJpaRepositoryv2.save(post.update(title,content));
//    }// updatePost() end
//
//    // 게시글 삭제
//    public void deletePost(Long id) {
//        PostJpaV2 post = postJpaRepositoryv2.findById(id)
//                .orElseThrow(()->new IllegalArgumentException("id가 없습니다"));
//        postJpaRepositoryv2.deleteById(id);
//    }// deletePost() end


//    // validation 체크
    public void validatePostDate(PostJpaV2 newPostJpaV2) {

        String title = newPostJpaV2.getTitle();
        String content = newPostJpaV2.getContent();

        if (title == null || title.isBlank()) {
            throw new RuntimeException("title을 입력해주세요");
        }// if end

        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content를 입력해주세요");
        }// if end
        //validation 체크를 한 후

    }
}
