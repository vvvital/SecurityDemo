package com.vvvital.securitydemo.Service;

import com.vvvital.securitydemo.Repository.UserRepository;
import com.vvvital.securitydemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(
                "User not found"
        ));
    }

}
