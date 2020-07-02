package cn.snowing.controller;

import cn.snowing.domain.User;
import cn.snowing.services.message.MessageServices;
import cn.snowing.services.message.domian.MessageSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MessageServices messageServices;
    /**
     * 模拟ajax请求和响应
     * SpringMVC会使用JackJson将json字符串解析并封装成User对象，同样的返回时，会自动的将返回对象转化为json字符串
     */
    @RequestMapping("/testAjax")
    public @ResponseBody List<User> testAjax(){
        System.out.println("testAjax" + "执行了.....");
        //客户端发送的是ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setNickname("孙猴子"+i);
            user.setUsername("123456"+i);
            users.add(user);
        }
        return users;
    }

    /**
     * 模拟ajax请求和响应
     * SpringMVC会使用JackJson将json字符串解析并封装成User对象，同样的返回时，会自动的将返回对象转化为json字符串
     */
    @RequestMapping("/getMessageSessionList")
    public @ResponseBody List<MessageSession> getMessageSessionList(String username){
        System.out.println("getMessageSessionList" + "执行了.....");
        //客户端发送的是ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        return messageServices.getMessageSessionList(username);
    }
}
