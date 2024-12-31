package com.example.demo.postjpav3;


import com.example.demo.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class PostJpaRepositoryV3 {

    private final EntityManager em;
    public PostJpaV3 save(PostJpaV3 post) {
        em.persist(post);
        return post;
    }// save() end


    public List<PostJpaV3> findAll() {
        return em.createQuery("SELECT p FROM PostJpaV3 p", PostJpaV3.class)
                .getResultList();
    }// findAll() end

    public PostJpaV3 postById(Long id) {
        return em.find(PostJpaV3.class, id);
    }// postById() end

    public PostJpaV3 update(Long id, PostJpaV3 postValue) {

        PostJpaV3 post = em.find(PostJpaV3.class, id);
        String title = postValue.getTitle();
        String content = postValue.getContent();
        post.update(title, content);
        return post;
    }// update() end

    public void delete(Long id) {
        PostJpaV3 post = em.find(PostJpaV3.class, id);
        em.remove(post);
    }// delete() end




}// class end