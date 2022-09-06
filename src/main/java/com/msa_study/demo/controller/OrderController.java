package com.msa_study.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    //create Order
    @PostMapping("")
    public void createOrder(createOrderRequest request) {

    }

    //주문 확인
    @GetMapping("/{orderId}")
    public void getOrder(@PathVariable Long orderId) {

    }

    //주문 취소
    @DeleteMapping("/{orderId}")
    public void cancelOrder(@PathVariable Long orderId) {

    }
}
