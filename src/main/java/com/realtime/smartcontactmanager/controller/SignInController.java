package com.realtime.smartcontactmanager.controller;

import com.realtime.smartcontactmanager.entity.UserEntity;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signin")
public class SignInController {

    @GetMapping
    public String signIn(Model model, HttpSession session){
        model.addAttribute("title", "Sign in -SmartContactManager");
        var user = new UserEntity();
        model.addAttribute("user", user);
        session.setAttribute("userEmail", user.getEmail());
        return "signin";
    }

//     @PostMapping
//     @ResponseBody
//     public String doSignIn(){
//         return "Registration successful, now you can login";
//     }

}
