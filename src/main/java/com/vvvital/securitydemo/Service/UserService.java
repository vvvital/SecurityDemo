package com.vvvital.securitydemo.Service;

import com.vvvital.securitydemo.Repository.UserRepository;
import com.vvvital.securitydemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user){
         userRepository.save(user);
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
