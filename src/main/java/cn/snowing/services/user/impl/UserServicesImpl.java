package cn.snowing.services.user.impl;

import cn.snowing.dao.UserDao;
import cn.snowing.domain.User;
import cn.snowing.msg.ErrorMsg;
import cn.snowing.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("userServices")
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) {
        User loginUser = userDao.findUserByUsernameAndPassword(user);

        //在查询不到时loginUser是null，会产生空指针异常，因此放入try catch, 使程序不至于终止
        try {
            //去除loginUser对象中的密码信息
            loginUser.setPassword("******");
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return loginUser;
    }

    @Override
    public User register(User register) {
        try {
            Integer row = 0;
            row = userDao.saveRegisterUser(register);
            if (row == 1){
                return register;
            } else {
                return null;
            }

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> searchUser(String username) {
        User user = userDao.findUserByUsername(username);
        user.setPassword("******");
        return new ArrayList<User>(Collections.singletonList(user));
    }
}
