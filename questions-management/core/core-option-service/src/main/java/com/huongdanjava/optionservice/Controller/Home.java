package com.huongdanjava.optionservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping(value = "/")
    public String home() {
        return "<html><h1>Core Option Service</h1></html>";
    }
}
