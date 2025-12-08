package com.example.user_service.service;

import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.User;

import java.util.List;

public interface UserService {

    User createUser(UserDto dto);

    User updateUser(Long id, UserDto dto);

    User getUser(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);

    
}
