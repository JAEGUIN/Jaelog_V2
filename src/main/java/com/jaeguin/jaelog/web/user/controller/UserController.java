package com.jaeguin.jaelog.web.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/login")
    public String login(){
        return "user/loginForm";
    }

    @GetMapping("/user/register")
    public String register(){
        return "user/registerForm";
    }
}
