package cn.tx.mapper;

import cn.tx.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("select * from t_user")
    public List<User> findAll();

    @Select("select * from t_user where id = #{id}")
    User findById(Integer id);
}
