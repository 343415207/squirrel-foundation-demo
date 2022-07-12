package com.example.demo.service;

import com.example.demo.dao.IStateMapper;
import com.example.demo.entity.Node;
import org.springframework.stereotype.Component;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Component
public class FSMServiceImpl implements FSMService {

    @Resource
    IStateMapper iStateMapper;
    // version ==> builder
    private HashMap<Integer, UntypedStateMachineBuilder> proxy = new HashMap<>();

    @PostConstruct
    public void init() {
        List<Node> nodeList = iStateMapper.selectAllConfig();
        for (Node node : nodeList) {
            UntypedStateMachineBuilder builder = proxy.get(node.getVersion());
            if (builder == null) {
                builder = StateMachineBuilderFactory.create(BankStateMachine.class);
            }
            builder.externalTransition().from(node.getFrom()).to(node.getTo()).on(FSMEvent.ToA).callMethod("fromTo");
            proxy.put(node.getVersion(), builder);
        }
    }

    public BankStateMachine newFSM(int version, int current) {
        return proxy.get(version).newUntypedStateMachine(current);
    }
}
