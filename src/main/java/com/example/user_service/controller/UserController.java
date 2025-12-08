package com.example.user_service.controller;

import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.User;
import com.example.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service= service;
    }


    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto dto){
        return ResponseEntity.ok(service.createUser(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserDto dto){
        return ResponseEntity.ok(service.updateUser(id,dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id){
        return ResponseEntity.ok(service.getUser(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> all(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.deleteUser(id);
        return ResponseEntity.ok("User Deleted Successfully.!");
    }

    
}
