package cn.snowing.test;

import cn.snowing.dao.ContactsDao;
import cn.snowing.dao.MessageDao;
import cn.snowing.dao.UserDao;
import cn.snowing.domain.Contact;
import cn.snowing.domain.Message;
import cn.snowing.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * 测试Dao
 */
public class MybatisTest {
    // 加载配置文件
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    @Test
    public void testFindFUsernameByUsername(){
        MessageDao messageDao = ac.getBean("messageDao", MessageDao.class);
        String username = "123456";
        List<String> friendUsernameList = messageDao.findFUsernameByUsername(username);
        for (String s : friendUsernameList) {
            System.out.println(s);
        }
        int i = 0;
        for (String friendUsername : friendUsernameList) {
            System.out.println("第" + (++i) + "个消息会话");
            List<Message> messageSession = messageDao.findMessageByfUsernameAndUsername(username, friendUsername);
        }
    }

    @Test
    public void testMessageByfUsernameAndUsername(){
        MessageDao messageDao = ac.getBean("messageDao", MessageDao.class);
        List<Message> messageByfUsernameAndUsername = messageDao.findMessageByfUsernameAndUsername("123456", "123459");
        for (Message message : messageByfUsernameAndUsername) {
            System.out.println(message);
        }
    }

    @Test
    public void testFindContactsByUsername(){
        ContactsDao contactsDao = ac.getBean("contactsDao", ContactsDao.class);
//        List<Contact> contactList = contactsDao.findAll();
//        for (Contact contact : contactList) {
//            System.out.println(contact);
//        }

        List<Contact> contactList = contactsDao.findContactsByUsername("123456");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    @Test
    public void testFindUserByUsernameAndPassword(){
        User user=new User();
        user.setUsername("123457");
        user.setPassword("123458");
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User user1 = userDao.findUserByUsernameAndPassword(user);
        System.out.println(user1);
    }

    @Test
    public void testSaveMessage(){
        Message msg = new Message();
        msg.setUsername("123456");
        msg.setfUsername("123457");
        msg.setMessageContent("老猪，吃我一棒！");
        msg.setMessageDate(new Date());
        MessageDao messageDao = ac.getBean("messageDao", MessageDao.class);
        messageDao.saveMsg(msg);
    }

    @Test
    public void testDeleteContact(){
        ContactsDao contactsDao = ac.getBean("contactsDao", ContactsDao.class);
        contactsDao.deleteContact("123456", "123457");
    }
}
