package com.example.relation.domain.post;

import com.example.relation.domain.comment.entity.Comment;
import com.example.relation.domain.comment.repository.CommentRepository;
import com.example.relation.domain.post.dto.request.PostCreateRequestDto;
import com.example.relation.domain.post.dto.response.PostResponseDto;
import com.example.relation.domain.post.dto.response.PostWithCommentResponseDtoV2;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.repository.PostRepository;
import com.example.relation.domain.post.service.PostService;
import com.example.relation.global.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;  // PostRepository를 Mock 객체로 생성하여 테스트에서 사용할 수 있도록 준비합니다.

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private PostService postService;  // PostService에 Mock된 PostRepository를 주입합니다. 이를 통해 실제 DB 대신 Mock 동작을 테스트합니다.


    @Test
    void test() {
        // given
        // 테스트를 위한 가정(입력 값 및 Mock 동작)을 설정합니다.
        PostCreateRequestDto requestDto = new PostCreateRequestDto(
                "테스트 제목", // 제목 필드
                "테스트 내용", // 내용 필드
                "테스트 작성자"  // 작성자 필드
        );
        // PostCreateRequestDto는 테스트에서 사용할 데이터 입력용 DTO입니다.

        Post post = requestDto.toEntity();
        // PostCreateRequestDto를 Post 엔티티로 변환합니다.
        // 이 과정에서 Service 계층의 실제 동작과 동일한 방식으로 테스트하기 위해 사용합니다.

        given(postRepository.save(any(Post.class))).willReturn(post);
        // PostRepository의 save 메서드가 호출될 때, 특정 동작을 설정합니다.
        // - `any(Post.class)`는 save 메서드에 전달되는 모든 Post 객체에 대해 Mock 동작을 적용하겠다는 의미입니다.
        // - save 메서드가 호출되면, Mock된 결과로 위에서 생성한 post 객체를 반환하도록 설정합니다.

        // when
        // 테스트 대상 메서드를 호출합니다.
        PostResponseDto result = postService.createPost(requestDto);
        // PostService의 createPost 메서드를 호출하며, 테스트 입력 값(requestDto)을 전달합니다.
        // 이 메서드는 내부적으로 postRepository.save를 호출할 것입니다.

        // then
        // 테스트 결과를 검증합니다.
        assertThat(result.getTitle()).isEqualTo("테스트 제목");
        // 생성된 결과 DTO(result)의 제목이 "테스트 제목"과 같은지 검증합니다.

        assertThat(result.getContent()).isEqualTo("테스트 내용");
        // 생성된 결과 DTO(result)의 내용이 "테스트 내용"과 같은지 검증합니다.

        verify(postRepository).save(any(Post.class));
        // PostRepository의 save 메서드가 호출되었는지 확인합니다.
        // 테스트 중 save 메서드 호출이 발생하지 않았다면 실패합니다.
    }

    void readPostByIdV2_성공() {
        // given
        Long postId = 1L;
        Post post = Post.builder()
                .title("테스트 제목")
                .title("테스트 내용")
                .title("테스트 작성자")
                .build();
        Comment comment = Comment.builder()
                .content("댓글 내용")
                .build();

        given(postRepository.findByIdWithComment(postId))
                .willReturn(Optional.of(post));

        //when
        PostWithCommentResponseDtoV2 result = postService.readPostByIdV2(postId);

        //then
        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isNotNull();
        assertThat(result.getContent()).isNotNull();
        assertThat(result.getComments().getFirst().getContent()).isEqualTo("댓글 내용");
    }

    @Test
    void readPostById_실패_게시글이_없는_경우() {

        // given
        Long postId = 1L;
        given(postRepository.findById(postId)).willReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> postService.readPostById(postId))
                .isInstanceOf(ResourceNotFoundException.class);
        verify(postRepository).findById(postId);
        verify(commentRepository, never()).findByPostId(anyLong());
    }
}
