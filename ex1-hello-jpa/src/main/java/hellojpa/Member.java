package hellojpa;

import jakarta.persistence.*;

import java.util.Date;

@Entity //JPA가 사용하는 것임을 알려줌
@Table(name = "Member") //DB 테이블명 명시. 해주지 않으면 class명과 같은 테이블과 연결됨
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY) //member 입장에서 many, team 입장에서 one, 지연로딩전략
    @JoinColumn(name = "TEAM_ID") //매핑해야 하는 컬럼명
    private Team team; //객체지향 모델링

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
