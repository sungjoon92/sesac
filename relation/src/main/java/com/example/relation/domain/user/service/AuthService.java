package com.example.relation.domain.user.service;

// 필요한 의존성 및 클래스 임포트
import com.example.relation.domain.user.Repository.UserRepository;
import com.example.relation.domain.user.dto.request.LoginRequestDto;
import com.example.relation.domain.user.dto.request.SignupRequestDto;
import com.example.relation.domain.user.dto.response.SignupResponseDto;
import com.example.relation.domain.user.dto.response.TokenResponseDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
// @RequiredArgsConstructor: Lombok 어노테이션으로, final 필드에 대해 생성자를 자동으로 생성합니다.
@RequiredArgsConstructor
// @Transactional(readOnly = true): 기본적으로 읽기 전용 트랜잭션으로 설정합니다.
@Transactional(readOnly = true)
public class AuthService {

    private final UserRepository userRepository; // 사용자 정보를 관리하는 Repository
    private final PasswordEncoder passwordEncoder; // 비밀번호 암호화를 처리하는 인터페이스
    private final AuthenticationManager authenticationManager; // 인증 요청을 처리하는 Manager
    private final JwtTokenProvider jwtTokenProvider; // JWT 토큰 생성 및 검증을 위한 컴포넌트

    /**
     * 회원가입 메서드
     *
     * @param requestDto 회원가입 요청 데이터
     * @return SignupResponseDto 회원가입 완료 후 반환되는 응답 데이터
     */
    @Transactional // 쓰기 작업이 포함되므로 읽기 전용 트랜잭션에서 제외합니다.
    public SignupResponseDto signup(SignupRequestDto requestDto) {
        // 사용자 이름 중복 확인
        if (userRepository.existsByUsername(requestDto.getUsername())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        // 이메일 중복 확인
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        // 비밀번호를 암호화합니다.
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        // DTO를 엔티티(User)로 변환 후 저장합니다.
        User user = requestDto.toEntity(encodedPassword);

        // 저장된 엔티티를 기반으로 응답 DTO를 생성하여 반환합니다.
        return SignupResponseDto.from(userRepository.save(user));
    }

    /**
     * 로그인 메서드
     *
     * @param requestDto 로그인 요청 데이터
     * @return TokenResponseDto JWT 토큰이 포함된 응답 데이터
     */
    public TokenResponseDto login(LoginRequestDto requestDto) {
        // 사용자가 입력한 인증 정보를 기반으로 인증을 수행합니다.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestDto.getUsername(), // 사용자 이름
                        requestDto.getPassword()  // 비밀번호
                )
        );

        // 인증된 사용자 정보를 SecurityContext에 저장합니다.
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 인증 정보를 기반으로 JWT 토큰을 생성합니다.
        String jwt = jwtTokenProvider.createToken(authentication);

        // 생성된 JWT 토큰을 응답 DTO로 반환합니다.
        return new TokenResponseDto(jwt);
    }
}
