package com.urfu.tracing.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.urfu.tracing.amqp.converters.OrderAmqpConverter;
import com.urfu.tracing.amqp.dto.OrderEventDto;
import com.urfu.tracing.services.ContractorService;
import com.urfu.tracing.services.OfficeService;
import com.urfu.tracing.services.OrderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@RequiredArgsConstructor
public class OrderAmqpProcessor {

    private final OrderAmqpConverter orderAmqpConverter;

    private final OrderService orderService;

    private final ContractorService contractorService;

    private final OfficeService officeService;

    private final ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();

    private final CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener
    @SneakyThrows
    public void receiveMessage(@NonNull String message) {
        OrderEventDto orderEvent = objectMapper.readValue(message, OrderEventDto.class);

        orderService.saveOrder(orderAmqpConverter.convertOrder(orderEvent));
        contractorService.saveContractor(orderAmqpConverter.convertContractor(orderEvent.getSender()));
        contractorService.saveContractor(orderAmqpConverter.convertContractor(orderEvent.getReceiver()));
        officeService.saveOffice(orderAmqpConverter.convertOffice(orderEvent.getOffice()));

        latch.countDown();
    }
}
