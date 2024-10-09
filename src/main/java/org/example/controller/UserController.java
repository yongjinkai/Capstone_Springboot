package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @GetMapping
    public ResponseEntity<Object> allUsers(){
        return new ResponseEntity<> (userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userRepository.save(user),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        User updatedUser = userRepository.findById(userId).get();
        if (user.getName() != null)
            updatedUser.setName(user.getName());
        if (user.getEmail() != null)
            updatedUser.setEmail(user.getEmail());
        if (user.getPhone() != null)
            updatedUser.setPhone(user.getPhone());
        return new ResponseEntity<>(userRepository.save(updatedUser),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException());
        userRepository.deleteById(userId);
        return new ResponseEntity<>("User deleted",HttpStatus.OK);
    }
}
