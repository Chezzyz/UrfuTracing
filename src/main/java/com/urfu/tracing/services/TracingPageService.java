package com.urfu.tracing.services;

import com.urfu.tracing.converters.TracingPageDataConverter;
import com.urfu.tracing.model.tracing.entity.ContractorEntity;
import com.urfu.tracing.model.tracing.entity.OfficeEntity;
import com.urfu.tracing.model.tracing.entity.OrderEntity;
import com.urfu.tracing.model.tracingPage.Contractor;
import com.urfu.tracing.model.tracingPage.Office;
import com.urfu.tracing.model.tracingPage.Order;
import com.urfu.tracing.model.tracingPage.TracingPageData;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TracingPageService {

    private final OrderService orderService;

    private final OfficeService officeService;

    private final ContractorService contractorService;

    private final AuthService authService;

    private final TracingPageDataConverter converter;

    @NonNull
    public TracingPageData getTracingPageData(@NonNull Integer orderNumber, @NonNull String phoneNumberDigits) {
        OrderEntity orderEntity = orderService.findOrderByNumber(orderNumber);

        if (orderEntity == null) {
            throw new IllegalStateException("Заказ не найден");
        }

        if (!authService.isAuthorized(orderEntity, phoneNumberDigits)) {
            throw new IllegalStateException("Аутентификация пользователя не пройдена");
        }

        Order order = converter.convertOrder(orderEntity);

        OfficeEntity officeEntity = officeService.findOfficeByUuid(orderEntity.getOfficeUuid());
        if (officeEntity == null) {
            throw new IllegalStateException("Офис не найден");
        }
        Office office = converter.convertOffice(officeEntity);

        ContractorEntity senderEntity = contractorService.findContractorByUuid(orderEntity.getSenderUuid());
        Contractor sender = senderEntity == null ? null : converter.convertContractor(senderEntity);
        ContractorEntity receiverEntity = contractorService.findContractorByUuid(orderEntity.getReceiverUuid());
        Contractor receiver = receiverEntity == null ? null : converter.convertContractor(receiverEntity);

        return new TracingPageData(order, office, sender, receiver);
    }

}
