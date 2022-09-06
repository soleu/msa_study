package com.msa_study.demo.service.dto;

import com.msa_study.demo.domain.entity.Order;
import com.msa_study.demo.domain.entity.OrderStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class getOrderResponse {
    private Long orderId;
    private String memberName;
    private String productName;
    private int orderPrice;
    private OrderStatus orderStatus;

    public static getOrderResponse of(Order order) {
        return new getOrderResponse(
                order.getId(),
                order.getMember().getName(),
                order.getProduct().getName(),
                order.getOrderPrice(),
                order.getOrderStatus()
        );
    }
}
