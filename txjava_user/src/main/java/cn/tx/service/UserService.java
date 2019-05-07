package cn.tx.service;

import cn.tx.domain.User;

import java.util.List;


public interface UserService {

    public List<User> findAll();

    User findUserOrders(Integer id);

}
