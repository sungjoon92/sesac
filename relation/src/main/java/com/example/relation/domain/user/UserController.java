package com.example.relation.domain.user;

import com.example.relation.domain.user.dto.UserRequestDto;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/{teamId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(@PathVariable Long teamId, @Valid @RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "회원가입 성공",
                        "SUCCESS",
                        userService.createUser(teamId, requestDto)
                )
        );
    }

}
