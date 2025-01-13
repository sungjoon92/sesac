package com.example.relation.domain.post;

import com.example.relation.domain.post.dto.PostListWithCommentCountResponseDto;
import com.example.relation.domain.post.dto.PostListWithPageResponseDto;
import com.example.relation.domain.post.dto.PostResponseDto;
import com.example.relation.domain.post.dto.PostWithCommentAndTagResponseDtoV2;
import com.example.relation.domain.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p LEFT JOIN p.comments WHERE p.id = :id")
    Optional<Post> findByIdWithComment(@Param("id") Long id);
//    의미:
//    LEFT JOIN을 통해 Post와 comments를 조인하여 Post 엔티티를 조회.
//    하지만 **지연 로딩(LAZY)**가 적용되므로, 조회 시 Post의 기본 필드만 초기화되고 comments는 초기화되지 않을 가능성.
//
//    문제:
//    comments가 사용되는 시점에 다시 지연 로딩 쿼리가 발생할 수 있음.
//    Fetch Join을 사용하지 않으면 데이터 로딩 효율성이 떨어짐.

    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comments WHERE p.id = :id")
    Optional<Post> findByIdWithCommentFetch(@Param("id") Long id);
//    의미:
//    LEFT JOIN FETCH를 사용하여 연관된 comments를 즉시 로딩(EAGER)하도록 설정.
//    Post와 comments를 한 번의 쿼리로 가져오기 때문에 N+1 문제가 발생하지 않음.
//
//    장점:
//    쿼리 성능 최적화.
//    comments를 즉시 초기화하여 post.getComments() 호출 시 추가 쿼리가 발생하지 않음.

    @Query("SELECT p FROM Post p LEFT JOIN FETCH  p.comments")
    List<Post> findAllWithCommentFetch();

    //    의미:
//    모든 Post를 조회하면서 comments도 함께 즉시 로딩.
//    LEFT JOIN FETCH로 모든 Post와 연관된 comments를 한 번의 쿼리로 가져옴.
//
//    사용 시 주의:
//    조회 대상인 Post와 comments의 데이터가 많으면 성능 문제가 발생할 수 있음.
//    필요 이상으로 많은 데이터를 로드할 가능성이 있음.
    @EntityGraph(attributePaths = {"comments"})
    @Query("SELECT p FROM Post p")
    List<Post> findAllWithCommentEntityGraph();

    @Query("SELECT p, COUNT(c) " +
            "FROM Post p " +
            "LEFT JOIN p.comments c " +
            "GROUP BY p")
    List<Object[]> findAllWithCommentCount();

    @Query("SELECT new com.example.relation.domain.post.dto.PostListWithCommentCountResponseDto(p.id, p.title, p.createdAt, COUNT(c)) " +
            "FROM Post p " +
            "LEFT JOIN p.comments c " +
            "GROUP BY p")
    List<PostListWithCommentCountResponseDto> findAllWithCommentCountDTO();

    @Query("SELECT DISTINCT p FROM Post p " +
            "LEFT JOIN p.comments c " +
            "LEFT JOIN FETCH p.postTags t " +
            "LEFT JOIN FETCH t.tag " +
            "WHERE p.id = :id")
    Optional<Post> findByIdWithCommentAndTag(@Param("id") Long id);


    @Query("SELECT p FROM Post p " +
            "LEFT JOIN FETCH p.postTags pt " +
            "LEFT JOIN FETCH pt.tag " +
            "WHERE p.id = :id")
    Optional<Post> findByIdWithTag(@Param("id") Long id);

    @Query("SELECT DISTINCT p FROM Post p " +
            "JOIN p.postTags pt " +
            "JOIN pt.tag t " +
            "WHERE t.name = :tagName")
    List<PostWithCommentAndTagResponseDtoV2> findAllByTagName(@Param("tagName") String tagName);


    @Query("SELECT p FROM Post p " +
            "LEFT JOIN FETCH p.comments")
    Page<Post> findPostsWithCommentPage(Pageable pageable);
//    의미:
//    @EntityGraph는 JPA에서 Fetch Join을 선언적으로 정의하는 방법.
//    attributePaths = {"comments"}는 comments를 즉시 로딩하도록 설정.
//    JPA가 내부적으로 LEFT JOIN FETCH를 사용해 쿼리를 생성함.
//
//    장점:
//    코드 가독성 향상. @Query 대신 JPA에서 제공하는 표준 방식으로 Fetch Join 설정.
//    복잡한 쿼리 대신 선언적으로 연관 관계를 설정 가능.
}

// findById
// 단일 엔티티를 조회하고 연관 데이터는 나중에 필요할 때 (지연 로딩 유지).
//
// findByIdWithComment
// 단일 엔티티를 조회하되, 연관 데이터 로딩이 필수가 아닐 때.
//
// findByIdWithCommentFetch
// 단일 엔티티를 조회하면서 연관 데이터를 한 번의 쿼리로 즉시 로딩하고 싶을 때.
//
// findAllWithCommentFetch
// 여러 엔티티를 조회하면서 연관 데이터를 모두 한 번의 쿼리로 로드하고 싶을 때.
//
// findAllWithCommentEntityGraph
// 선언적인 방식으로 Fetch Join을 적용하고, 코드의 가독성을 높이고 싶을 때.
