package com.urfu.tracing.services;

import com.urfu.tracing.dao.ContractorDao;
import com.urfu.tracing.model.tracing.entity.ContractorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContractorService {

    ContractorDao dao;

    public ContractorEntity findContractorByUuid(UUID uuid){
        return dao.findContractorByUuid(uuid);
    }

    public String findContractorPhoneNumber(UUID uuid){
        return dao.findContractorPhoneNumber(uuid);
    }

}
