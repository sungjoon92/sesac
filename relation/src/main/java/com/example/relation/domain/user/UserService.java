package com.example.relation.domain.user;

import com.example.relation.domain.team.Team;
import com.example.relation.domain.team.TeamRepository;
import com.example.relation.domain.user.dto.UserRequestDto;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final TeamRepository teamRepository;
    public UserResponseDto createUser(Long teamId, UserRequestDto requestDto) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("팀 정보를 찾을 수 없습니다"));

        User user = userRepository.save(requestDto.Entity(team));
        return UserResponseDto.from(userRepository.save(user));
    }
}
