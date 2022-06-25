package com.example.demo.config;

import com.example.demo.service.BankStateMachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

@Configuration
public class StateMachineConfig {
    @Bean
    public UntypedStateMachineBuilder builder() {
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory.create(BankStateMachine.class);
        return builder;
    }
}
