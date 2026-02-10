package com.vulcanis.macrologos.service;

import com.vulcanis.macrologos.domain.entity.User;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;

@Service
public class BmrCalculatorService {

    private final Clock clock;

    public BmrCalculatorService(Clock clock) {
        this.clock = clock;
    }

    public double calculateBmr(User user) {
        // Mifflin-St Jeor Equation
        // Basal Metabolic Rate = (10 * weight in kg) + (6.25 * height in cm) - (5 * age in years) + gender adjustment
        LocalDate today = LocalDate.now(clock);
        Integer age = user.getAge(today);
        return (10 * user.getWeight()) + (6.25 * user.getHeight()) - (5 * age) + user.getBiologicalSex().getBasalAdjustment();
    }

    public double calculateTdee(User user) {
        // Total Daily Energy Expenditure = BMR * Activity Level Multiplier
        return calculateBmr(user) * user.getActivityLevel().getActivityMultiplier();
    }

}
