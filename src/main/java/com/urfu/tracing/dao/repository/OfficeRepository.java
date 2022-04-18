package com.urfu.tracing.dao.repository;

import com.urfu.tracing.model.tracing.entity.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface OfficeRepository extends JpaRepository<OfficeEntity, UUID> {

    @Query(value = "select o.id, o.uuid, o.address, o.work_time_begin, o.work_time_end, o.work_day_begin, o.work_day_end" +
            " from office o", nativeQuery = true)
    OfficeEntity findOfficeByUuid(@Param("uuid") UUID uuid);

}
