package com.msa_study.demo.service;

import com.msa_study.demo.common.exception.NotExistsMemberException;
import com.msa_study.demo.common.exception.NotExistsOrderException;
import com.msa_study.demo.common.exception.NotExistsProductException;
import com.msa_study.demo.domain.Member;
import com.msa_study.demo.domain.MemberRepository;
import com.msa_study.demo.domain.Order;
import com.msa_study.demo.domain.OrderRepository;
import com.msa_study.demo.domain.OrderStatus;
import com.msa_study.demo.domain.Product;
import com.msa_study.demo.domain.ProductRepository;
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

    public createOrderResponse createOrder(final createOrderRequest request) {
        final Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(NotExistsMemberException::new);
        final Product product = productRepository.findById(request.getProductId())
                .orElseThrow(NotExistsProductException::new);

        final Order order = Order.newInstance(member, product, product.getPrice(), OrderStatus.ORDER);
        orderRepository.save(order);

        return createOrderResponse.of(order);
    }

    @Transactional(readOnly = true)
    public getOrderResponse getOrder(final Long orderId) {
        final Order order = orderRepository.findById(orderId)
                .orElseThrow(NotExistsOrderException::new);

        return getOrderResponse.of(order);
    }

    public void cancelOrder(final Long orderId) {
        final Order order = orderRepository.findById(orderId)
                .orElseThrow(NotExistsOrderException::new);

        order.cancel();
    }
}
