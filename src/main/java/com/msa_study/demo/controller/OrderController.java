package com.msa_study.demo.controller;

import com.msa_study.demo.service.OrderService;
import com.msa_study.demo.service.dto.request.OrderCreateRequest;
import com.msa_study.demo.service.dto.response.OrderCreateResponse;
import com.msa_study.demo.service.dto.response.OrderGetResponse;
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
    private final OrderService orderService;

    //create Order
    @PostMapping("")
    public OrderCreateResponse createOrder(OrderCreateRequest request) {
        return orderService.createOrder(request);
    }

    //주문 확인
    @GetMapping("/{orderId}")
    public OrderGetResponse getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    //주문 취소
    @DeleteMapping("/{orderId}")
    public void cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
    }
}
