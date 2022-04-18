package com.urfu.tracing.model.tracingPage;

import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

@Value
public class Contractor {

    @Nullable
    String firstName;

    @Nullable
    String secondName;

    @NonNull
    String phoneNumber;

}
