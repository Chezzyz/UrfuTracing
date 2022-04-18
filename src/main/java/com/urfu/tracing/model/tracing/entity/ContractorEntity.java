package com.urfu.tracing.model.tracing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Getter
@Table(name = "contractor")
@NoArgsConstructor
@AllArgsConstructor
public class ContractorEntity {
    @Id
    private Integer id;

    @NonNull
    @Column(name = "uuid")
    private UUID uuid;
    
    @Nullable
    @Column(name = "first_name")
    private String firstName;
    
    @Nullable
    @Column(name = "second_name")
    private String secondName;
    
    @NotBlank
    @Column(name = "number_phone")
    private String numberPhone;
    
}
