package cn.snowing.test;

import cn.snowing.dao.ContactsDao;
import cn.snowing.dao.MessageDao;
import cn.snowing.domain.Contact;
import cn.snowing.domain.Message;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
