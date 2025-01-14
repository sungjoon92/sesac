package com.example.relation.domain.user.Repository;

import com.example.relation.domain.user.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(@NotBlank(message = "아이디는 필수 입력값입니다.") String username);

    boolean existsByEmail(@NotBlank(message = "이메일은 필수 입력값입니다.") @Email(message = "이메일 형식이 올바르지 않습니다.") String email);
}
