package com.example.googleOAuth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home1"; // Ensure that this view exists in your templates directory
    }
}
