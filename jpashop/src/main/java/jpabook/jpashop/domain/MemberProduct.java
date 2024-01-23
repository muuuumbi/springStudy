package jpabook.jpashop.domain;

import jakarta.persistence.*;

@Entity
public class MemberProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    //원하는 컬럼 추가해도 됨.
}
