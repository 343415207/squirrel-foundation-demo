package com.example.demo.service;

import com.example.demo.dao.IStateMapper;
import com.example.demo.entity.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

public class FSMServiceImpl implements FSMService {

    @Autowired
    IStateMapper iStateMapper;

    private HashMap<Integer, UntypedStateMachineBuilder> proxy = new HashMap<>();

    @PostConstruct
    public void init() {
        List<Node> nodeList = iStateMapper.selectAllConfig();
        for (Node node : nodeList) {
            UntypedStateMachineBuilder builder = proxy.get(node.getVersion());
            if (builder == null) {
                builder = StateMachineBuilderFactory.create(BankStateMachine.class);
            }
            builder.externalTransition().from(node.getFrom()).to(node.getTo()).on(FSMEvent.ToA);
            proxy.put(node.getVersion(), builder);
        }
    }

    public BankStateMachine newFSM(int version, int current) {
        return proxy.get(version).newUntypedStateMachine(current);
    }
}
