package com.peaksoft.service;

import com.peaksoft.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();

    User findById(Integer id);

    void saveUser(User user);

    User update(User user);

    void deleteById(Integer id);
}
