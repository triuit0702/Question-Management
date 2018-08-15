package com.huongdanjava.categoryservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping(value= "/")
    public String home() {
        return "<html><h1>Hello</h1></html>";
    }
}
