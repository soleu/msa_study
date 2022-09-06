package com.msa_study.demo.service.dto;

import com.msa_study.demo.domain.entity.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductGetResponse {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    public static ProductGetResponse of(Product product) {
        return new ProductGetResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStockQuantity()
        );
    }
}
