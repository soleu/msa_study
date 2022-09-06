package com.msa_study.demo.service.dto.response;

import com.msa_study.demo.domain.Order;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderCreateResponse {
    private Long id;
    private String productName;
    private String memberName;

    public static OrderCreateResponse of(Order order) {
        return new OrderCreateResponse(
                order.getId(),
                order.getProduct().getName(),
                order.getMember().getName()
        );
    }
}
