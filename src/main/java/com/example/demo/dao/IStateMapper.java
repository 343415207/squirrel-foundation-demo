package com.example.demo.dao;

import com.example.demo.entity.Node;

import java.util.List;

public interface IStateMapper {

     List<Node> selectNodeByVersion(int version);
     List<Node> selectAllConfig();
}
