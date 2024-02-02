package com.exampleblog.firstblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    final String HW = "Hello, World!";

    @GetMapping("/")
    public String returnHelloWorld() {
        return HW;
    }
}
