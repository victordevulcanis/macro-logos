package com.vulcanis.macrologos.service;

import com.vulcanis.macrologos.domain.entity.User;
import com.vulcanis.macrologos.domain.enums.BiologicalSex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@ExtendWith(MockitoExtension.class)
public class BmrCalculatorServiceTest {

    private BmrCalculatorService bmrCalculatorService;
    private User user;

    @Mock
    private Clock clock;

    @BeforeEach
    void setUp() {
        user = new User();
        bmrCalculatorService = new BmrCalculatorService(clock);

        LocalDate fixedDate = LocalDate.of(2026, 1, 26);
        ZoneId zoneId = ZoneId.systemDefault();
        Instant fixedInstant = fixedDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

        Mockito.when(clock.instant()).thenReturn(fixedInstant);
        Mockito.when(clock.getZone()).thenReturn(zoneId);
    }

    @Test
    void shouldCalculateMasculineBMR() {
        user.setBirthDate(LocalDate.of(1990, 1, 1));
        user.setHeight(180.0);
        user.setWeight(70.0);
        user.setBiologicalSex(BiologicalSex.MALE);
        Double bmrUserMasculine = bmrCalculatorService.calculateBmr(user);

        Assertions.assertEquals(1650, bmrUserMasculine);
    }

    @Test
    void shouldCalculateFeminineBMR() {
        user.setBirthDate(LocalDate.of(1990, 1, 1));
        user.setHeight(180.0);
        user.setWeight(70.0);
        user.setBiologicalSex(BiologicalSex.FEMALE);
        Double bmrUserFeminine = bmrCalculatorService.calculateBmr(user);

        Assertions.assertEquals(1484, bmrUserFeminine);

        bmrCalculatorService.calculateBmr(user);
    }

}