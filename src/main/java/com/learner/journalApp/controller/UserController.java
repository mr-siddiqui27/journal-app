package com.learner.journalApp.controller;

import com.learner.journalApp.entity.User;
import com.learner.journalApp.repository.UserRepository;
import com.learner.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;
import java.util.Optional;

@RestController         // Marks the class as a REST Controller     , -Receives HTTP Requests.       , -Returns JSON/String as response.
@RequestMapping("/user")        //Defines the Base URL.
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/id/{id}")
    public Optional<User> getUserById(@PathVariable ObjectId id){
        return userService.findById(id);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){    // it will give username and password filed to update
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        userRepository.deleteByUserName(userName);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
