package com.example.relation.domain.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {
    private final Long id;
    private final String name;
    private final int age;


    public static UserResponseDto from(User Entity) {
        return UserResponseDto.builder()
                .id(Entity.getId())
                .name(Entity.getName())
                .age(Entity.getAge())
                .build();
    }

}
