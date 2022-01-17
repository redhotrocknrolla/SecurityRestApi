package com.example.securityboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RegistrationController {

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }
}

