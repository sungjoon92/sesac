package com.example.relation.global.security.jwt;

// HTTP 요청 및 응답 처리를 위한 클래스들을 임포트합니다.
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Lombok의 @RequiredArgsConstructor를 사용하여 final 필드에 대한 생성자를 자동 생성합니다.
import lombok.RequiredArgsConstructor;

// Spring Security에서 제공하는 인증 관련 클래스를 임포트합니다.
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

// Spring의 컴포넌트 스캔 대상임을 나타냅니다.
import org.springframework.stereotype.Component;

// 문자열 유틸리티 메서드를 제공하는 클래스입니다.
import org.springframework.util.StringUtils;

// HTTP 요청에 한 번만 적용되는 필터를 정의하기 위한 클래스입니다.
import org.springframework.web.filter.OncePerRequestFilter;

// IOException 및 ServletException 처리를 위해 임포트합니다.
import java.io.IOException;

// @Component: Spring의 Bean으로 등록되어 필터로 동작하도록 설정합니다.
// @RequiredArgsConstructor: Lombok을 사용하여 final 필드에 대한 생성자를 자동 생성합니다.
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // JWT 토큰을 생성 및 검증하는 기능을 제공하는 JwtTokenProvider를 주입합니다.
    private final JwtTokenProvider jwtTokenProvider;

    // Spring Security에서 제공하는 UserDetailsService를 주입합니다.
    // 사용자 정보를 로드하기 위해 사용됩니다.
    private final UserDetailsService userDetailsService;

    /**
     * 필터의 핵심 로직을 구현하는 메서드입니다.
     * 각 HTTP 요청마다 실행되며, JWT 토큰을 검증하고 인증 정보를 설정합니다.
     *
     * @param request  HTTP 요청 객체
     * @param response HTTP 응답 객체
     * @param filterChain 다음 필터로 요청을 전달하기 위한 객체
     * @throws ServletException 필터 실행 중 서블릿 관련 예외가 발생할 경우
     * @throws IOException 입출력 관련 예외가 발생할 경우
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 요청 헤더에서 JWT 토큰을 추출합니다.
        String token = getTokenFromRequest(request);

        // 토큰이 존재하고 유효한 경우
        if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {

            // 토큰에서 사용자 이름(username)을 추출합니다.
            String username = jwtTokenProvider.getUsername(token);

            // 사용자 이름으로 사용자 정보를 로드합니다.
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 사용자 인증 객체를 생성합니다.
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,            // 사용자 정보
                            null,                   // 인증된 사용자의 자격 증명 (보통 null로 설정)
                            userDetails.getAuthorities() // 사용자의 권한 정보
                    );

            // SecurityContext에 인증 객체를 설정하여 요청의 인증 상태를 유지합니다.
//            SecurityContextHolder.getContext().setAuthentication(authentication);
            SecurityContext context = SecurityContextHolder.createEmptyContext();

            context.setAuthentication(authentication);

            SecurityContextHolder.setContext(context);
        }

        // 다음 필터로 요청을 전달합니다.
        filterChain.doFilter(request, response);
    }

    /**
     * HTTP 요청 헤더에서 JWT 토큰을 추출하는 메서드입니다.
     * @param request HTTP 요청 객체
     * @return JWT 토큰 문자열 (Bearer 토큰 형식에서 접두사 제거)
     */
    private String getTokenFromRequest(HttpServletRequest request) {
        // Authorization 헤더에서 토큰 정보를 가져옵니다.
        String bearerToken = request.getHeader("Authorization");

        // 토큰이 존재하고 "Bearer "로 시작하는 경우, 접두사를 제거하고 반환합니다.
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        // 유효한 토큰이 없으면 null을 반환합니다.
        return null;
    }
}
