package com.example.demo.myusersite;

import com.example.demo.myjpasite.dto.PostListResponseDto;
import com.example.demo.myusersite.dto.UserCreateRequestDto;
import com.example.demo.myusersite.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 사용자 추가
    @PostMapping()
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@Valid @RequestBody UserCreateRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok("회원가입 완료!", "CREATED", userService.createUser(requestDto))// ApiResponse.ok() end
        );// body() end
    }// createUser() end


    // 사용자 전체 조회
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> readUser() {
        List<UserResponseDto> data = userService.readUser();
        ApiResponse<List<UserResponseDto>> response = ApiResponse.ok(data);

        return ResponseEntity.ok(response);
    }

    // 특정 닉네임을 가진 사용자 조회
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> readUserByName(@RequestParam(defaultValue = "") String username, @RequestParam(defaultValue = "0") int age) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(
                        "SUCCESS",
                        "SUCCESS",
                        userService.searchUsers(username, age))// ApiResponse.ok() end
        );// body() end
    }// readUserByName() end

}// class end
