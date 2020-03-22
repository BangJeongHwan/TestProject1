package com.bang.example.web;

import com.bang.example.service.posts.PostsService;
import com.bang.example.web.dto.PostsResponseDto;
import com.bang.example.web.dto.PostsSaveRequestDto;
import com.bang.example.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

// RequiredArgsConstructor
// 선언된 모든 final 필드가 포함된 생성자를 생성해준다.
// final이 없는 필드는 생성자에 포함되지 않는다.

// RestController
// 컨드롤러를 JSON을 반환하는 컨드롤러로 만들어준다.

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    // 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    // 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
