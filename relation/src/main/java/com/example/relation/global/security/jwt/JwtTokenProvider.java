package com.example.relation.global.security.jwt;

// --- JWT 생성 및 검증을 위한 라이브러리 ---
// JWT의 페이로드 데이터를 나타내는 객체로, JWT에서 사용자 정보 등을 추출할 때 사용.
import io.jsonwebtoken.Claims;
// JWT 처리 과정에서 발생하는 예외를 나타내는 클래스 (예: 토큰이 유효하지 않을 때 발생).
import io.jsonwebtoken.JwtException;
// JWT 생성, 서명, 파싱을 위한 유틸리티 클래스.
import io.jsonwebtoken.Jwts;
// JWT 서명에 사용되는 암호화 알고리즘을 정의하는 열거형.
import io.jsonwebtoken.SignatureAlgorithm;
// 안전한 키를 생성하거나 관리하기 위한 유틸리티 클래스.
import io.jsonwebtoken.security.Keys;

// --- Spring과 관련된 어노테이션 및 클래스 ---
// 빈(Bean) 초기화 이후 실행할 초기화 로직을 정의하는 어노테이션.
import jakarta.annotation.PostConstruct;
 // 외부 설정 파일(application.yml 등)에서 값을 주입받기 위한 어노테이션.
import org.springframework.beans.factory.annotation.Value;
// Spring Security에서 현재 인증된 사용자 정보를 나타내는 객체.
import org.springframework.security.core.Authentication;
// 해당 클래스를 Spring의 Bean으로 등록하기 위한 어노테이션.
import org.springframework.stereotype.Component;

// --- Java 기본 클래스들 ---
// 데이터를 Base64 방식으로 인코딩하거나 디코딩하는 데 사용하는 클래스.
import java.util.Base64;
// 날짜와 시간을 표현하는 클래스. JWT의 발급 시간(iat) 및 만료 시간(exp)을 설정할 때 사용.
import java.util.Date;


// @Component: 이 클래스를 Spring의 Bean으로 등록하여 DI(의존성 주입) 가능하게 합니다.
@Component
public class JwtTokenProvider {

    // @Value: application.properties 또는 application.yml에서 값을 주입받습니다.
    @Value("${jwt.secret}")
    private String secretKey; // JWT 토큰의 서명을 위한 비밀키

    // JWT 토큰의 유효기간 (1시간)
    private final long tokenValidityInMilliseconds = 1000L * 60 * 60;

    /**
     * @PostConstruct: 빈이 초기화된 후 실행되는 메서드입니다.
     * secretKey를 Base64로 인코딩하여 보안성을 강화합니다.
     */
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    /**
     * JWT 토큰을 생성하는 메서드입니다.
     *
     * @param authentication 인증 정보를 담고 있는 객체
     * @return 생성된 JWT 토큰 문자열
     */
    public String createToken(Authentication authentication) {
        // 인증 객체에서 사용자 이름(Principal)을 가져옵니다.
        String username = authentication.getName();

        // JWT 페이로드에 저장될 데이터를 설정합니다.
        Claims claims = Jwts.claims().setSubject(username);

        // 현재 시간과 만료 시간을 설정합니다.
        Date now = new Date();
        Date validity = new Date(now.getTime() + tokenValidityInMilliseconds);

        // JWT를 생성합니다.
        return Jwts.builder()
                .setClaims(claims) // 페이로드 설정
                .setIssuedAt(now) // 발급 시간 설정
                .setExpiration(validity) // 만료 시간 설정
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS256) // 서명
                .compact(); // JWT를 문자열로 반환
    }

    /**
     * JWT 토큰의 유효성을 검증하는 메서드입니다.
     *
     * @param token 검증할 JWT 토큰
     * @return 토큰이 유효하면 true, 그렇지 않으면 false
     */
    public boolean validateToken(String token) {
        try {
            // 토큰을 파싱하고 서명을 검증합니다.
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes())) // 서명 키 설정
                    .build()
                    .parseClaimsJws(token); // 토큰을 파싱
            return true; // 검증 성공 시 true 반환
        } catch (JwtException | IllegalArgumentException e) {
            // 서명 검증 실패 또는 파싱 중 예외 발생 시 false 반환
            return false;
        }
    }

    /**
     * JWT 토큰에서 사용자 이름(Subject)을 추출하는 메서드입니다.
     *
     * @param token JWT 토큰
     * @return 토큰에서 추출한 사용자 이름
     */
    public String getUsername(String token) {
        // 토큰에서 클레임(Claims)을 파싱하고 Subject를 반환합니다.
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes())) // 서명 키 설정
                .build()
                .parseClaimsJws(token) // 토큰 파싱
                .getBody() // 페이로드(Claims) 가져오기
                .getSubject(); // Subject(사용자 이름) 추출
    }
}
