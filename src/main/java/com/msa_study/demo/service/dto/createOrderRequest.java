package com.msa_study.demo.service.dto;

import com.msa_study.demo.domain.entity.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class createOrderRequest {
    private Long productId;
    private Long memberId;
    private OrderStatus orderStatus;
}
