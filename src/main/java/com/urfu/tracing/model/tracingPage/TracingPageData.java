package com.urfu.tracing.model.tracingPage;

import lombok.NonNull;
import lombok.Value;

@Value
public class TracingPageData {

    @NonNull
    Order order;

    @NonNull
    Office office;

    @NonNull
    Contractor receiver;

    @NonNull
    Contractor sender;

}
