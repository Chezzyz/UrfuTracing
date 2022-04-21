package com.urfu.tracing.amqp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@JsonDeserialize
@Value
public class UpdateOrderStatusDto {

    @Positive
    Integer orderNumber;

    @NotBlank
    String status;

}
