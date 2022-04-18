package com.urfu.tracing.model.tracing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    private Integer id;

    @NonNull
    private UUID uuid;

    @NonNull
    @Positive(message = "orderNumber must be positive")
    @Column(name = "order_number")
    private Integer orderNumber;

    @NonNull
    @Column(name = "sender_uuid")
    private UUID senderUuid;

    @NonNull
    @Column(name = "receiver_uuid")
    private UUID receiverUuid;

    @NonNull
    @Column(name = "office_uuid")
    private UUID officeUuid;

    @Nullable
    @Column(name = "description")
    private String description;

    @NotBlank
    @NonNull
    @Column(name = "status")
    private String status;

    @NonNull
    @Column(name = "cost")
    private Double cost;

}
