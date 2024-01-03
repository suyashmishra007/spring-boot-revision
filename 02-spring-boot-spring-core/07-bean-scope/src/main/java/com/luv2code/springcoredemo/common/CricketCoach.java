package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// default bean scope is singleton
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName() );
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins.";
    }
}
