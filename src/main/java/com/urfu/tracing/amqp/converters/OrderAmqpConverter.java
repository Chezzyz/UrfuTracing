package com.urfu.tracing.amqp.converters;

import com.urfu.tracing.amqp.dto.ContractorDto;
import com.urfu.tracing.amqp.dto.OfficeDto;
import com.urfu.tracing.amqp.dto.OrderDto;
import com.urfu.tracing.amqp.dto.OrderEventDto;
import com.urfu.tracing.model.tracing.entity.ContractorEntity;
import com.urfu.tracing.model.tracing.entity.OfficeEntity;
import com.urfu.tracing.model.tracing.entity.OrderEntity;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class OrderAmqpConverter {

    @NonNull
    public OrderEntity convertOrder(@NonNull OrderEventDto dto) {
        OrderDto orderDto = dto.getOrder();

        return new OrderEntity(null,
                orderDto.getUuid(),
                orderDto.getOrderNumber(),
                dto.getSender().getUuid(),
                dto.getReceiver().getUuid(),
                dto.getOffice().getUuid(),
                orderDto.getDescription(),
                orderDto.getStatus(),
                orderDto.getCost());
    }

    public ContractorEntity convertContractor(@NonNull ContractorDto dto) {
        return new ContractorEntity(null, dto.getUuid(), dto.getFirstName(), dto.getSecondName(), dto.getNumberPhone());
    }

    public OfficeEntity convertOffice(@NonNull OfficeDto dto) {
        return new OfficeEntity(null, dto.getUuid(), dto.getAddress(), dto.getWorkTimeBegin(), dto.getWorkTimeEnd(),
                dto.getWorkDayBegin().name(), dto.getWorkDayEnd().name());
    }

}
