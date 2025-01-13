package com.example.relation.domain.post;

import com.example.relation.*;
import com.example.relation.domain.post.dto.*;
import com.example.relation.domain.tag.dto.TagRequestDto;
import com.example.relation.global.exception.ResourceNotFoundException;
import com.example.relation.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<ApiResponse<PostResponseDto>> createPost(@Valid @RequestBody PostCreateRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.ok("게시글이 성공적으로 작성되었습니다", "CREATED",
                                postService.createPost(requestDto)
                        )
                );
    }

    // 게시글 전체 조회
    @GetMapping
    public ResponseEntity<ApiResponse<List<PostListResponseDto>>> readPosts(Pageable pageable) {
        ApiResponse<List<PostListResponseDto>> response = ApiResponse.ok(postService.readPosts(pageable));

        return ResponseEntity.ok(response);
    }



    @GetMapping("/detail/pages")
    public ResponseEntity<ApiResponse<List<PostWithCommentResponseDtoV2>>> readPostsWithCommentPage(Pageable pageable){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsWithCommentPage(pageable)
        ));
    }

    // 게시글 단일조회
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> readPostById(@PathVariable Long id) {
        ApiResponse<PostResponseDto> response = ApiResponse.ok(postService.readPostById(id));
        return ResponseEntity.ok(response);

    }

    // 게시글과 글의 댓글 전체 조회
    @GetMapping("/v2/{id}")
    public ResponseEntity<ApiResponse<PostWithCommentResponseDtoV2>> readPostByIdV2(@PathVariable Long id) {

        return ResponseEntity.ok(ApiResponse.ok(postService.readPostByIdV2(id)));
    }


    @GetMapping("/pages/detail")
    public ResponseEntity<ApiResponse<PostListWithPageResponseDto>> readPostsWithPageDetail(Pageable pageable){
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsWithPageDetail(pageable)
        ));
    }


    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponseDto>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        ApiResponse<PostResponseDto> response = ApiResponse.ok("게시글이 성공적으로 수정되었습니다", "UPDATED", postService.updatePost(id, requestDto));

        return ResponseEntity.ok(response);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        ApiResponse<Void> response = ApiResponse.ok("게시글이 성공적으로 삭제되었습니다", "DELETED", null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/comment-count")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostsWithCommentCount() {
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsWithCommentCount()
        ));
    }

    @GetMapping("/comment-count-dto")
    public ResponseEntity<ApiResponse<List<PostListWithCommentCountResponseDto>>> readPostsWithCommentCountDto() {
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsWithCommentCountDto()
        ));
    }

    // post , tag 연결
    @PostMapping("/{id}/tags")
    public void addTagToPost(@PathVariable Long id, @Valid @RequestBody TagRequestDto requestDto) {
        postService.addTagToPost(id, requestDto);
    }

    // 게시글의 댓글과 해시태그 여부 조회
    @GetMapping("/{id}/detail")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDto>> readPostByIdWithCommentAndTag(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.PostWithCommentAndTagResponseDto(id)
                )
        );
    }

    // 게시글의 댓글과 해시태그 여부 조회
    @GetMapping("/{id}/detail/v2")
    public ResponseEntity<ApiResponse<PostWithCommentAndTagResponseDtoV2>> readPostByIdWithCommentAndTagV2(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.ok(
                        postService.PostWithCommentAndTagResponseDtoV2(id)
                )
        );
    }

    @GetMapping("/tage")
    public ResponseEntity<ApiResponse<List<PostWithCommentAndTagResponseDtoV2>>> readPostsByTag(@RequestParam String tagName) {
        return ResponseEntity.ok(ApiResponse.ok(
                postService.readPostsByTag(tagName)
        ));
    }

    // 파일저장
    @PostMapping("/images")
    public ResponseEntity<ApiResponse<PostWithImageDtoResponseDto>> createPostWithImage(
            @RequestPart(value = "data") PostCreateRequestDto requestDto,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        System.out.println(image.getSize());
        return ResponseEntity.ok(ApiResponse.ok(
                postService.createPostWithImage(requestDto, image)
        ));
    }
}

