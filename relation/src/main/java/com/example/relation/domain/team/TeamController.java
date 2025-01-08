package com.example.relation.domain.team;

import com.example.relation.domain.team.dto.TeamRequestDto;
import com.example.relation.domain.team.dto.TeamResponseDto;
import com.example.relation.domain.user.UserResponseDto;
import com.example.relation.domain.user.UserService;
import com.example.relation.domain.user.dto.UserRequestDto;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<ApiResponse<TeamResponseDto>> createTeam(@Valid @RequestBody TeamRequestDto requestDto) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        "팀 생성 성공",
                        "SUCCESS",
                        teamService.createTeam(requestDto)
                )
        );
    }

}
