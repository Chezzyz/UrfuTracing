package com.urfu.tracing.model.tracing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "office")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfficeEntity {
    @Id
    private Integer id;

    @NonNull
    @Column(name = "uuid")
    private UUID uuid;

    @NonNull
    @Column(name = "address")
    private String address;

    @NonNull
    @Column(name = "work_time_begin")
    private LocalTime workTimeBegin;

    @NonNull
    @Column(name = "work_time_end")
    private LocalTime workTimeEnd;

    @NonNull
    @Column(name = "work_day_begin")
    private DayOfWeek workDayBegin;

    @NonNull
    @Column(name = "work_day_end")
    private DayOfWeek workDayEnd;

}
