package com.example.task.controller;

import com.example.task.mapper.UserMapper;
import com.example.task.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserMapper userMapper;

    public UsersController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userMapper.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userMapper.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        User existingUser = userMapper.findById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        userMapper.update(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User existingUser = userMapper.findById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        userMapper.delete(id);
        return ResponseEntity.noContent().build();
    }
}
