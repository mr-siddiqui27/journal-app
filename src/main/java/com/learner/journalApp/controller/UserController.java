package com.learner.journalApp.controller;

import com.learner.journalApp.entity.JournalEntry;
import com.learner.journalApp.entity.User;
import com.learner.journalApp.service.JournalEntryService;
import com.learner.journalApp.service.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController         // Marks the class as a REST Controller     , -Receives HTTP Requests.       , -Returns JSON/String as response.
@RequestMapping("/user")        //Defines the Base URL.
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @GetMapping("/id/{id}")
    public Optional<User> getUserById(@PathVariable ObjectId id){
        return userService.findById(id);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName){    // it will give username and password filed to update
        User userInDb = userService.findByUserName(userName);
        if(userInDb!=null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
