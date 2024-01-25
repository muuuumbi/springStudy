package A803.cardian.card.domain;

import A803.cardian.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mycard_id")
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;
    @Column(nullable = false)
    private int memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Date expireDate;

    @OneToMany(mappedBy = "myCard", fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();
}
