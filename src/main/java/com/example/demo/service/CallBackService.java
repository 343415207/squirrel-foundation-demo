package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CallBackService {
    public void execute(String from, String to, String event, Integer context) {
        System.out.println("CallBackService execute ");
    }
}
