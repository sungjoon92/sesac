package com.example.relation.domain.tag;

import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.domain.tag.dto.TagResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}
