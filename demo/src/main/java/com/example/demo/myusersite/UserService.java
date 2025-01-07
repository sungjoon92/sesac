package com.example.demo.myusersite;

import com.example.demo.myusersite.dto.UserCreateRequestDto;
import com.example.demo.myusersite.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(UserCreateRequestDto requestDto) {

        User user = userRepository.save(requestDto.toEntity());
        return UserResponseDto.from(user);
    }// createUser() end


    public List<UserResponseDto> readUser() {
        return userRepository.findAll().stream().map(UserResponseDto::from).toList();
    }// readUser() end

    public List<UserResponseDto> searchUsers(String username, int age) {
        if (username == null || username.isBlank()) {
            // username이 비어있거나 공백이면 age로만 조회
            return userRepository.findAllByAge(age);
        } else {
            // username이 있으면 username으로 조회
            return userRepository.findByUsername(username);
        }
    }// readUser() end


}// class end



