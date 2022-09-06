package com.msa_study.demo.service.dto;

import com.msa_study.demo.domain.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOrderResponse {
    private Long id;
    private String productName;
    private String memberName;

    public static CreateOrderResponse of(Order order) {
        return new CreateOrderResponse(
                order.getId(),
                order.getProduct().getName(),
                order.getMember().getName()
        );
    }
}
