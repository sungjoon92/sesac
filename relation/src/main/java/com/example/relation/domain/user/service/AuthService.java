package com.example.relation.domain.user.service;

import com.example.relation.domain.user.dto.TokenResponseDto;
import com.example.relation.domain.user.Repository.UserRepository;
import com.example.relation.domain.user.dto.LoginRequestDto;
import com.example.relation.domain.user.dto.SignupRequestDto;
import com.example.relation.domain.user.dto.SignupResponseDto;
import com.example.relation.domain.user.entity.User;
//import com.example.relation.global.security.jwt.JwtTokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
//    private final JwtTokenProvider jwtTokenProvider;
    
    // 회원가입
    @Transactional
    public SignupResponseDto signup(SignupRequestDto requestDto) {
        if (userRepository.existsByUsername(requestDto.getUsername())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        User user = requestDto.toEntity(encodedPassword);

        return SignupResponseDto.from(userRepository.save(user));
    }

    // 로그인
//    public TokenResponseDto login(LoginRequestDto requestDto){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        requestDto.getUsername(),
//                        requestDto.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtTokenProvider.createToken(authentication);
//
//        return new TokenResponseDto(jwt);
//    }

}