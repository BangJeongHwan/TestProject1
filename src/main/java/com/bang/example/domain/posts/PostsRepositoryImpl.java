package com.bang.example.domain.posts;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.bang.example.domain.posts.QPosts.posts;

@RequiredArgsConstructor
public class PostsRepositoryImpl implements PostsRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Posts> findByNewId(long id){
        return queryFactory.selectFrom(posts)
                .where(posts.id.eq(id))
                .fetch();
    }

    @Override
    public List<Posts> findByTitle(String title){
        return queryFactory.selectFrom(posts)
                .where(posts.title.contains(title))
                .orderBy(posts.id.desc())
                .fetch();
    }
}
