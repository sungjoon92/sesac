package com.example.relation.domain.user.dto;

import com.example.relation.domain.team.Team;
import com.example.relation.domain.user.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {

    @NotBlank
    @Length(min = 1,  max = 20)
    private String name;

    private int age;

    private Long teamId;

    public User Entity(Team team) {
        return User.builder()
                .name(this.getName())
                .age(this.getAge())
                .team(team)
                .build();
    }

}
