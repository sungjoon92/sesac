package com.example.relation.domain.team.dto;

import com.example.relation.domain.team.Team;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeamResponseDto {

    private final Long id;
    private final String name;

    public static TeamResponseDto From(Team Entity) {
        return TeamResponseDto.builder()
                .id(Entity.getId())
                .name(Entity.getName())
                .build();
    }

}
