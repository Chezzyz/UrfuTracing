package com.urfu.tracing.amqp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Value
@JsonDeserialize
public class ContractorDto {

    @NonNull
    UUID uuid;

    @Nullable
    String firstName;

    @Nullable
    String secondName;

    @NonNull
    String numberPhone;

}
