package com.urfu.tracing.model.tracingPage;

import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

@Value
public class TracingPageData {

    @NonNull
    Order order;

    @NonNull
    Office office;

    @Nullable
    Contractor receiver;

    @Nullable
    Contractor sender;

}
