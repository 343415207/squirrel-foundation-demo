package com.example.demo.service;

public interface FSMService {

    BankStateMachine newFSM(int version, int current);

}
