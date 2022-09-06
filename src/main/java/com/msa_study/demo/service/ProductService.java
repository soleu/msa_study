package com.msa_study.demo.service;

import com.msa_study.demo.common.exception.NotExistsProductException;
import com.msa_study.demo.domain.Product;
import com.msa_study.demo.domain.ProductRepository;
import com.msa_study.demo.service.dto.request.ProductAddRequest;
import com.msa_study.demo.service.dto.response.ProductGetResponse;
import com.msa_study.demo.service.dto.response.ProductListGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(final ProductAddRequest request) {
        final Product product = Product.newInstance(request.getName(), request.getPrice(), request.getStockQuantity());
        productRepository.save(product);
    }

    public ProductGetResponse getProductById(final Long productId) {
        final Product product = productRepository.findById(productId)
                .orElseThrow(NotExistsProductException::new);

        return ProductGetResponse.of(product);
    }

    public ProductListGetResponse getAllProducts() {
        final List<Product> productList = productRepository.findAll();

        return ProductListGetResponse.of(productList.stream()
                .map(ProductGetResponse::of)
                .collect(Collectors.toList()));
    }
}
