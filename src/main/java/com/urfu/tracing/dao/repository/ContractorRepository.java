package com.urfu.tracing.dao.repository;

import com.urfu.tracing.model.tracing.entity.ContractorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ContractorRepository extends JpaRepository<ContractorEntity, UUID> {

    @Modifying
    @Query(value = "insert into contractors(uuid, first_name, second_name, number_phone, create_timestamp, update_timestamp) " +
            "values (:uuid, :firstName, :secondName, :numberPhone, now(), now())" +
            "on conflict (uuid) do update set " +
            "first_name=:firstName, second_name=:secondName, number_phone=:numberPhone, update_timestamp=now()",
            nativeQuery = true)
    void saveContractor(@Param("uuid") UUID uuid,
            @Param("firstName") String firstName,
            @Param("secondName") String secondName,
            @Param("numberPhone") String numberPhone);

    @Query(value = "select c.id, c.uuid, c.first_name, c.second_name, c.number_phone from contractors c where uuid = :uuid", nativeQuery = true)
    ContractorEntity findContractorByUuid(@Param("uuid") UUID uuid);

    @Query(value = "select c.number_phone from contractors c where uuid = :uuid", nativeQuery = true)
    String findContractorPhoneNumber(@Param("uuid") UUID uuid);

}
