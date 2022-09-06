package com.msa_study.demo.controller;

import com.msa_study.demo.service.ProductService;
import com.msa_study.demo.service.dto.ProductGetResponse;
import com.msa_study.demo.service.dto.ProductListResponse;
import com.msa_study.demo.service.dto.request.addProductRequest;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    @ApiOperation("제품을 추가합니다.")
    public void addProduct(@Valid @RequestBody addProductRequest request) {
        productService.addProduct(request);
    }

    @GetMapping("/{productId}")
    @ApiOperation("제품을 아이디별로 상세 조회합니다.")
    public ProductGetResponse getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("")
    @ApiOperation("제품 목록을 조회합니다.")
    public ProductListResponse getAllProducts() {
        return productService.getAllProducts();
    }

}
