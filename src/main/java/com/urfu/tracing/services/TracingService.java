package com.urfu.tracing.services;

import com.urfu.tracing.dao.TracingDao;
import com.urfu.tracing.model.tracing.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Service
@RequiredArgsConstructor
public class TracingService {

    private final TracingDao dao;

    public void saveOrder(OrderEntity order) {
        dao.saveOrder(order);
    }

//    public OrderEntity getOrderByNumber(@Valid @Positive Integer orderNumber) {
//        return dao.getOrderByNumber(orderNumber);
//    }
//
//    public void updateOrder(OrderEntity order) {
//        dao.updateOrder(order);
//    }

}
