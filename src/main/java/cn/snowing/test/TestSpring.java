package cn.snowing.test;

import cn.snowing.domain.Contact;
import cn.snowing.domain.Message;
import cn.snowing.domain.User;
import cn.snowing.services.contacts.ContactsServices;
import cn.snowing.services.contacts.domain.Friend;
import cn.snowing.services.message.MessageServices;
import cn.snowing.services.message.domian.MessageItem;
import cn.snowing.services.user.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试Services层
 */
public class TestSpring {
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    @Test
    public void testLogin(){
        UserServices userServices = ac.getBean("userServices", UserServices.class);
        User user=new User();
        user.setUsername("123456");
        user.setPassword("123456");
        User loginUser = userServices.login(user);
        System.out.println(loginUser);
    }

    @Test
    public void testRegister(){
        UserServices userServices = ac.getBean("userServices", UserServices.class);
        User register = new User();
        register.setNickname("register");
        register.setUsername("register");
        register.setPassword("123456");
        User registerUser = userServices.register(register);
        System.out.println(registerUser);
    }

    @Test
    public void testSearchUser(){
        UserServices userServices = ac.getBean("userServices", UserServices.class);
        List<User> userList = userServices.searchUser("123457");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetUiMessageItemList(){
        MessageServices ms = (MessageServices) ac.getBean("messageServices");
        List<MessageItem> uiMessageItemList = ms.getUiMessageItemList("123456");
        for (MessageItem messageItem : uiMessageItemList) {
            System.out.println(messageItem);
        }
    }

    @Test
    public void testFindMessageListByfUsernameAndUsername(){
        MessageServices messageServices = ac.getBean("messageServices", MessageServices.class);
        List<Message> messageList = messageServices.findMessageListByfUsernameAndUsername("123456", "123457");
        for (Message message : messageList) {
            System.out.println(message);
        }
    }

    @Test
    public void run1(){
        // 获取对象
        MessageServices ms = (MessageServices) ac.getBean("messageServices");
        List<Message> messageByUsername = ms.findMessageByUsername("123456");
        for (Message message : messageByUsername) {
            System.out.println(message);
        }

    }

    @Test
    public void testContactsFindAll(){
        ContactsServices contactsServices = ac.getBean("contactsServices", ContactsServices.class);
        List<Contact> contactList = contactsServices.findAll();
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }
    @Test
    public void testFindFriendListByUsername(){
        ContactsServices contactsServices = ac.getBean("contactsServices", ContactsServices.class);
        List<Friend> friendList = contactsServices.findFriendListByUsername("123456");
        int i = 1;
        for (Friend friend : friendList) {
            System.out.println("第" + (i++) + "个朋友");
            System.out.println(friend);
        }
    }





    @Test
    public void testDeleteContact(){
        ContactsServices contactsServices = ac.getBean("contactsServices", ContactsServices.class);
        contactsServices.deleteContact("123456", "123459");
    }
}
