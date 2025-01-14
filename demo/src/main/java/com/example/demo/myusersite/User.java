package com.example.demo.myusersite;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity{

    @Id
    @NotNull
    @Column(nullable = false, updatable = false)
    @Length(min = 3, max = 20)
    private String username;

    @NotNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false, unique = false)
    @Length(min = 2, max = 10)
    private String nickname;

    @Min(0)
    @Max(150)
    private int age;

    @NotNull
    @Column(nullable = false)
    private boolean isActive = true;

    @Builder
    public User( String username, String email, String nickname, int age) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.age = age;
    }
}// class end
