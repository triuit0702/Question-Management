package com.huongdanjava.categoryservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value="/")
    public String home() {
        return "<html><h1>API Category</h1></html>";
    }
}
