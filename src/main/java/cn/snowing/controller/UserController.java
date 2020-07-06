package cn.snowing.controller;

import cn.snowing.domain.User;
import cn.snowing.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    /**
     * 用户登录方法接口，传过来的应当是包含用户名和密码的User对象序列化的Json字符串
     * 方便浏览器测试，暂时不使用Json提交数据，要使用Json只需要User参数前加上注解@RequestBody
     * @param user
     * @return 返回的是一个loginUser， 包含用户的所有信息
     */
    @RequestMapping("/login")
    public @ResponseBody User login(@RequestBody User user){
        return userServices.login(user);
    }

    /**
     * 用户注册api接口，传过来的应当是包含nickname, username和password的User对象序列化的Json字符串
     * @return
     */
    @RequestMapping("/register")
    public @ResponseBody
    User register(@RequestBody User user){
        return userServices.register(user);
    }

    @RequestMapping("/searchUser")
    public @ResponseBody List<User> searchUser(String username){
        return userServices.searchUser(username);
    }

}
