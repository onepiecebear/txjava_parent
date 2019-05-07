package cn.tx.service.impl;

import cn.tx.domain.User;
import cn.tx.mapper.UserMapper;
import cn.tx.service.UserFelgnClient;
import cn.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    // 使用模板
    @Autowired
    private RestTemplate restTemplate;

    // 使用模板
    @Autowired
    private UserFelgnClient userFelgnClient;

    // 定义远程访问的地址
    private static String url = "http://TXJAVA-ORDER";

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 查询该用户所有的订单
     * @param id
     * @return
     */
    @Override
    public User findUserOrders(Integer id) {
        // 查询用户的信息
        User user = userMapper.findById(id);


        // 1、采用ribbon请求       1、
        // 远程调用订单微服务中的方法，获取到数据，整体返回
//        System.out.println("采用ribbon请求");
       // List list = restTemplate.getForObject(url + "/order/findAllByUid/"+id, List.class);


        // 2、采用feign请求       1、
        // 远程调用订单微服务中的方法，获取到数据，整体返回
        System.out.println("采用feign请求");
        List list = userFelgnClient.findAllByUid(id);



        // 设置给用户
        user.setOrders(list);

        return user;
    }

}
