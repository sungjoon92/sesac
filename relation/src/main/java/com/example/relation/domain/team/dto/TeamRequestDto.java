package com.example.relation.domain.team.dto;

import com.example.relation.domain.team.Team;
import com.example.relation.domain.user.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeamRequestDto {
    @NotBlank
    private String name;

    public Team toEntity() {
        return Team.builder()
                .name(this.name)
                .build();
    }

}
