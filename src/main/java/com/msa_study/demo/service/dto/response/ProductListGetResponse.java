package com.msa_study.demo.service.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductListGetResponse {
    private List<ProductGetResponse> response = new ArrayList<>();

    public static ProductListGetResponse of(List<ProductGetResponse> responses) {
        return new ProductListGetResponse(responses);
    }
}

