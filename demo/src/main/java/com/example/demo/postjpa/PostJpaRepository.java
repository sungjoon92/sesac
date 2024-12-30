package com.example.demo.postjpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostJpaRepository extends JpaRepository<PostJpa, Long> {

}