package com.example.demo.myusersite;

import com.example.demo.myusersite.dto.UserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // username으로 User 엔티티를 조회하는 메서드
    UserResponseDto findByUsername(String username);

    // 동일 나이의 모든 사용자 조회
    List<UserResponseDto> findAllByAge(int age);

}
