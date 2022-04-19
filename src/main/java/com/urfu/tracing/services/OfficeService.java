package com.urfu.tracing.services;

import com.urfu.tracing.dao.OfficeDao;
import com.urfu.tracing.model.tracing.entity.OfficeEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeDao dao;

    public void saveOffice(@NonNull OfficeEntity officeEntity){
        dao.saveOffice(officeEntity);
    }

    @Nullable
    public OfficeEntity findOfficeByUuid(@NonNull UUID uuid){
        return dao.findOfficeByUuid(uuid);
    }
}
