package com.urfu.tracing.controllers;

import com.urfu.tracing.constants.TemplateName;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class SearchPageController {

    @Value("${api.urfu.office.host}")
    private String urfuOfficeModuleHost;

    @RequestMapping(value = "/tracing/searchOrder", method = RequestMethod.GET)
    public String getSearchPage(ModelMap modelMap) {
        modelMap.addAttribute("urfuOfficeHost", urfuOfficeModuleHost);

        return TemplateName.SEARCH_ORDER_PAGE;
    }

}
