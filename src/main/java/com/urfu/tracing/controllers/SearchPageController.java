package com.urfu.tracing.controllers;

import com.urfu.tracing.constants.TemplateName;
import com.urfu.tracing.services.TracingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class SearchPageController {

    @RequestMapping(value = "/tracing/searchOrder", method = RequestMethod.GET)
    @ResponseBody
    public String getSearchPage() {
        return TemplateName.SEARCH_ORDER_PAGE;
    }
}
