package com.example.demo.entity;

import lombok.Data;

@Data
public class Node {
    private int from;
    private int to;
    private int version;
}
