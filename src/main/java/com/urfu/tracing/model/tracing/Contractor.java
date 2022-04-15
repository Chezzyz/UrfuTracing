package com.urfu.tracing.model.tracing;

import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Value
public class Contractor {
    @NonNull
    UUID uuid;
    
    @Nullable
    String firstName;
    
    @Nullable
    String secondName;
    
    @NonNull
    String numberPhone;
    
}
