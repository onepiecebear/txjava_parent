package cn.tx.controller;

import cn.tx.domain.Order;
import cn.tx.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(path = "/findAll",method = RequestMethod.GET)
    public List<Order> findAll(){
        return orderService.findAll();
    }

    /**
     * 查询用户下订单
     * @param uid
     * @return
     */
    @RequestMapping(path = "/findAllByUid/{uid}",method = RequestMethod.GET)
    public List<Order> findAllByUid(@PathVariable("uid") Integer uid) {
        System.out.println("订单微服务...");
        try {
            return orderService.findAllByUid(uid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
