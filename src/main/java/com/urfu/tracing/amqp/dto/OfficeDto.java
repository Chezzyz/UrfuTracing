package com.urfu.tracing.amqp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NonNull;
import lombok.Value;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Value
@JsonDeserialize
public class OfficeDto {

    @NonNull
    UUID uuid;

    @NonNull
    String address;

    @NonNull
    LocalTime workTimeBegin;

    @NonNull
    LocalTime workTimeEnd;

    @NonNull
    DayOfWeek workDayBegin;

    @NonNull
    DayOfWeek workDayEnd;

}
