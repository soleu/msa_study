package com.msa_study.demo.service.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class addProductRequest {

    private String name;
    private int price;
    private int stockQuantity;
}
