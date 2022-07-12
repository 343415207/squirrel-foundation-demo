package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.annotation.Transit;
import org.squirrelframework.foundation.fsm.annotation.Transitions;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

import java.util.HashMap;

@Transitions({
        @Transit(from = "A", to = "B", on = "toB", callMethod = "fromTo"),
        @Transit(from = "B", to = "C", on = "toC", callMethod = "fromTo"),
        @Transit(from = "C", to = "D", on = "toD", callMethod = "fromTo")
})
@StateMachineParameters(stateType = String.class, eventType = String.class, contextType = HashMap.class)
public class BankStateMachine extends AbstractUntypedStateMachine {

    @Autowired
    private CallBackService callBackService;


    protected void fromTo(String from, String to, String event, HashMap context) {
        System.out.println("Transition from '" + from + "' to '" + to + "' on event '" + event +
                "' with context '" + context + "'.");
        callBackService.execute(from, to, event, context);
    }

    protected void ontoB(String from, String to, String event, HashMap context) {
        System.out.println("Entry State \'" + to + "\'.");
    }
}
