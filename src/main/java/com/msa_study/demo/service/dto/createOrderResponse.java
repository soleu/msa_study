package com.msa_study.demo.service.dto;

import com.msa_study.demo.domain.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class createOrderResponse {
    private Long id;
    private String productName;
    private String memberName;

    public static createOrderResponse of(Order order) {
        return new createOrderResponse(
                order.getId(),
                order.getProduct().getName(),
                order.getMember().getName()
        );
    }
}
