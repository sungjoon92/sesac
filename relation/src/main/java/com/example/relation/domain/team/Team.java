package com.example.relation.domain.team;

import com.example.relation.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<User> users;


    @Builder
    public Team(Long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }
}
