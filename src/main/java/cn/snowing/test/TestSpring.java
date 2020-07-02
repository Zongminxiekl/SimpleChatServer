package cn.snowing.test;

import cn.snowing.domain.Contact;
import cn.snowing.domain.Message;
import cn.snowing.services.contacts.ContactsServices;
import cn.snowing.services.contacts.domain.Friend;
import cn.snowing.services.message.MessageServices;
import cn.snowing.services.message.domian.MessageSession;
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
    public void run1(){
        // 获取对象
        MessageServices ms = (MessageServices) ac.getBean("messageServices");
        List<Message> messageByUsername = ms.findMessageByUsername("123456");
        for (Message message : messageByUsername) {
            System.out.println(message);
        }
        List<MessageSession> messageSessionList = ms.getMessageSessionList("123456");
        int i = 0;
        for (MessageSession messageSession : messageSessionList) {
            System.out.println(++i);
            System.out.println(messageSession.getMessageSession());
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
}
