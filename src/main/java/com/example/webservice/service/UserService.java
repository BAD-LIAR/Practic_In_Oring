package com.example.webservice.service;

import com.example.webservice.dto.UserDto;
import com.example.webservice.models.User;

import java.util.List;

public interface UserService {

    User save(User user);
    void delete(User user);
    void delete(Long id);
    UserDto get(Long id);
    List<User> getAll();
}
