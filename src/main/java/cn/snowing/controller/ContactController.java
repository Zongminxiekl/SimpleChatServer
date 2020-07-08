package cn.snowing.controller;

import cn.snowing.domain.Contact;
import cn.snowing.msg.ReturnMsg;
import cn.snowing.msg.SuccessMsg;
import cn.snowing.services.contacts.ContactsServices;
import cn.snowing.services.contacts.domain.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactsServices contactsServices;

    /**
     * 获取用户的联系人列表api
     * @param username 用户名
     * @return 用户的联系人列表
     */
    @RequestMapping("/getFriendList")
    public @ResponseBody
    List<Friend> getFriendList(String username){
        return contactsServices.findFriendListByUsername(username);
    }

    /**
     * 删除联系人api
     * @param contact 联系人对象
     */
    @RequestMapping("/deleteContact")
    public void deleteContact(@RequestBody Contact contact ) {
        try {
            contactsServices.deleteContact(contact.getUsername(), contact.getFUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/addContact")
    public @ResponseBody
    ReturnMsg addContact(@RequestBody Contact contact ) {
        try {
            contactsServices.addContact(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SuccessMsg();
    }
}
