package com.msa_study.demo.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int orderPrice;

    private OrderStatus orderStatus;

    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void cancel() {
        this.orderStatus = OrderStatus.CANCEL;
    }

    private Order(final Member member, final Product product, final int orderPrice, final OrderStatus orderStatus) {
        this.product = product;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
        setMember(member);
    }

    public static Order newInstance(final Member member, final Product product, final int orderPrice, final OrderStatus orderStatus) {
        return new Order(
                member,
                product,
                orderPrice,
                orderStatus
        );
    }
}
