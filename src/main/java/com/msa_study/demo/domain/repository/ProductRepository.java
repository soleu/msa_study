package com.msa_study.demo.domain.repository;

import com.msa_study.demo.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
