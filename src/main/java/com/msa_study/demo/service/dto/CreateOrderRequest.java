package com.msa_study.demo.service.dto;

import com.msa_study.demo.domain.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOrderRequest {
    private Long productId;
    private Long memberId;
    private OrderStatus orderStatus;
}
