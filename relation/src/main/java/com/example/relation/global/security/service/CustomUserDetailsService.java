// 패키지 선언: 이 클래스가 속한 패키지 위치를 지정합니다.
package com.example.relation.global.security.service;

// 사용자 정보를 관리하는 UserRepository 인터페이스를 가져옵니다.
import com.example.relation.domain.user.Repository.UserRepository;

// Lombok의 @RequiredArgsConstructor를 사용하여 final 필드에 대한 생성자를 자동 생성합니다.
import lombok.RequiredArgsConstructor;

// Spring Security에서 제공하는 UserDetails 인터페이스를 가져옵니다.
import org.springframework.security.core.userdetails.UserDetails;

// Spring Security에서 제공하는 UserDetailsService 인터페이스를 가져옵니다.
import org.springframework.security.core.userdetails.UserDetailsService;

// 사용자가 존재하지 않을 경우 발생하는 예외 클래스입니다.
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// 이 클래스가 Spring에서 서비스 컴포넌트로 관리되도록 @Service 애너테이션을 추가합니다.
import org.springframework.stereotype.Service;

// @Service: Spring에 의해 이 클래스가 서비스 계층의 빈으로 관리되도록 선언합니다.
// @RequiredArgsConstructor: Lombok을 사용하여 final 필드에 대한 생성자를 자동으로 생성합니다.
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    // 사용자 정보를 데이터베이스에서 조회하기 위한 UserRepository 인터페이스를 주입합니다.
    private final UserRepository userRepository;

    /**
     * UserDetailsService 인터페이스의 loadUserByUsername 메서드를 구현합니다.
     * 주어진 사용자 이름(username)을 기반으로 사용자 정보를 로드합니다.
     *
     * @param username 조회할 사용자의 사용자 이름
     * @return UserDetails 사용자의 인증 정보를 담은 객체
     * @throws UsernameNotFoundException 사용자가 데이터베이스에 존재하지 않을 경우 예외 발생
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // UserRepository를 사용하여 데이터베이스에서 username으로 사용자 정보를 조회합니다.
        // Optional로 감싸져 있는 결과를 처리하여 사용자 정보가 없을 경우 UsernameNotFoundException을 던집니다.
        return userRepository.findByUsername(username)
                // 사용자가 존재하지 않을 경우 예외를 발생시킵니다.
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
