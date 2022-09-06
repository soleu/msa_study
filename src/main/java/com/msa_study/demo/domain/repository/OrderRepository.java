package com.msa_study.demo.domain.repository;

import com.msa_study.demo.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
