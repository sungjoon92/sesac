package com.example.demo.postjpav3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostJpaServiceV3 {
    private final PostJpaRepositoryV3 postJpaRepositoryV3;

    @Transactional
    public PostJpaV3 createPost(PostJpaV3 post) {
        return postJpaRepositoryV3.save(post);
    }

    public List<PostJpaV3> readPost() {
        return postJpaRepositoryV3.findAll();
    }

    public PostJpaV3 readPostById(Long id) {
        return postJpaRepositoryV3.postById(id);
    }

    @Transactional
    public PostJpaV3 updatePost(Long id, PostJpaV3 postValue) {
        return postJpaRepositoryV3.update(id, postValue);
    }

    @Transactional
    public void deletePost(Long id) {
        postJpaRepositoryV3.delete(id);
    }
}
