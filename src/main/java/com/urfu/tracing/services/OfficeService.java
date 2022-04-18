package com.urfu.tracing.services;

import com.urfu.tracing.dao.OfficeDao;
import com.urfu.tracing.model.tracing.entity.OfficeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeDao dao;

    public OfficeEntity findOfficeByUuid(UUID uuid){
        return dao.findOfficeByUuid(uuid);
    }
}
