package com.urfu.tracing.services;

import com.urfu.tracing.dao.ContractorDao;
import com.urfu.tracing.model.tracing.entity.ContractorEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContractorService {

    private final ContractorDao dao;

    public void saveContractor(@NonNull ContractorEntity contractorEntity) {
        dao.saveContractor(contractorEntity);
    }

    @Nullable
    public ContractorEntity findContractorByUuid(@NonNull UUID uuid) {
        return dao.findContractorByUuid(uuid);
    }

    @Nullable
    public String findContractorPhoneNumber(@NonNull UUID uuid) {
        return dao.findContractorPhoneNumber(uuid);
    }

}
