package com.urfu.tracing.amqp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Value
@JsonDeserialize
public class OrderDto {

    @NonNull
    UUID uuid;

    @NonNull
    Integer orderNumber;

    @NonNull
    UUID senderUuid;

    @NonNull
    UUID receiverUuid;

    @NonNull
    UUID officeUuid;

    @Nullable
    String description;

    @NonNull
    String status;

    @NonNull
    Double cost;

}
