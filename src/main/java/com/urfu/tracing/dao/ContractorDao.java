package com.urfu.tracing.dao;

import com.urfu.tracing.dao.repository.ContractorRepository;
import com.urfu.tracing.model.tracing.entity.ContractorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Validated
@Transactional
@RequiredArgsConstructor
public class ContractorDao {

    ContractorRepository repository;

    public ContractorEntity findContractorByUuid(UUID uuid){
        return repository.findContractorByUuid(uuid);
    }

    public String findContractorPhoneNumber(UUID uuid){
        return repository.findContractorPhoneNumber(uuid);
    }
}
