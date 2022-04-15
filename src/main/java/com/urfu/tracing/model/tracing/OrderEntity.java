package com.urfu.tracing.model.tracing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class OrderEntity {
    @NonNull
    @Id
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
    @Column(name = "static")
    private String status;

    @NonNull
    @Column(name = "cost")
    private Double cost;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        OrderEntity that = (OrderEntity) o;
        return uuid != null && Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
