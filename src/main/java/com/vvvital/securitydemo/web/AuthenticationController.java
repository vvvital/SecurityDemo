package com.vvvital.securitydemo.web;

import com.vvvital.securitydemo.Service.UserService;
import com.vvvital.securitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register (User user){
        return "AuthenticationController/register  "+user.toString();
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,@RequestParam String password){
        return " method login   "+email+"  "+password;
    }
}
