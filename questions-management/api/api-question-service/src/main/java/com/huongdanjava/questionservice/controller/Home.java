package com.huongdanjava.questionservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping(value= "/")
    public String home() {
        return "<html><h1>API Question Service</h1></html>";
    }
}
