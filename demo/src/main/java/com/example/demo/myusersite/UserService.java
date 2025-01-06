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
         return  userRepository.findAll().stream()
                 .map(UserResponseDto::from)
                 .toList();
    }// readUser() end

    public UserResponseDto findByUsername(String username) {
        return userRepository.findByUsername(username);
    }// readUser() end

    public List<UserResponseDto> findAllByAge(int age) {
        return userRepository.findAllByAge(age);
    }// readUser() end


}// class end



