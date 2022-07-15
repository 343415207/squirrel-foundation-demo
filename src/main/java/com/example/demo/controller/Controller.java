package com.example.demo.controller;

import com.example.demo.service.FSMService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class Controller {

    @Resource
    FSMService fsmService;

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
        // TOOD order_id ==> current version, status
        fsmService.newFSM(1, 1).fire("pay", 100);
    }
}
