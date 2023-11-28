package com.vvvital.securitydemo.Service;

import com.vvvital.securitydemo.Repository.UserRepository;
import com.vvvital.securitydemo.SpringSecurityConfig;
import com.vvvital.securitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    SpringSecurityConfig securityConfig;


    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
