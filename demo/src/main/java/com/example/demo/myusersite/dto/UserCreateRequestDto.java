package com.example.demo.myusersite.dto;

import com.example.demo.myusersite.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {

    private String username;

    private String email;

    private String nickname;

    private int age;

    @Builder
    public User toEntity() {
        return User.builder()
                .username(this.username)
                .email(this.email)
                .nickname(this.nickname)
                .age(this.age)
                .build();
    }// toEntity() end

}
