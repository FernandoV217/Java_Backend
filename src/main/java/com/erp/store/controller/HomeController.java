package com.erp.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    @GetMapping("/")
    public String HelloMessage() {
        return "Hello World From Spring Boot";
    }
}
