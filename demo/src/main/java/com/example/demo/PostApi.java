package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostApi {
    List<Post> posts = new ArrayList<Post>();
    private Long id = 0L;


    {
        // 인스턴스가 생성되었을 때 한번 실행된다
        // 초기값을 넣을 때 사용된다.
        posts.add(new Post(++id, "초기 제목", "초기 내용"));
    }

    //restfull
    // "/post"> post메서드
    // 글 생성
//    @GetMapping("posts/create")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post creaPost(@RequestBody Post newPost) {

        String title = newPost.getTitle();
        String content = newPost.getContent();

        if (title == null || title.isBlank()) {
            throw new RuntimeException("title을 입력해주세요");
        }

        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("content를 입력해주세요");
        }
        Post post = new Post(++id, title, content);
        posts.add(post);
        return post;
    }

    // 전체글 조회
    @GetMapping
    @ResponseStatus()
    public List<Post> readPosts() {
        return posts;
    }// readPosts end

    // 해당글 조회
    @GetMapping("/{id}")
    public Post readPostById(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }// if end
        }// for end
        return null;
    }// readPostById() end

    // "/post/{id}" / method : PUT : PATCH
//    @GetMapping("/posts/{id}/update")
    @PutMapping("/{id}")
    public Post updatePosts(@PathVariable Long id, @RequestBody Post updatePost) {


        String title = updatePost.getTitle();
        String content = updatePost.getContent();

        for (Post post : posts) {
            if (post.getId().equals(id)) {
                post.setTitle(title);
                post.setContent(content);
                return post;
            }// if end
        }// for end
        return null;
    }// updatePosts() end


    // "/post/{id}" / method : DELETE
    // 삭제
//    @GetMapping("/posts/{id}/delete")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletePosts(@PathVariable Long id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                posts.remove(post);
                return post.getId() + " 페이지 삭제 완료";
            }// if end
        }// for end
        return "존재하지 않는 페이지 입니다.";
    }// deletePosts() end


    @GetMapping("/paged")
    public ResponseEntity<?> getPagedPosts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "") String search) {

        // 1. 페이지네이션을 위한 더미데이터 추가
        String content = "";
        for (int i = 1; i <= 20; i++) {
            String title = "제목 " + i;
            content = "내용 " + i;
            Post post = new Post(++id, title, content);
            posts.add(post);
        }

        // 2. 검색 기능 적용 (content에 검색어가 포함된 경우 필터링)
        List<Post> filteredPosts = posts.stream().filter(post -> post.getContent().contains(search)) // Adjust this based on how the Post class is structured
                .collect(Collectors.toList());

        // 3. 필터링된 리스트 사용
        List<Post> targetList = search.isEmpty() ? posts : filteredPosts;

        // 4. 시작 인덱스와 끝 인덱스 계산
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, targetList.size());

        // 5. startIndex가 리스트 크기보다 크면 빈 결과 반환
        if (startIndex >= targetList.size()) {
            return ResponseEntity.ok("결과가 없습니다."); // 페이지 범위를 초과한 경우
        }

        // 6. 유효한 결과 반환
        List<Post> result = targetList.subList(startIndex, endIndex);
        return ResponseEntity.ok(result);
    }


}// class end
