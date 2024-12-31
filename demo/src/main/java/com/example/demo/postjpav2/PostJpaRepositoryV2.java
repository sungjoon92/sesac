package com.example.demo.postjpav2;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class PostJpaRepositoryV2{

    @PersistenceUnit
    private final EntityManagerFactory emf;

    public PostJpaV2 save(PostJpaV2 post) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(post); // 저장
            tx.commit();
            return post;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }finally {
            em.close();
        }// try end
    }// save() end
}