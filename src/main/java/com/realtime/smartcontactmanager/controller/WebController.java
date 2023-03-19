package com.realtime.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.realtime.smartcontactmanager.dao.UserRepository;
import com.realtime.smartcontactmanager.entity.User;

@Controller
public class WebController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home page -SmartContactManager");
        return "home";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("title", "Sign up -SmartContactManager");
        return "signup";
    }

    @GetMapping("/signin")
    public String signIn(Model model){
        model.addAttribute("title", "Sign in -SmartContactManager");
        return "signin";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About page -SmartContactManager");
        return "about";
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test(){

        var user = new User("jhhjhkhkj", "jhhgjkh@gmail.com", "kjhjklh");
        userRepository.save(user);
        return "This is working successfully";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    } 
    
    
}
