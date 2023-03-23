package com.realtime.smartcontactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Home page -SmartContactManager");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About page -SmartContactManager");
        return "about";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    } 
    
}
