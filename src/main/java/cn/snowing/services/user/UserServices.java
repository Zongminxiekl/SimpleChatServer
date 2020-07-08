package cn.snowing.services.user;

import cn.snowing.domain.User;
import cn.snowing.msg.ErrorMsg;

import java.util.List;

public interface UserServices {
    /**
     * 登录
     * @param user  只包含用户名和密码的User对象
     * @return 包含用户所有信息
     */
    public User login(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    public User register(User user);

    /**
     * 查找用户
     * @param username
     * @return
     */
    List<User> searchUser(String username);
}
