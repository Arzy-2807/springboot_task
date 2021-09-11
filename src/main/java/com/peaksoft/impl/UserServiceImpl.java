package com.peaksoft.impl;

import com.peaksoft.model.User;
import com.peaksoft.repository.UserRepository;
import com.peaksoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {

        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }else {
    throw new RuntimeException("User not found for id"+ id);
        }
        return user;
    }

    @Override
    public void saveUser (User user) {
        this.userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
       this.userRepository.deleteById(id);
    }
}
