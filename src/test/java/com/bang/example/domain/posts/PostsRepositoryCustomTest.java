package com.bang.example.domain.posts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryCustomTest {
    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void querydsl_Custom설정_기능_확인() {
        // given
        LocalDateTime now = LocalDateTime.of(2020,03,16,19,13);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> result = postsRepository.findByNewId(1);
        System.out.println(">>>>> "+result.get(0).toString());
        //then
        assertThat(result.size()).isEqualTo(1);
        Posts posts = result.get(0);
        assertThat(posts.getId()).isEqualTo(1);
        assertThat(posts.getContent()).isEqualTo("content");
    }
}
