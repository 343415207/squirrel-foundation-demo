package com.example.demo.service;

import com.google.common.base.Preconditions;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.squirrelframework.foundation.component.SquirrelPostProcessor;
import org.squirrelframework.foundation.component.SquirrelPostProcessorProvider;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;

@Component
public class StateMachineAutowireProcessor implements SquirrelPostProcessor<UntypedStateMachine>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public StateMachineAutowireProcessor() {
        // register StateMachineAutowireProcessor as state machine post processor
        SquirrelPostProcessorProvider.getInstance().register(BankStateMachine.class, this);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void postProcess(UntypedStateMachine untypedStateMachine) {
        Preconditions.checkNotNull(untypedStateMachine);
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(untypedStateMachine);
        System.out.println("auto wire BankStateMachine ");
    }
}