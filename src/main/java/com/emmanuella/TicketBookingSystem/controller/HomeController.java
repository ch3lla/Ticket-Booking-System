package com.emmanuella.TicketBookingSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String greeting() {
        return "index";
    }

    @GetMapping("/register")
    public String register(){ return "register"; }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String manager() {
        return "user";
    }
}
