package com.example.relation.domain.team;

import com.example.relation.domain.team.dto.TeamRequestDto;
import com.example.relation.domain.team.dto.TeamResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamResponseDto createTeam(TeamRequestDto requestDto) {
        Team team = teamRepository.save(requestDto.toEntity());
        return TeamResponseDto.From(team);
    }
}
