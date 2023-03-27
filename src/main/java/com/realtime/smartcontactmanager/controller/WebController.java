package com.realtime.smartcontactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About page -SmartContactManager");
        return "about";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }

    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logoutSuccess")
    public String logoutSuccess(){
        return "logoutSuccess";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

    @GetMapping("/index")
        public String index(){
        return "index";
    }
    
}
