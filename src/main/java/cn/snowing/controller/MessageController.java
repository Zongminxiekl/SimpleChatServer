package cn.snowing.controller;

import cn.snowing.domain.Contact;
import cn.snowing.domain.Message;
import cn.snowing.services.message.MessageServices;
import cn.snowing.services.message.domian.MessageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageServices messageServices;


    /**
     * 获取用户消息列表api
     * @param username 用户名
     * @return
     */
    @RequestMapping("/getUiMessageItemList")
    public @ResponseBody
    List<MessageItem> getUiMessageItemList(String username){
        System.out.println("getMessageSessionList" + "执行了.....");
        //客户端发送的是ajax请求，传的是json字符串，后端把json字符串封装到user对象中
        return messageServices.getUiMessageItemList(username);
    }

    /**
     * 保存消息api
     * @param msg
     */
    @RequestMapping("/saveMsg")
    public void saveMsg(@RequestBody Message msg) {
        //System.out.println("saveMsg:" + msg);
        messageServices.saveMsg(msg);

    }

    /**
     * 获取与某一联系人消息记录api
     * @param contact 联系人信息
     * @return
     */
    @RequestMapping("/selectMsg")
    public @ResponseBody List<Message> findMessageByfUsernameAndUsername(@RequestBody Contact contact) {
        return messageServices.findMessageListByfUsernameAndUsername(contact.getUsername(), contact.getFUsername());
    }
}
