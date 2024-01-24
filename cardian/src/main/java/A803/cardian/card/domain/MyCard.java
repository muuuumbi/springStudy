package A803.cardian.card.domain;

import A803.cardian.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyCard {
    @Id
    @GeneratedValue
    @Column(name = "mycard_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(nullable = false)
    private Date updateDate;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Date expireDate;
}
