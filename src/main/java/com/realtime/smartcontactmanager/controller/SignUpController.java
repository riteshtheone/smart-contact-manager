package com.realtime.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realtime.smartcontactmanager.dao.UserRepository;
import com.realtime.smartcontactmanager.entity.User;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String signUp(Model model){
        model.addAttribute("title", "Sign up -SmartContactManager");
        model.addAttribute("user", new User());
        return "signup";
    }
    
    @PostMapping
    public String doSignUp(@ModelAttribute("user") User user, Model model){
        if (!user.isAgreement()) {
            return "signup";
        }
        try {
            user.setRole("user");
            var responce = userRepository.save(user);
            System.out.println(responce);
        } catch (Exception e) {
            e.printStackTrace();
            return "signup";
        }
        return "signin";
    }

    
}