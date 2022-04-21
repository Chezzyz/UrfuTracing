package com.urfu.tracing.dao;

import com.urfu.tracing.dao.repository.ContractorRepository;
import com.urfu.tracing.model.tracing.entity.ContractorEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
@RequiredArgsConstructor
public class ContractorDao {

    private final ContractorRepository repository;

    public void saveContractor(@NonNull ContractorEntity contractorEntity) {
        repository.saveContractor(contractorEntity.getUuid(), contractorEntity.getFirstName(),
                contractorEntity.getSecondName(), contractorEntity.getNumberPhone());
    }

    @Nullable
    public ContractorEntity findContractorByUuid(UUID uuid) {
        return repository.findContractorByUuid(uuid);
    }

    @Nullable
    public String findContractorPhoneNumber(UUID uuid) {
        return repository.findContractorPhoneNumber(uuid);
    }
}
