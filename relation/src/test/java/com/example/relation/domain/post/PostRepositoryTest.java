package com.example.relation.domain.post;

import com.example.relation.domain.comment.entity.Comment;
import com.example.relation.domain.comment.repository.CommentRepository;
import com.example.relation.domain.post.dto.response.PostListWithCommentCountResponseDto;
import com.example.relation.domain.post.entity.Post;
import com.example.relation.domain.post.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    private Post post;
    private Comment comment1;
    private Comment comment2;

    @BeforeEach
    void setUp() {
        post = new Post("테스트 제목", "테스트 내용", "테스트 작성자");
        post = postRepository.save(post);
        comment1 = new Comment("댓글1", post);
        comment2 = new Comment("댓글2", post);
        commentRepository.save(comment1);
        commentRepository.save(comment2);
    }

    @Test
    void findByIdWithComment_성공() {
        // given
        // post, comment 가 db에 존재하는 상황이야
        // @BeforeEach 에서 이미 처리됨

        // when
        // 내가 post를 findById 했을 때, 그 결과가
        Optional<Post> foundPost = postRepository.findByIdWithComment(post.getId());

        // then
        // 여기에 검증되었으면 좋겠어
        // 1. post가 존재한다.
        assertThat(foundPost).isPresent();

        // 2. post에 대한 comment가 2개 존재한다
        assertThat(foundPost.get().getComments()).hasSize(2);

        // 3. post에 대한 comment 중 첫번쨰의 content가 "댓글1"이다.
        assertThat(foundPost.get().getComments().getFirst().getContent()).isEqualTo("댓글1");
    }



    @Test
    void findAllWithCommentCountDTO_성공() {
        // when
        List<PostListWithCommentCountResponseDto> results =
                postRepository.findAllWithCommentCountDTO();

        // then
        assertThat(results).hasSize(1);

        PostListWithCommentCountResponseDto dto = results.get(0);

        assertThat(dto.id()).isEqualTo(post.getId());
        assertThat(dto.title()).isEqualTo("테스트 제목");
        assertThat(dto.commentCount()).isEqualTo(2L);
    }


    @Test
    void findAllByTagName_없는_태그_검색() {
        // given
        String notExistTagName = "존재하지않는태그";

        // when
        List<Post> posts = postRepository.findAllByTagName(notExistTagName);

        // then
        assertThat(posts).isEmpty();
    }
}