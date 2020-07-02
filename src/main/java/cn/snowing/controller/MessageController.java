package cn.snowing.controller;

import cn.snowing.services.domian.MessageItem;
import cn.snowing.services.message.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageServices messageServices;

    /**
     * 模拟ajax请求和响应
     * SpringMVC会使用JackJson将json字符串解析并封装成User对象，同样的返回时，会自动的将返回对象转化为json字符串
     */
    @RequestMapping("/getUiMessageItemList")
    public @ResponseBody
    List<MessageItem> getUiMessageItemList(String username){
        System.out.println("getMessageSessionList" + "执行了.....");
        //客户端发送的是ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        return messageServices.getUiMessageItemList(username);
    }
}
