package com.example.relation.domain.user;

import com.example.relation.domain.team.Team;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    @ManyToOne()
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    public User( String name, int age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }
}
