package com.urfu.tracing.services;

import com.urfu.tracing.dao.OrderDao;
import com.urfu.tracing.model.tracing.entity.OrderEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jboss.logging.annotations.Pos;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Service
@Validated
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao dao;

    public void saveOrder(@NonNull @Valid OrderEntity order) {
        dao.saveOrder(order);
    }

    public void updateOrderStatus(@Positive Integer orderNumber, @NotBlank String status) {
        if(findOrderByNumber(orderNumber) == null){
            throw new IllegalStateException("updated order in null");
        }

        dao.updateOrderStatus(orderNumber, status);
    }

    @Nullable
    public OrderEntity findOrderByNumber(@Positive Integer orderNumber) {
        return dao.findOrderByNumber(orderNumber);
    }

}
