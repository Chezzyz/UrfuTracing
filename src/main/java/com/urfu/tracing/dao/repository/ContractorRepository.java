package com.urfu.tracing.dao.repository;

import com.urfu.tracing.model.tracing.entity.ContractorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ContractorRepository extends JpaRepository<ContractorEntity, UUID> {

    @Query(value = "select c.id, c.uuid, c.first_name, c.second_name, c.number_phone from contractor c where uuid = :uuid", nativeQuery = true)
    ContractorEntity findContractorByUuid(@Param("uuid") UUID uuid);

    @Query(value = "select c.number_phone from contractor c where uuid = :uuid", nativeQuery = true)
    String findContractorPhoneNumber(@Param("uuid") UUID uuid);

}
