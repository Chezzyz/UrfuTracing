package com.urfu.tracing.controllers;

import com.urfu.tracing.constants.TemplateName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class SearchPageController {

    @RequestMapping(value = "/tracing/searchOrder", method = RequestMethod.GET)
    public String getSearchPage() {
        return TemplateName.SEARCH_ORDER_PAGE;
    }

}
