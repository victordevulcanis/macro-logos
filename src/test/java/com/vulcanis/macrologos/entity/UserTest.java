package com.vulcanis.macrologos.entity;

import com.vulcanis.macrologos.domain.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    public void shouldCalculateUserAge(){

        user.setBirthDate(LocalDate.of(1990, 1, 1));

        LocalDate fixedDate = LocalDate.of(2026, 1, 26);

        Assertions.assertEquals(36, user.getAge(fixedDate));
    }

}