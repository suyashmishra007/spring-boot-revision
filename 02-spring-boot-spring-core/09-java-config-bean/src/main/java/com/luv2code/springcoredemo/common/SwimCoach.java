package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Bean;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In Constructor : "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000m as a warm up.";
    }
}
