package com.bang.example.domain.posts;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bang.example.domain.posts.QPosts.posts;

@Repository
public class PostsRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public PostsRepositorySupport(JPAQueryFactory queryFactory){
        super(Posts.class);
        this.queryFactory=queryFactory;
    }

    public List<Posts> findByNewId(long id){
        return queryFactory
                .selectFrom(posts)
                .where(posts.id.eq(id))
                .orderBy(posts.id.desc())
                .fetch();
    }
}
