package com.example.relation.domain.user.controller;

import com.example.relation.domain.user.dto.TokenResponseDto;
import com.example.relation.domain.user.dto.LoginRequestDto;
import com.example.relation.domain.user.dto.SignupRequestDto;
import com.example.relation.domain.user.dto.SignupResponseDto;
import com.example.relation.domain.user.service.AuthService;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupResponseDto>> signup(
            @Valid @RequestBody SignupRequestDto requestDto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok(
                        authService.signup(requestDto)
                )); // body() end
    }// signup() end

//    // 로그인
//    @PostMapping("/login")
//    public ResponseEntity<ApiResponse<TokenResponseDto>> login(
//            @Valid @RequestBody LoginRequestDto requestDto
//    ) {
//        return ResponseEntity.ok(ApiResponse.ok(
//                authService.login(requestDto)
//        ));
//    }// login() end
}