package com.example.webservice.service;

import com.example.webservice.dto.UserDto;
import com.example.webservice.models.User;
import com.example.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto get(Long id) {
        return UserDto.from(userRepository.getById(id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
