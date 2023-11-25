package com.vvvital.securitydemo.web;

import com.vvvital.securitydemo.Service.UserService;
import com.vvvital.securitydemo.model.Role;
import com.vvvital.securitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private  List<User> USERS = Stream.of(
            new User(1,"Andriy","Andreev", Role.USER),
            new User(2,"Ivan","Ivanov",Role.USER),
            new User(3,"Petro","Petrov",Role.USER)
    ).toList();

    @GetMapping ("/")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return USERS;
    }

    @GetMapping("/get")
    public User get(@RequestParam Integer id){
        return USERS.stream().filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        USERS.add(user);
        return user;
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam Integer id){
        USERS.removeIf(user -> Objects.equals(user.getId(), id));
    }
}
