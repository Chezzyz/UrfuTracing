package com.urfu.tracing.dao;

import com.urfu.tracing.dao.repository.OfficeRepository;
import com.urfu.tracing.model.tracing.entity.OfficeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.persistence.metamodel.BasicType;
import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Validated
@Transactional
@RequiredArgsConstructor
public class OfficeDao {

    private final OfficeRepository repository;

    public void saveOffice(OfficeEntity officeEntity) {
        repository.saveOffice(officeEntity.getUuid(), officeEntity.getAddress(), officeEntity.getWorkTimeBegin(),
                officeEntity.getWorkTimeEnd(), officeEntity.getWorkDayBegin(), officeEntity.getWorkDayEnd());
    }

    public OfficeEntity findOfficeByUuid(UUID uuid) {
        return repository.findOfficeByUuid(uuid);
    }

}
