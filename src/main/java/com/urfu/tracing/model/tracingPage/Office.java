package com.urfu.tracing.model.tracingPage;

import lombok.NonNull;
import lombok.Value;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Value
public class Office {

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
