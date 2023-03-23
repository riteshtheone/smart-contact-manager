package com.realtime.smartcontactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignInController {

    @GetMapping("/signin")
    public String signIn(Model model){
        model.addAttribute("title", "Sign in -SmartContactManager");
        // model.addAttribute("user", new User());
        return "signin";
    }
    
    @PostMapping("/doSignin")
    @ResponseBody
    public String doSignIn(){
        return "Registration successful, now you can login";
    }
    
}
