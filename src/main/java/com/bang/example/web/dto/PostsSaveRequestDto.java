package com.bang.example.web.dto;

import com.bang.example.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// NoArgsConstructor : 기본 생성자 자동 추가 public Posts(){} 와 같은 경우

// Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가로 생성
// 하지만, 절대로 Entity 클래스를 Request/Response 클래스로 사용해서는 안된다.
// Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스이다.
// Dto 클래스는 Controller 에서 결괏값으로 여러 테이블을 조인해서 줘야 할 경우 사용

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title,String content,String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
