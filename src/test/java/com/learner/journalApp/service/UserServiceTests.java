package com.learner.journalApp.service;

import com.learner.journalApp.entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserService userService;

//    @Disabled
    @Test
    public void learning(){
        assertEquals(4, 2+2);
        assertTrue(5<6);
    }

//    @Disabled   // desable the test , this test will now run
    @ParameterizedTest
    @ValueSource(
            strings = {
                "MJ",
                "MS",
                "JK"
            }
    )
    public void testFindByUserName(String name){
        assertNotNull(userService.findByUserName(name));

     }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "3,9,12",
            "3,3,9"
        }
    )
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}
