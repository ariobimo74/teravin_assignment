package com.teravintech.assignment.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/biodata")
public class BiodataController
{
    @GetMapping
    public String BiodataController()
    {
        return "pages/biodata";
    }
}
