package com.urfu.tracing.controllers;

import com.urfu.tracing.constants.TemplateName;
import com.urfu.tracing.model.tracing.OrderEntity;
import com.urfu.tracing.services.TracingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class SearchPageController {

    private final TracingService tracingService;

    @RequestMapping(value = "/searchOrder")
    public String getSearchPage() {

        tracingService.saveOrder(new OrderEntity(UUID.randomUUID(), 12345678, UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(),
                "Описание", "Статус", 1000.0));
        return TemplateName.SEARCH_ORDER_PAGE;
    }
}
