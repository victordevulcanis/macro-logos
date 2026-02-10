package com.vulcanis.macrologos.domain.dto;

import com.vulcanis.macrologos.domain.enums.ActivityLevel;
import com.vulcanis.macrologos.domain.enums.BiologicalSex;

import java.time.LocalDate;

public record BmrRequest(
        double weight,
        double height,
        LocalDate birthDate,
        BiologicalSex biologicalSex,
        ActivityLevel activityLevel
) {}
