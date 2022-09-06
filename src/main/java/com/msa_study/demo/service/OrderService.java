package com.msa_study.demo.service;

import com.msa_study.demo.common.exception.NotExistsMemberException;
import com.msa_study.demo.common.exception.NotExistsProductException;
import com.msa_study.demo.domain.entity.Member;
import com.msa_study.demo.domain.entity.Order;
import com.msa_study.demo.domain.entity.OrderStatus;
import com.msa_study.demo.domain.entity.Product;
import com.msa_study.demo.domain.repository.MemberRepository;
import com.msa_study.demo.domain.repository.OrderRepository;
import com.msa_study.demo.domain.repository.ProductRepository;
import com.msa_study.demo.service.dto.createOrderRequest;
import com.msa_study.demo.service.dto.createOrderResponse;
import com.msa_study.demo.service.dto.getOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    final MemberRepository memberRepository;
    final ProductRepository productRepository;
    final OrderRepository orderRepository;

    public createOrderResponse createOrder(createOrderRequest request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(NotExistsMemberException::new);
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(NotExistsProductException::new);

        Order order = Order.newInstance(member, product, product.getPrice(), OrderStatus.ORDER);
        orderRepository.save(order);

        return createOrderResponse.of(order);
    }

    public getOrderResponse getOrder(Long orderId) {
    }

    public void cancelOrder(Long orderId) {
    }
}
