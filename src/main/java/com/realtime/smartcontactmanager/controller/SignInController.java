package com.realtime.smartcontactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/signin")
public class SignInController {

    @GetMapping
    public String signIn(Model model){
        model.addAttribute("title", "Sign in -SmartContactManager");
        // model.addAttribute("user", new User());
        return "signin";
    }
    
    @PostMapping
    @ResponseBody
    public String doSignIn(){
        return "Registration successful, now you can login";
    }
    
}
