package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements  Coach{
    public BaseballCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName() );
    }
    @Override
    public String getDailyWorkout() {
        return "Practice hitting for 30mins in batting practice.";
    }


}
