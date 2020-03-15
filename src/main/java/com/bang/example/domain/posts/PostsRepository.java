package com.bang.example.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 다음의 java 파일은 ibatis, MyBatis 등에서 Dao라고 불리는 DB Layer 접근자이다.
// JPA에서는 Repository라고 부르며 인터페이스로 생성한다.
// 인터페이스 생성 후, JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적은 CRUD 메소드 생성됨.
// Entity 클래스와 기본 Entity Repository는 함께 위치
// 보통 Domain 패키지에서 함께 관리한다.

public interface PostsRepository  extends JpaRepository<Posts,Long> {

}
