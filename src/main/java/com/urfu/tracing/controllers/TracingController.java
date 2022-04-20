package com.urfu.tracing.controllers;

import com.urfu.tracing.constants.TemplateName;
import com.urfu.tracing.model.tracingPage.TracingPageData;
import com.urfu.tracing.services.TracingPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Controller
@Validated
@RequiredArgsConstructor
@RequestMapping("/tracing")
public class TracingController {

    private final TracingPageService tracingPageService;

    @RequestMapping(value = "/trace", method = RequestMethod.GET)
    public String getTracingPage(@RequestParam("orderNumber") @Positive Integer orderNumber,
            @RequestParam("phone") @NotBlank String phoneNumberDigits,
            ModelMap modelMap) {
        TracingPageData pageData = tracingPageService.getTracingPageData(orderNumber, phoneNumberDigits);

        modelMap.addAttribute("order", pageData.getOrder());
        modelMap.addAttribute("office", pageData.getOffice());
        modelMap.addAttribute("sender", pageData.getSender());
        modelMap.addAttribute("receiver", pageData.getReceiver());

        return TemplateName.TRACING_PAGE;
    }

}
