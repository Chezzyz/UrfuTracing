package com.urfu.tracing.dao;

import com.urfu.tracing.dao.repository.OrderRepository;
import com.urfu.tracing.model.tracing.entity.OrderEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Repository
@RequiredArgsConstructor
@Transactional
public class OrderDao {

    private final OrderRepository repository;

    public void saveOrder(@NonNull OrderEntity order) {
        repository.saveOrder(order.getUuid(), order.getOrderNumber(), order.getSenderUuid(), order.getReceiverUuid(),
                order.getOfficeUuid(), order.getDescription(), order.getStatus(), order.getCost());
    }

    public void updateOrderStatus(@Positive Integer orderNumber, @NotBlank String status) {
        repository.updateOrderStatus(orderNumber, status);
    }

    @Nullable
    public OrderEntity findOrderByNumber(Integer orderNumber) {
        return repository.findOrderByNumber(orderNumber);
    }

}
