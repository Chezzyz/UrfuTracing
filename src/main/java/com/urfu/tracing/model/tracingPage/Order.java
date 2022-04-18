package com.urfu.tracing.model.tracingPage;

import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

@Value
public class Order {

    @NonNull
    Integer orderNumber;

    @Nullable
    String description;

    @NonNull
    String status;

    @NonNull
    Double cost;

}
