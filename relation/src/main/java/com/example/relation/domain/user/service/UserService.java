package com.example.relation.domain.user.service;

import com.example.relation.domain.post.repository.Post2Repository;
import com.example.relation.domain.post.dto.response.Post2ListPageResponseDto;
import com.example.relation.domain.user.Repository.UserRepository;
import com.example.relation.domain.user.dto.response.UserResponseDto;
import com.example.relation.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final Post2Repository post2Repository;

    public UserResponseDto getMyProfile(User user) {
        return UserResponseDto.from(user);
    }// getMyProfile() end

    public Post2ListPageResponseDto getMyPosts(User user, Pageable pageable) {
        return Post2ListPageResponseDto.from(
                post2Repository.findAllByAuthorId(user.getId(), pageable)
        );
    }


}// class end
