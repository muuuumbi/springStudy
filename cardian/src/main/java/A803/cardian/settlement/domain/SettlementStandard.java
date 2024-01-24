package A803.cardian.settlement.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SettlementStandard {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private int salary;

    @Column(nullable = false)
    private int low;

    @Column(nullable = false)
    private int high;

    @Column(nullable = false)
    private int limit;
}
