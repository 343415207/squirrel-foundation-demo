package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CallBackService {
    public void execute(String from, String to, String event, HashMap context) {
        System.out.println("CallBackService execute ");
    }
}
