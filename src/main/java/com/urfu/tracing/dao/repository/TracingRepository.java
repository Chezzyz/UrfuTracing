package com.urfu.tracing.dao.repository;

import com.urfu.tracing.model.tracing.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.UUID;


public interface TracingRepository extends JpaRepository<OrderEntity, UUID> {

    @Modifying
    @Query(value="insert into orders(uuid , order_number, sender_uuid, receiver_uuid, office_uuid, description, status, cost, update_timestamp)" +
            " values (:order.uuid, :order.orderNumber, :order.senderUuid, :order.receiverUuid, :order.officeUuid, " +
            ":order.description, :order.status, :order.cost, now())", nativeQuery = true)
    void saveOrder(@Param("order") OrderEntity order);


    //OrderEntity findOrderByNumber(@Valid @Positive Integer orderNumber);

    //void updateOrder(OrderEntity order);

}
