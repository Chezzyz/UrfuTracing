package com.urfu.tracing.formatters;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.Map;

@Component
public class DayOfWeekFormatter {

    private final Map<DayOfWeek, String> dayOfWeekMap = Map
            .ofEntries(
                    Map.entry(DayOfWeek.MONDAY, "Пн"),
                    Map.entry(DayOfWeek.TUESDAY, "Вт"),
                    Map.entry(DayOfWeek.WEDNESDAY, "Ср"),
                    Map.entry(DayOfWeek.THURSDAY, "Чт"),
                    Map.entry(DayOfWeek.FRIDAY, "Пт"),
                    Map.entry(DayOfWeek.SUNDAY, "Сб"),
                    Map.entry(DayOfWeek.SATURDAY, "Вс"));

    public String getRusDay(DayOfWeek day) {
        return dayOfWeekMap.get(day);
    }
}
