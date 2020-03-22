package com.bang.example.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 다음의 java 파일은 ibatis, MyBatis 등에서 Dao라고 불리는 DB Layer 접근자이다.
// JPA에서는 Repository라고 부르며 인터페이스로 생성한다.
// 인터페이스 생성 후, JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적은 CRUD 메소드 생성됨.
// Entity 클래스와 기본 Entity Repository는 함께 위치
// 보통 Domain 패키지에서 함께 관리한다.

public interface PostsRepository  extends JpaRepository<Posts,Long>, PostsRepositoryCustom {

    // @Query
    // 규모가 있는 프로젝트의 경우에는 아래와 같이 사용하는 것은 한계가 있다.
    // 그러므로 조회용 프레임워크를 사용한다.(queryds, jooq, MyBatis 등)
    // Querydsl를 추천한다.
    // 1. 타입의 안정성이 보장된다.
    //  - 단순한 문자열로 쿼리를 생성하는 것이 아니라, 메소드 기반의 쿼리를 생성하여 오타나 컬럼이 존재하지 않을 경우 IDE에서 자동 검출
    // 2. 국내 많은 회사에서 사용중
    //  - 쿠팡, 배민 등등 JPA를 적극적으로 사용하는 회사에서 사용
    // 3. 레퍼런스가 많다.
    //  - 2번의 장점에서 이어지는 것인데, 많은 회사에서 사용하다보니 그만큼 많은 자료가 있다.
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
