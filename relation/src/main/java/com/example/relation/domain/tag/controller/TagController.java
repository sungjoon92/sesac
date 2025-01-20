package com.example.relation.domain.tag.controller;

import com.example.relation.domain.tag.service.TagService;
import com.example.relation.domain.tag.dto.request.TagRequestDto;
import com.example.relation.domain.tag.dto.response.TagResponseDto;
import com.example.relation.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PostMapping
    public ResponseEntity<ApiResponse<TagResponseDto>> createTag(@RequestBody TagRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok(
                        tagService.createService(requestDto)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TagResponseDto>>> readtags() {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        tagService.readTags()
                )
        );
    }

}