package com.urfu.tracing.dao;

import com.urfu.tracing.dao.repository.OrderRepository;
import com.urfu.tracing.model.tracing.entity.OrderEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
@Validated
public class OrderDao {

    private final OrderRepository repository;

    public void saveOrder(@NonNull OrderEntity order) {
        repository.saveOrder(order.getUuid(), order.getOrderNumber(), order.getSenderUuid(), order.getReceiverUuid(),
                order.getOfficeUuid(), order.getDescription(), order.getStatus(), order.getCost());
    }

    public OrderEntity findOrderByNumber(Integer orderNumber) {
        return repository.findOrderByNumber(orderNumber);
    }

}
