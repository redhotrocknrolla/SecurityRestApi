package com.example.securityboot.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.example.securityboot.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class RegistrationController {

    @GetMapping()
    public String getUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("user", user);
        return "user";
    }
}
