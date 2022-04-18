package com.urfu.tracing.converters;

import com.urfu.tracing.model.tracing.entity.ContractorEntity;
import com.urfu.tracing.model.tracing.entity.OfficeEntity;
import com.urfu.tracing.model.tracing.entity.OrderEntity;
import com.urfu.tracing.model.tracingPage.Contractor;
import com.urfu.tracing.model.tracingPage.Office;
import com.urfu.tracing.model.tracingPage.Order;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class TracingPageDataConverter {

    @NonNull
    public Order convertOrder(@NonNull OrderEntity entity) {
        return new Order(entity.getOrderNumber(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getCost());
    }

    @NonNull
    public Office convertOffice(@NonNull OfficeEntity entity) {
        return new Office(entity.getAddress(),
                entity.getWorkTimeBegin(),
                entity.getWorkTimeEnd(),
                entity.getWorkDayBegin(),
                entity.getWorkDayEnd());
    }

    @NonNull
    public Contractor convertContractor(@NonNull ContractorEntity entity) {
        return new Contractor(entity.getFirstName(), entity.getSecondName(), entity.getNumberPhone());
    }

}
