package cn.tx.domain;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable {

    // 主键
    private Integer id;
    // 登录名
    private String loginname;
    // 密码
    private String password;
    // 昵称
    private String nickname;

    // 表示一个用户拥有多个订单
    private List<Order> orders;
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
