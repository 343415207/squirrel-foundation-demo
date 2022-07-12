package com.example.demo.dao;

import com.example.demo.entity.Order;

public interface IOrderMapper {
    Order selectById(Integer id);
}
