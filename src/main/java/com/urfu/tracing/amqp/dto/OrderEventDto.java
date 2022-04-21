package com.urfu.tracing.amqp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.NonNull;
import lombok.Value;

@Value
@JsonDeserialize
public class OrderEventDto {

    @NonNull
    OrderDto order;

    @NonNull
    OfficeDto office;

    @NonNull
    ContractorDto sender;

    @NonNull
    ContractorDto receiver;

}
