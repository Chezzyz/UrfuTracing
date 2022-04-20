package com.urfu.tracing.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderStatus {

    public static final String CREATED = "created";

    public static final String IN_PROGRESS = "in progress";

    public static final String DELIVERED = "delivered";

}
