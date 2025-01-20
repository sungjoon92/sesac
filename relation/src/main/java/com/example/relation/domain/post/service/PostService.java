package com.example.relation.domain.post.service;

import com.example.relation.domain.comment.entity.Comment;
import com.example.relation.domain.comment.repository.CommentRepository;
import com.example.relation.domain.post.dto.request.Post2CreateWithAuthorRequestDto;
import com.example.relation.domain.post.dto.request.PostCreateRequestDto;
import com.example.relation.domain.post.dto.request.PostUpdateRequestDto;
import com.example.relation.domain.post.dto.response.*;
import com.example.relation.domain.post.repository.PostRepository;
import com.example.relation.domain.post.repository.PostTagRepository;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.entity.PostTag;
import com.example.relation.domain.post.repository.Post2Repository;
import com.example.relation.domain.tag.entity.Tag;
import com.example.relation.domain.tag.repository.TagRepository;
import com.example.relation.domain.tag.dto.request.TagRequestDto;
import com.example.relation.domain.user.entity.User;
import com.example.relation.global.common.service.FileService;
import com.example.relation.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;
    // 파일 저장용 DI
    private final FileService fileService;

    private final Post2Repository post2Repository;
    @Transactional
    public PostResponseDto createPost(PostCreateRequestDto requestDto) {
        Post post = postRepository.save(requestDto.toEntity());
        return PostResponseDto.from(post);
    }

    // 게시글 전체 조회, 정렬, 페이징
    public List<PostListResponseDto> readPosts(Pageable pageable) {
        return postRepository.findAll(pageable).getContent().stream().map(PostListResponseDto::from).toList();
    }

    // 게시글 단일 조회
    public PostResponseDto readPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        return PostResponseDto.from(post);
    }

    // 해당 게시글과 글의 댓글 전체 조회
    public PostWithCommentResponseDtoV2 readPostByIdV2(Long id) {
    // post, comment를 한번에 가져오고 싶다.
        Post post = postRepository.findByIdWithComment(id).orElseThrow(() -> new ResourceNotFoundException());

        return PostWithCommentResponseDtoV2.from(post);
    }

    // 전체 게시글과 글의 댓글 전체 조회
    public List<PostWithCommentResponseDtoV2> readPostsWithCommentPage(Pageable pageable) {
        return postRepository.findPostsWithCommentPage(pageable).getContent().stream().map(
                PostWithCommentResponseDtoV2::from
        ).toList();
    }

    // 게시글 수정
    @Transactional
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        post.update(requestDto);

        return PostResponseDto.from(post);
    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        postRepository.delete(post);
    }

    public List<PostListWithCommentCountResponseDto> readPostsWithCommentCount() {
        List<Object[]> results = postRepository.findAllWithCommentCount();
        return results.stream().map(result -> {
            Post post = (Post) result[0];
            Long CommentCount = (Long) result[1];
            return new PostListWithCommentCountResponseDto(post.getId(), post.getTitle(), post.getCreatedAt(), CommentCount);
        }).toList();
    }

    public List<PostListWithCommentCountResponseDto> readPostsWithCommentCountDto() {
        return postRepository.findAllWithCommentCountDTO();
    }

    @Transactional
    public void addTagToPost(Long id, TagRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
//        Tag tag = tagRepository.findByName(requestDto.getName()).orElseThrow(() -> new ResourceNotFoundException());

        // 태그가 존재하지 않으면 새로운 태그를 만들어줌
        Tag tag = tagRepository.findByName(requestDto.getName())
                .orElseGet(() -> {
                   Tag newTag =  new Tag(requestDto.getName());
                    return tagRepository.save(newTag);
//                    return tagRepository.save(requestDto.toEntity());
                });


        PostTag postTag = new PostTag();
        postTag.addTag(tag);

        postTag.addPost(post);
        post.getPostTags().add(postTag);

        postTagRepository.save(postTag);

    }

    // 게시글의 댓글과 해시태그 여부 조회
    public PostWithCommentAndTagResponseDto PostWithCommentAndTagResponseDto(Long id) {
//       Post post =  postRepository.findByIdWithCommentAndTag(id)
//                .orElseThrow(() -> new ResourceNotFoundException());

        Post postWithTag = postRepository.findByIdWithTag(id).orElseThrow(() -> new ResourceNotFoundException());
        List<Comment> comments = commentRepository.findByPostId(id);

        return PostWithCommentAndTagResponseDto.from(postWithTag, comments);
    }

    // 게시글의 댓글과 해시태그 여부 조회
    public PostWithCommentAndTagResponseDtoV2 PostWithCommentAndTagResponseDtoV2(Long id) {
        Post post = postRepository.findByIdWithCommentAndTag(id).orElseThrow(() -> new ResourceNotFoundException());

        return PostWithCommentAndTagResponseDtoV2.from(post);
    }

    public List<Post> readPostsByTag(String tagName) {
        return postRepository.findAllByTagName(tagName);
    }


    public PostListWithPageResponseDto readPostsWithPageDetail(Pageable pageable){
        return PostListWithPageResponseDto.from(postRepository.findAll(pageable));
    }

    // 파일저장
    @Transactional
    public PostWithImageDtoResponseDto createPostWithImage (
            PostCreateRequestDto requestDto,
            MultipartFile image
    ) {
        String imageUrl = null;

        if (image != null && !image.isEmpty()) {
            imageUrl = fileService.saveFile(image);
        }
        Post post = requestDto.toEntity();
        post.setImageUrl(imageUrl);
        return PostWithImageDtoResponseDto.from(postRepository.save(post));
    }


    @Transactional
    public Post2ResponseDto createPost2(Post2CreateWithAuthorRequestDto requestDto, User user) {
        requestDto.toEntity(user);
        return Post2ResponseDto.from(
                post2Repository.save(requestDto.toEntity(user)));
    }

}
