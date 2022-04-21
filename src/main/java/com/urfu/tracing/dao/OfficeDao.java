package com.urfu.tracing.dao;

import com.urfu.tracing.dao.repository.OfficeRepository;
import com.urfu.tracing.model.tracing.entity.OfficeEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
@RequiredArgsConstructor
public class OfficeDao {

    private final OfficeRepository repository;

    public void saveOffice(@NonNull OfficeEntity officeEntity) {
        repository.saveOffice(officeEntity.getUuid(), officeEntity.getAddress(), officeEntity.getWorkTimeBegin(),
                officeEntity.getWorkTimeEnd(), officeEntity.getWorkDayBegin(), officeEntity.getWorkDayEnd());
    }

    @Nullable
    public OfficeEntity findOfficeByUuid(UUID uuid) {
        return repository.findOfficeByUuid(uuid);
    }

}
