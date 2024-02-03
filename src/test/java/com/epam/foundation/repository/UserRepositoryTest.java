package com.epam.foundation.repository;

import com.epam.foundation.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void whenCalledSaveUserThenCorrectNumberOfUsers() {
        // given
        User user = new User("John Doe", "johndoe@email.com");
        // when
        userRepository.save(user);
        List<User> allUSer = userRepository.findAll();

        // then
        Assertions.assertEquals(1, allUSer.size());
        Assertions.assertEquals("John Doe", allUSer.get(0).getName());
    }
}
