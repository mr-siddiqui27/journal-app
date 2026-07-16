package com.learner.journalApp.service.service;


// BEST PRACTICE-
// Controller calls -> service
// Service calls -> repository
// Controller ---> Service ---> Repository

import com.learner.journalApp.entity.JournalEntry;
import com.learner.journalApp.entity.User;
import com.learner.journalApp.repository.JournalEntryRepository;
import com.learner.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;            // Dependency injection

    public void saveEntry(User user){
        try{
            userRepository.save(user);
        }catch (Exception e){
            log.error("Exception", e);
        }

    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

}
