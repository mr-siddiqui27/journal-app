package com.learner.journalApp.service;


// BEST PRACTICE-
// Controller calls -> service
// Service calls -> repository
// Controller ---> Service ---> Repository

import com.learner.journalApp.entity.User;
import com.learner.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j      // Support with Lombok
public class UserService {

    @Autowired
    private UserRepository userRepository;            // Dependency injection

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveEntry(User user){
        try{
            userRepository.save(user);
        }catch (Exception e){
            log.error("Exception", e);
        }

    }

    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER"));
            userRepository.save(user);
            return true;
        }catch (Exception e){
            log.error("error accures in {} :",user.getUserName(), e);
            log.trace("jsgjdfsgdfs");
            log.info("sjfdgkl");
            log.debug("jgsgsj");
            return false;
        }
    }
    public void saveAdmin(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("ADMIN", "USER"));
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
