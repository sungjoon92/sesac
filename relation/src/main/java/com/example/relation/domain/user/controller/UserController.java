package com.example.relation.domain.user.controller;

import com.example.relation.domain.post.dto.Post2ListPageResponseDto;
import com.example.relation.domain.user.dto.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.domain.user.service.UserService;
import com.example.relation.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저정보 확인
    @GetMapping("/my/profile")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(ApiResponse.ok(
                userService.getMyProfile(user)
        ));
    }// getMyProfile() end

    // 유저정보 확인(더 간결한 방식)
    @GetMapping("/my/profile2")
    public ResponseEntity<ApiResponse<UserResponseDto>> getMyProfile2(
            @AuthenticationPrincipal User user
    ){
        return ResponseEntity.ok(ApiResponse.ok(
                userService.getMyProfile(user)
        ));
    }

    // 로그인한 유저의 전체글 조회, 페이징
    @GetMapping("/my/posts")
    public ResponseEntity<ApiResponse<Post2ListPageResponseDto>> getMyPosts(
            @AuthenticationPrincipal User user,
            Pageable pageable
    ) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        userService.getMyPosts(user, pageable)
                )
        );
    }
}// class end