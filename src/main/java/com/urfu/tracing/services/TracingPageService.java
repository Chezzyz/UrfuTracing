package com.urfu.tracing.services;

import com.urfu.tracing.converters.TracingPageDataConverter;
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

    private final TracingService tracingService;

    private final OfficeService officeService;

    private final ContractorService contractorService;

    private final AuthService authService;

    private final TracingPageDataConverter converter;

    @NonNull
    public TracingPageData getTracingPageData(@NonNull Integer orderNumber, @NonNull String phoneNumberDigits){
        OrderEntity orderEntity = tracingService.findOrderByNumber(orderNumber);

        if(orderEntity == null){
            throw new IllegalStateException("Заказ не найден");
        }

        if(!authService.isAuthorized(orderEntity, phoneNumberDigits)){
            throw new IllegalStateException("Аутентификация пользователя не пройдена");
        }

        Order order = converter.convertOrder(orderEntity);
        Office office = converter.convertOffice(officeService.findOfficeByUuid(orderEntity.getOfficeUuid()));
        Contractor sender = converter.convertContractor(contractorService.findContractorByUuid(orderEntity.getSenderUuid()));
        Contractor receiver = converter.convertContractor(contractorService.findContractorByUuid(orderEntity.getReceiverUuid()));

        return new TracingPageData(order, office, sender, receiver);
    }
}
