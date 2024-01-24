package jpabook.jpashop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long id;

    private String city;
    private String streets;
    private String zipcode;
    private DeliveryStatus status;
}
