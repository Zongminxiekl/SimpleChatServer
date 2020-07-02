package cn.snowing.dao;

import cn.snowing.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户Dao接口
 */
@Repository
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    /**通过用户名查找用户，结果唯一
     *
     * @param username
     * @return
     */
    @Select("select * from user where username=#{username}")
    public User findUserByUsername(String username);
}
