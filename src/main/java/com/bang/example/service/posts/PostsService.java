package com.bang.example.service.posts;

import com.bang.example.domain.posts.Posts;
import com.bang.example.domain.posts.PostsRepository;
import com.bang.example.web.dto.PostsResponseDto;
import com.bang.example.web.dto.PostsSaveRequestDto;
import com.bang.example.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// RequiredArgsConstructor
// 선언된 모든 final 필드가 포함된 생성자를 생성해준다.
// final이 없는 필드는 생성자에 포함되지 않는다.

// Autowired가 없는 이유
// Spring에서는 Bean을 주입받는 방식은 @Autowired, setter, 생성자 와 같다.
// 그러나 이를 SpringBoot에서는 RequiredArgsConstructor로 처리한다.(롬복)

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }
}
