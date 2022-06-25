package com.example.demo.controller;

import com.example.demo.service.StateMachineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private StateMachineServices stateMachineServices;

    @PostMapping(value = "post")
    public String post(@RequestBody PostBody req, @RequestParam String car) throws Exception {
        return "success: " + car + req.getName();
    }

    @PostMapping(value = "post_form")
    public String post(PostBody req) throws Exception {
        return "success: " + req.getName() + req.getAge();
    }

    @GetMapping(value = "fire")
    public void fire() throws Exception {
        stateMachineServices.fire();
    }
}
