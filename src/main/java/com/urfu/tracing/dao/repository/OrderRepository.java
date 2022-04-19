package com.urfu.tracing.dao.repository;

import com.urfu.tracing.model.tracing.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;


public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    @Modifying
    @Query(value =
            "insert into orders(uuid , order_number, sender_uuid, receiver_uuid, office_uuid, description, status, " +
                    "cost, update_timestamp, create_timestamp)" +
                    "values (:uuid, :orderNumber, :senderUuid, :receiverUuid, :officeUuid, :description, :status, " +
                    ":cost, now(), now())" +
                    "on conflict (uuid) do update set order_number = :orderNumber, sender_uuid = :senderUuid, " +
                    "receiver_uuid = :receiverUuid," +
                    "office_uuid=:officeUuid, description = :description, status = :status, cost = :cost, " +
                    "update_timestamp = now()",
            nativeQuery = true)
    void saveOrder(@Param("uuid") UUID uuid,
            @Param("orderNumber") Integer orderNumber,
            @Param("senderUuid") UUID senderUuid,
            @Param("receiverUuid") UUID receiverUuid,
            @Param("officeUuid") UUID officeUuid,
            @Param("description") String description,
            @Param("status") String status,
            @Param("cost") Double cost);

    @Query(value =
            "select o.id, o.uuid, o.order_number, o.sender_uuid, o.receiver_uuid, o.office_uuid, o.description, o.status, o.cost " +
                    "from orders o " +
                    "where order_number = :orderNumber " +
                    "order by update_timestamp desc limit 1",
            nativeQuery = true)
    OrderEntity findOrderByNumber(@Param("orderNumber") Integer orderNumber);

}
