package com.msa_study.demo.service.dto.response;

import com.msa_study.demo.domain.Order;
import com.msa_study.demo.domain.OrderStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderGetResponse {
    private Long orderId;
    private String memberName;
    private String productName;
    private int orderPrice;
    private OrderStatus orderStatus;

    public static OrderGetResponse of(Order order) {
        return new OrderGetResponse(
                order.getId(),
                order.getMember().getName(),
                order.getProduct().getName(),
                order.getOrderPrice(),
                order.getOrderStatus()
        );
    }
}
