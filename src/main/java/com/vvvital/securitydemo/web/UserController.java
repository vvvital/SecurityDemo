package com.vvvital.securitydemo.web;

import com.vvvital.securitydemo.Service.UserService;
import com.vvvital.securitydemo.model.Role;
import com.vvvital.securitydemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping ("/unauthorized")
    public String unauthorized(){
        return "unauthorized data";
    }

    @GetMapping ("/authorized")
    public String authorized(){
        return "authorized data";
    }

    @GetMapping ("/admin")
    public String admin(){
        return "admin data";
    }

    @GetMapping ("/user")
    public String user(Principal principal){
        return principal.getName();
    }

//    @GetMapping("/login")
//    public String logIn(){
//        return "loginForm.html";
//    }

}
