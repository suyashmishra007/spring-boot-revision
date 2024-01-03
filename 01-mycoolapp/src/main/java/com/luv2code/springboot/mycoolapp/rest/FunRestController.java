package com.luv2code.springboot.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello World !!";
    }
}