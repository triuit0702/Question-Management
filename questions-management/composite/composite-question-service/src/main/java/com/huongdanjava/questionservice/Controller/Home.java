package com.huongdanjava.questionservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/")
    public String homeController() {
        return "<html><h1>Composite</h1></html>";
    }
}
