package com.msa_study.demo.service.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductListResponse {
    private List<ProductGetResponse> response = new ArrayList<>();

    public static ProductListResponse of(List<ProductGetResponse> responses) {
        return new ProductListResponse(responses);
    }
}

