package cn.tx.mapper;

import cn.tx.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface OrderMapper {

    @Select("select * from t_order")
    public List<Order> findAll();

    @Select("select * from t_order where uid = #{uid}")
    public List<Order> findAllByUid(Integer uid);

}
