package com.learner.journalApp.service;

import com.learner.journalApp.entity.User;
import com.learner.journalApp.repository.UserRepository;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserDetailsServiceImplTests {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

//    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName("MJ")).thenReturn(User.builder().setUserName("MJ").build());
//        User user = (User) userDetailsService.loadUserByUsername("MJ");
//    }
}
