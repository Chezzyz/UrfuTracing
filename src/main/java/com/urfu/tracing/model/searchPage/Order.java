package com.urfu.tracing.model.searchPage;

import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Value
public class Order {

    @NonNull
    @Positive(message = "orderNumber must be positive")
    Integer orderNumber;

    @Nullable
    String description;

    @NotBlank
    @NonNull
    String status;

    @NonNull
    Double cost;

}
