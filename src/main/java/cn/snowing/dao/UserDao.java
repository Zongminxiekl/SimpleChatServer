package cn.snowing.dao;

import cn.snowing.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
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
     * 仅通过用户名，应当只能查询到公开的信息
     * @param username
     * @return
     */
    @Select("select * from user where username=#{username}")
    public User findUserByUsername(String username);

    /**
     * 通过用户名和密码联系查询，结果是一条user记录的完整信息
     * @return
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    public User findUserByUsernameAndPassword(User user);

    /**
     * 专门用于注册功能的保存用户的方法
     * @param register
     * @return
     */
    @Insert("insert into user(nickname, username, password) values(#{nickname}, #{username}, #{password})")
    @Options(useGeneratedKeys=true, keyColumn="uid", keyProperty = "uid")
    public Integer saveRegisterUser(User register);
}
