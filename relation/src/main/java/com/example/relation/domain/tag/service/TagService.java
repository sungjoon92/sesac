package com.example.relation.domain.tag.service;

import com.example.relation.domain.tag.dto.request.TagRequestDto;
import com.example.relation.domain.tag.dto.response.TagResponseDto;
import com.example.relation.domain.tag.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagService {
    private final TagRepository tagRepository;

    @Transactional
    public TagResponseDto createService(TagRequestDto requestDto){
        return TagResponseDto.from(tagRepository.save(requestDto.toEntity()));
    }

    public List<TagResponseDto> readTags(){
        return tagRepository.findAll().stream().map(TagResponseDto::from).toList();
    }
}