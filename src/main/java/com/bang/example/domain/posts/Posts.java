package com.bang.example.domain.posts;

import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;

// ** 여기엔 Getter와 Setter가 없다!!!
// 사용하게 되면 해당 클래스의 인스턴스 값들이 언제 어디서 변하는지 명확하게 확인할 수 없어, 차후 변경 시 복잡해진다.
// 꼭 필요시엔 이렇게 사용한다
/*
public class Order(){
    public void cancelOrder(){
        this.status = status;
    }
}
public void 주문서비스의_추소이벤트(){
    order.cancelOrder();
}
*/

// NoArgsConstructor : 기본 생성자 자동 추가 public Posts(){} 와 같은 경우

@NoArgsConstructor
@Entity
public class Posts {
    // Id : 해당 테이블의 PK 필드를 의미
    // GeneratedValue : PK 생성 규칙을 의미, GenerationType.IDENTITY 로 auto_increment 처리
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column : 테이블 컬럼의 의미하며, 굳이 선언해주지 않아도 해당 클래스 필드는 모두 컬럼 처리됨.
    // 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이  있으면 사용한다.
    // 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 늘리고 싶거나 타입을 TEXT로 변경하고 싶을 때 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // Builder : 해당 클래스의 빌더 패턴 클래스를 생성
    // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    @Builder
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }


    public String getTitle(){
        this.title = "테스트 게시글";
        return title;
    }
    public String getContent(){
        this.content = "테스트 본문";
        return content;
    }
}
