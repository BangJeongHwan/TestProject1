package com.bang.example.web.dto;

import com.bang.example.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsFindRequestDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsFindRequestDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }

    @Builder
    public PostsFindRequestDto(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PostsFindRequestDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
