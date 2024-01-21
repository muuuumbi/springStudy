package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity //JPA가 사용하는 것임을 알려줌
@Table(name = "Member") //DB 테이블명 명시. 해주지 않으면 class명과 같은 테이블과 연결됨
public class Member {
    @Id
    private Long id;
    @Column(name = "name")
    private String username;

    public Member() {
    }
}
