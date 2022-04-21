package com.urfu.tracing.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.urfu.tracing.amqp.converters.OrderAmqpConverter;
import com.urfu.tracing.amqp.dto.OrderEventDto;
import com.urfu.tracing.amqp.dto.UpdateOrderStatusDto;
import com.urfu.tracing.services.ContractorService;
import com.urfu.tracing.services.OfficeService;
import com.urfu.tracing.services.OrderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderAmqpProcessor {

    private final OrderAmqpConverter orderAmqpConverter;

    private final OrderService orderService;

    private final ContractorService contractorService;

    private final OfficeService officeService;

    private final ObjectMapper objectMapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();

    private final CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(queues = "urfu-orders-create")
    @SneakyThrows
    public void receiveCreateMessage(@NonNull String message) {
        OrderEventDto orderEvent = objectMapper.readValue(message, OrderEventDto.class);
        log.info("get createOrder event from urfu-orders-create queue");

        orderService.saveOrder(orderAmqpConverter.convertOrder(orderEvent));
        contractorService.saveContractor(orderAmqpConverter.convertContractor(orderEvent.getSender()));
        contractorService.saveContractor(orderAmqpConverter.convertContractor(orderEvent.getReceiver()));
        officeService.saveOffice(orderAmqpConverter.convertOffice(orderEvent.getOffice()));

        log.info("saved order to DB: {}", orderEvent);
        latch.countDown();
    }

    @RabbitListener(queues = "urfu-orders-update-status")
    @SneakyThrows
    public void receiveUpdateStatusMessage(@NonNull String message) {
        log.info("get updateOrderStatus event from urfu-orders-update-status queue");

        UpdateOrderStatusDto dto = objectMapper.readValue(message, UpdateOrderStatusDto.class);

        orderService.updateOrderStatus(dto.getOrderNumber(), dto.getStatus());

        log.info("updated the status of order {} to \"{}\"", dto.getOrderNumber(), dto.getStatus());
        latch.countDown();
    }

}
