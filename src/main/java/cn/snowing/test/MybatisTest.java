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
    public void testUserFindAll(){
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testUseByUsername(){
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User user = userDao.findUserByUsername("123456");
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsernameAndPassword(){
        User user=new User();
        user.setUsername("123456");
        user.setPassword("123456");
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User user1 = userDao.findUserByUsernameAndPassword(user);
        System.out.println(user1);
    }



    @Test
    public void testRegister(){
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        User register = new User();
        register.setNickname("testRegister");
        register.setUsername("testRegister");
        register.setPassword("123456");
        Integer row = 0;
        try {
            row = userDao.saveRegisterUser(register);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(row);
    }




    @Test
    public void testMessageFindAll(){
        MessageDao messageDao = ac.getBean("messageDao", MessageDao.class);
        List<Message> messageList = messageDao.findAll();
        for (Message message : messageList) {
            System.out.println(message);
        }
    }

    @Test
    public void testFindMessageByUsername(){
        MessageDao messageDao = ac.getBean("messageDao", MessageDao.class);
        List<Message> message = messageDao.findMessageByUsername("123456");
        for (Message message1 : message) {
            System.out.println(message1);
        }
    }

    @Test
    public void testFindMessageByfUsernameAndUsername(){
        MessageDao messageDao = ac.getBean("messageDao", MessageDao.class);
        List<Message> messageList = messageDao.findMessageByfUsernameAndUsername("123456", "123457");
        for (Message message : messageList) {
            System.out.println(message);
        }
    }

    @Test
    public void testSaveMsg(){
        MessageDao messageDao = ac.getBean("messageDao", MessageDao.class);
        Message message = new Message();
        message.setUsername("123457");
        message.setFUsername("123456");
        message.setMessageContent("哈哈");
        message.setMessageDate(new Date());
        Integer integer = messageDao.saveMsg(message);
        System.out.println(integer);
    }

    @Test
    public void testDeleteMessage(){
        MessageDao messageDao = ac.getBean("messageDao", MessageDao.class);
        Integer integer = messageDao.deleteMessage("123457", "123456");
        System.out.println(integer);
    }

    @Test
    public void testFindContactsAll(){
        ContactsDao contactsDao = ac.getBean("contactsDao", ContactsDao.class);
        List<Contact> contactList = contactsDao.findAll();
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    @Test
    public void testFindContactsByUsername(){
        ContactsDao contactsDao = ac.getBean("contactsDao", ContactsDao.class);
        List<Contact> contactList = contactsDao.findContactsByUsername("123456");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }


    @Test
    public void testDeleteContact(){
        ContactsDao contactsDao = ac.getBean("contactsDao", ContactsDao.class);
        contactsDao.deleteContact("123456", "123457");
    }

    @Test
    public void testInsertContact(){
        ContactsDao contactsDao = ac.getBean("contactsDao", ContactsDao.class);
        Contact contact = new Contact();
        contact.setUsername("123456");
        contact.setFUsername("123457");
        contact.setRemark("八戒");
        Integer integer = contactsDao.insertContact(contact);
        System.out.println(integer);
    }

}
