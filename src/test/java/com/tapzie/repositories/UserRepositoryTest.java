package com.tapzie.repositories;

import com.tapzie.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100.00);
    private static final String user_email = "a cool user";
    private static final String IMAGE_URL = "http://an-username.com/image1.jpg";

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {

    }
}