package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    // step 2 : define @Bean method to configure the bean.
    @Bean("aquatic")
    public Coach swimCoach(){ // the bean id defaults to the method name.
        return new SwimCoach();
    }






}
