package com.example.relation.global.config;

// 커스텀 접근 권한 처리 핸들러를 임포트합니다.
import com.example.relation.global.security.handler.CustomAccessDeniedHandler;

// JWT 인증 실패 시 처리 핸들러를 임포트합니다.
import com.example.relation.global.security.handler.JwtAuthenticationEntryPoint;

// JWT 토큰 인증 필터를 임포트합니다.
import com.example.relation.global.security.jwt.JwtAuthenticationFilter;

// Lombok의 @RequiredArgsConstructor를 사용하여 final 필드에 대한 생성자를 자동 생성합니다.
import lombok.RequiredArgsConstructor;

// 스프링의 @Bean 및 @Configuration 애너테이션을 임포트합니다.
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Spring Security에서 제공하는 AuthenticationManager 관련 클래스들을 임포트합니다.
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

// HTTP 요청 보안 설정을 위한 HttpSecurity를 임포트합니다.
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// WebSecurity 설정을 활성화하기 위해 @EnableWebSecurity 애너테이션을 임포트합니다.
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// 세션 정책 설정을 위한 SessionCreationPolicy를 임포트합니다.
import org.springframework.security.config.http.SessionCreationPolicy;

// 사용자 인증 정보를 처리하기 위한 UserDetailsService 인터페이스를 임포트합니다.
import org.springframework.security.core.userdetails.UserDetailsService;

// 비밀번호 암호화를 위한 BCryptPasswordEncoder 및 PasswordEncoder 인터페이스를 임포트합니다.
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Spring Security 필터 체인 관련 클래스를 임포트합니다.
import org.springframework.security.web.SecurityFilterChain;

// Spring Security의 기본 인증 필터를 임포트합니다.
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration: 이 클래스가 Spring의 설정 클래스로 인식되도록 선언합니다.
// @EnableWebSecurity: Spring Security의 웹 보안 기능을 활성화합니다.
// @RequiredArgsConstructor: Lombok을 사용하여 final 필드에 대한 생성자를 자동으로 생성합니다.
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    // CustomAccessDeniedHandler 주입: 권한 부족 시 처리하는 핸들러입니다.
    private final CustomAccessDeniedHandler accessDeniedHandler;

    // JwtAuthenticationEntryPoint 주입: 인증 실패 시 처리하는 핸들러입니다.
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    // JwtAuthenticationFilter 주입: 요청에서 JWT 토큰을 검증하는 필터입니다.
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * PasswordEncoder를 Bean으로 등록합니다.
     * Spring Security는 비밀번호를 저장하거나 인증할 때 반드시 암호화를 사용해야 합니다.
     * @return BCryptPasswordEncoder를 반환하여 비밀번호를 암호화합니다.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * SecurityFilterChain을 Bean으로 등록합니다.
     * HTTP 요청에 대한 보안 설정을 구성합니다.
     *
     * @param http HttpSecurity 객체로 보안 설정을 구성합니다.
     * @return SecurityFilterChain 객체를 반환합니다.
     * @throws Exception 설정 중 예외가 발생할 경우 처리합니다.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                // CSRF(Cross-Site Request Forgery) 보호를 비활성화합니다. (JWT를 사용하기 때문)
                .csrf(csrf -> csrf.disable())

                // 세션 관리를 Stateless 로 설정합니다. (JWT 기반 인증을 사용하기 때문)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // HTTP 요청에 대한 권한을 설정합니다.
                .authorizeHttpRequests(auth -> auth
                        // "/auth/**" 경로는 인증 없이 접근을 허용합니다.
                        .requestMatchers("/auth/**").permitAll()
                        // 그 외 모든 요청은 인증이 필요합니다.
                        .anyRequest().authenticated()
                )

                // JwtAuthenticationFilter 를 UsernamePasswordAuthenticationFilter 앞에 추가합니다.
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

                // 인증 실패 및 권한 부족 예외를 처리하는 핸들러를 등록합니다.
                .exceptionHandling(exception -> exception
                        // 권한 부족 예외 처리
                        .accessDeniedHandler(accessDeniedHandler)
                        // 인증 실패 예외 처리
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                );

        // SecurityFilterChain 객체를 빌드하여 반환합니다.
        return http.build();
    }

    /**
     * AuthenticationManager를 Bean으로 등록합니다.
     * DaoAuthenticationProvider를 사용하여 사용자 인증을 처리합니다.
     *
     * @param userDetailsService 사용자 정보를 로드하는 서비스
     * @param passwordEncoder 비밀번호 암호화를 위한 PasswordEncoder
     * @return AuthenticationManager 객체를 반환합니다.
     */
    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {

        // DaoAuthenticationProvider 생성: 사용자 인증 정보를 처리합니다.
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); // 사용자 정보를 로드하는 서비스 설정
        authProvider.setPasswordEncoder(passwordEncoder); // 비밀번호 암호화 설정

        // ProviderManager 생성: AuthenticationManager의 구현체로 DaoAuthenticationProvider를 사용합니다.
        return new ProviderManager(authProvider);
    }
}
