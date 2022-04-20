package com.urfu.tracing.formatters;

import com.urfu.tracing.constants.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderStatusFormatter {

    private final Map<String, String> statusMap = Map
            .ofEntries(
                    Map.entry(OrderStatus.CREATED, "Создан"),
                    Map.entry(OrderStatus.IN_PROGRESS, "В пути"),
                    Map.entry(OrderStatus.DELIVERED, "Доставлен"));

    public String getRusStatus(String engStatus){
        return statusMap.get(engStatus);
    }
}
