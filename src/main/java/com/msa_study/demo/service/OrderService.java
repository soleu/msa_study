package com.msa_study.demo.service;

import com.msa_study.demo.common.exception.LackOfStockException;
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
import com.msa_study.demo.service.dto.request.OrderCreateRequest;
import com.msa_study.demo.service.dto.response.OrderCreateResponse;
import com.msa_study.demo.service.dto.response.OrderGetResponse;
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

    public OrderCreateResponse createOrder(final OrderCreateRequest request) {
        final Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(NotExistsMemberException::new);
        final Product product = productRepository.findById(request.getProductId())
                .orElseThrow(NotExistsProductException::new);
        if (0 >= product.getStockQuantity()) throw new LackOfStockException();

            final Order order = Order.newInstance(member, product, product.getPrice(), OrderStatus.ORDER);
        orderRepository.save(order);
        product.reduceStock();

        return OrderCreateResponse.of(order);
    }

    @Transactional(readOnly = true)
    public OrderGetResponse getOrder(final Long orderId) {
        final Order order = orderRepository.findById(orderId)
                .orElseThrow(NotExistsOrderException::new);

        return OrderGetResponse.of(order);
    }

    public void cancelOrder(final Long orderId) {
        final Order order = orderRepository.findById(orderId)
                .orElseThrow(NotExistsOrderException::new);

        order.cancel();
    }
}
