package cn.tx.service.impl;

import cn.tx.domain.Order;
import cn.tx.service.UserFelgnClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFelgnClientFallback implements UserFelgnClient {
    @Override
    public List<Order> findAllByUid(Integer uid) {
        System.out.println("错误");
        Order order =  new Order();
        order.setNum("错误");
        List<Order> list =  new ArrayList<Order>();
        list.add(order);
        return list;
    }
}
