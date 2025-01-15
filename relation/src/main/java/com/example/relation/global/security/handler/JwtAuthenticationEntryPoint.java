package com.example.relation.global.security.handler;

// 프로젝트의 전역적인 응답을 처리하는 ApiResponse 클래스를 가져옵니다.
import com.example.relation.global.response.ApiResponse;

// JSON 데이터를 처리하기 위해 Jackson 라이브러리의 ObjectMapper를 가져옵니다.
import com.fasterxml.jackson.databind.ObjectMapper;

// 서블릿 요청 객체(HttpServletRequest)와 응답 객체(HttpServletResponse)를 사용하기 위해 임포트합니다.
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 인증 관련 예외(AuthenticationException)를 처리하기 위해 Spring Security에서 제공하는 클래스를 가져옵니다.
import org.springframework.security.core.AuthenticationException;

// Spring Security의 AuthenticationEntryPoint 인터페이스를 구현하기 위해 임포트합니다.
import org.springframework.security.web.AuthenticationEntryPoint;

// 이 클래스가 Spring 컴포넌트로 인식되도록 @Component 애너테이션을 추가합니다.
import org.springframework.stereotype.Component;

// IOException 처리를 위해 Java 표준 라이브러리를 임포트합니다.
import java.io.IOException;

// @Component: Spring에 의해 이 클래스가 빈으로 관리되도록 선언합니다.
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    // ObjectMapper 객체 생성: Java 객체를 JSON으로 변환하거나 JSON을 Java 객체로 변환하는 데 사용됩니다.
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * AuthenticationEntryPoint 인터페이스의 메서드를 구현합니다.
     * 인증되지 않은 사용자가 보호된 리소스에 접근하려 할 때 호출됩니다.
     *
     * @param request       클라이언트의 HTTP 요청 객체
     * @param response      클라이언트에 반환할 HTTP 응답 객체
     * @param authException 인증 관련 예외 객체
     * @throws IOException 입출력 예외 발생 시 처리
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        // 응답의 Content-Type을 JSON 형식으로 설정하고, 문자 인코딩을 UTF-8로 지정합니다.
        response.setContentType("application/json;charset=UTF-8");

        // 응답 상태 코드를 401(Unauthorized)로 설정합니다.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // ApiResponse 클래스의 static 메서드 'error'를 호출하여 에러 응답 객체를 생성합니다.
        // 첫 번째 매개변수는 사용자에게 전달할 에러 메시지("인증이 필요합니다."),
        // 두 번째 매개변수는 에러 코드를 나타냅니다("UNAUTHORIZED").
        ApiResponse<Void> errorResponse = ApiResponse.error("인증이 필요합니다.", "UNAUTHORIZED");

        // ObjectMapper를 사용하여 errorResponse 객체를 JSON 문자열로 변환한 뒤,
        // HTTP 응답 본문에 작성합니다.
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }
}
