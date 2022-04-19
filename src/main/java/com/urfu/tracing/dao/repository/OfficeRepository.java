package com.urfu.tracing.dao.repository;

import com.urfu.tracing.model.tracing.entity.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.UUID;

public interface OfficeRepository extends JpaRepository<OfficeEntity, UUID> {

    @Modifying
    @Query(value = "insert into offices(uuid, address, work_time_begin, work_time_end, work_day_begin, work_day_end, " +
            "create_timestamp, update_timestamp) " +
            "values (:uuid, :address, :workTimeBegin, :workTimeEnd, :workDayBegin, :workDayEnd, now(), now())" +
            "on conflict (uuid) do update set address=:address, work_time_begin=:workTimeBegin, " +
            "work_time_end=:workTimeEnd, work_day_begin=:workDayBegin, work_day_end=:workDayEnd, update_timestamp=now()",
            nativeQuery = true)
    void saveOffice(@Param("uuid") UUID uuid,
            @Param("address") String address,
            @Param("workTimeBegin") LocalTime workTimeBegin,
            @Param("workTimeEnd") LocalTime workTimeEnd,
            @Param("workDayBegin") String workDayBegin,
            @Param("workDayEnd") String workDayEnd);

    @Query(value =
            "select o.id, o.uuid, o.address, o.work_time_begin, o.work_time_end, o.work_day_begin, o.work_day_end" +
                    " from offices o where uuid=:uuid limit 1", nativeQuery = true)
    OfficeEntity findOfficeByUuid(@Param("uuid") UUID uuid);

}
