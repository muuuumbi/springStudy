package A803.cardian.card.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Card {
    @Id
    @GeneratedValue
    @Column(name = "card_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false, name = "carddb_id")
    private Integer cardDatabaseId;

    @Enumerated
    private Type type;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 400)
    private String image;

    @Column(nullable = false)
    private int goal;

    @Column(nullable = false)
    private int annualfee;

    @Enumerated
    private BenefitCode benefitCode;

    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY)
    private List<Card> cards = new ArrayList<>();
}
