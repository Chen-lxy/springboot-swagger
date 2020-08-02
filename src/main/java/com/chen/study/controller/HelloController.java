package com.chen.study.controller;

import com.chen.study.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/user")
    public User user(){
        return new User();
    }
}
