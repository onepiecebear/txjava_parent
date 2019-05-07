package cn.tx.service;

import cn.tx.domain.Order;
import cn.tx.service.impl.UserFelgnClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 *导入详情求的
 * 和order的接口做匹配
 */
@FeignClient(value="txjava-order",fallback = UserFelgnClientFallback.class)
public interface UserFelgnClient {

    /**
     * 查询用户下订单
     * path 为全路径包括controller路径
     * @param uid
     * @return
     */
    @RequestMapping(path = "/order/findAllByUid/{uid}",method = RequestMethod.GET)
    public List<Order> findAllByUid(@PathVariable("uid") Integer uid);
}
