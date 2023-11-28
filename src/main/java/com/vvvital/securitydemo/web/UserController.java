package com.vvvital.securitydemo.web;

import com.vvvital.securitydemo.Service.UserService;
import com.vvvital.securitydemo.model.Role;
import com.vvvital.securitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private  List<User> USERS = Stream.of(
            new User(1,"Andriy","Andreev", Role.USER),
            new User(2,"Ivan","Ivanov",Role.USER),
            new User(3,"Petro","Petrov",Role.USER)
    ).toList();

    @GetMapping ("/new")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/new/save")
    public String create(){
        //userService.save(user);
        return "save user";
    }

    @GetMapping("/api/getAll")
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping("/api/get{id}")
    public User get(@PathVariable Long id){
        return userService.findById(id);
    }



    @DeleteMapping("/api/delete")
    public void delete (@RequestBody User user){
        userService.delete(user);
    }
}
