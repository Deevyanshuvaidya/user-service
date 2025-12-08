package com.example.user_service.service.impl;

import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.User;
import com.example.user_service.exception.ResourcenotFoundException;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository){
        this.repository=repository;
    }

    @Override
    public User createUser(UserDto dto) {
        User user = new User();
        mapDtoToEntity(dto,user);
        return repository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDto dto) {
        User user = repository.findById(id).orElseThrow(()-> new ResourcenotFoundException("User not found"));
        mapDtoToEntity(dto,user);
        return repository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourcenotFoundException("User Not Found"));
    }
        

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        if(!repository.existsById(id))
            throw new ResourcenotFoundException("User Not Found");

        repository.deleteById(id);;
    }
    

    private void mapDtoToEntity(UserDto dto, User user){
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setAddress(dto.getAddress());
        user.setCity(dto.getCity());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setOrganizationName(dto.getOrganizationName());
    }
}
