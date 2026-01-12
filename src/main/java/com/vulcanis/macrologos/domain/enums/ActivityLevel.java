package com.vulcanis.macrologos.domain.enums;

public enum ActivityLevel {

    //Little or no exercise
    SEDENTARY(1.2),
    //Light exercise 1-3 days/week
    LIGHTLY_ACTIVE(1.375),
    //Moderate exercise 3-5 days/week
    MODERATELY_ACTIVE(1.55),
    //Heavy exercise 6-7 days/week
    VERY_ACTIVE(1.725),
    //Very hard exercise, physical job or training
    EXTRA_ACTIVE(1.9);

    private final double activityMultiplier;

    ActivityLevel(double activityMultiplier){
        this.activityMultiplier = activityMultiplier;
    }

    public double getActivityMultiplier(){
        return activityMultiplier;
    }

}