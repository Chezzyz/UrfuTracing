package com.urfu.tracing.dao;

import com.urfu.tracing.dao.repository.TracingRepository;
import com.urfu.tracing.model.tracing.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class TracingDao {
    private final TracingRepository repository;


    public void saveOrder(OrderEntity order) {
        repository.saveOrder(order);
    }

//    public OrderEntity getOrderByNumber(@Valid @Positive Integer orderNumber) {
//        return repository.findOrderByNumber(orderNumber);
//    }
//
//    public void updateOrder(OrderEntity order) {
//        repository.updateOrder(order);
//    }
}
