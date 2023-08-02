package com.dmitrychinyaev.postsService.service;

import com.dmitrychinyaev.postsService.domain.Role;
import com.dmitrychinyaev.postsService.domain.User;
import com.dmitrychinyaev.postsService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public void addUser(User user){
        User checkUser = userRepository.findByUsername(user.getUsername());
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
    }
}