package com.bang.example.domain.posts;

import java.util.List;

public interface PostsRepositoryCustom {
    List<Posts> findByNewId(long id);
}
