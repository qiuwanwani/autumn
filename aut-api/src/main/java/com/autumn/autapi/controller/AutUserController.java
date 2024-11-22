package com.autumn.autapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AutUserController {

    @RequestMapping("/select")
    public String getUserById(@RequestParam("id") String id) {
        return "user";
    }
}
