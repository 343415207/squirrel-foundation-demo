package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

@Service
public class StateMachineServices {
    @Autowired
    FSMServiceImpl fsmService;

    public void fire() {
        BankStateMachine bankStateMachine = builder.newUntypedStateMachine("A");
        System.out.println("FSMEvent.ToB.toString() = " + FSMEvent.ToB.toString());
        bankStateMachine.fire("toB");
    }
}
