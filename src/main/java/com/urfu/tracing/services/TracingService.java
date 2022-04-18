package com.urfu.tracing.services;

import com.urfu.tracing.dao.OrderDao;
import com.urfu.tracing.model.tracing.entity.OrderEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Service
@Validated
@RequiredArgsConstructor
public class TracingService {

    private final OrderDao dao;

    public void saveOrder(@NonNull @Valid OrderEntity order) {
        dao.saveOrder(order);
    }

    public OrderEntity findOrderByNumber(@Positive Integer orderNumber) {
        return dao.findOrderByNumber(orderNumber);
    }

}
