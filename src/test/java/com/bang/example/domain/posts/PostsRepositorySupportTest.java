package com.bang.example.domain.posts;

import org.aspectj.lang.annotation.After;
import org.assertj.core.api.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositorySupportTest {
    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private PostsRepositorySupport postsRepositorySupport;

    @Test
    public void querydsl_기본_기능_확인() {
        // given
        LocalDateTime now = LocalDateTime.of(2020,03,16,19,13);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> result = postsRepositorySupport.findByNewId(1);
        System.out.println(">>>>> "+result.get(0).toString());
        //then
        assertThat(result.size()).isEqualTo(1);
        Posts posts = result.get(0);
        assertThat(posts.getId()).isEqualTo(1);
        assertThat(posts.getContent()).isEqualTo("content");
    }
}
