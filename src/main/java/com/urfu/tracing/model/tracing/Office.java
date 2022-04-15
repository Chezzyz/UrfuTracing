package com.urfu.tracing.model.tracing;

import lombok.NonNull;
import lombok.Value;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Value
public class Office {
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
