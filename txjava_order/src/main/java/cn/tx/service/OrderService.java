package cn.tx.service;

import cn.tx.domain.Order;

import java.util.List;


public interface OrderService {

    public List<Order> findAll();

    public List<Order> findAllByUid(Integer uid) throws Exception;

}
