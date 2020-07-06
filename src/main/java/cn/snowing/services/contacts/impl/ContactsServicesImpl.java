package cn.snowing.services.contacts.impl;

import cn.snowing.dao.ContactsDao;
import cn.snowing.dao.MessageDao;
import cn.snowing.dao.UserDao;
import cn.snowing.domain.Contact;
import cn.snowing.domain.User;
import cn.snowing.services.contacts.ContactsServices;
import cn.snowing.services.contacts.domain.Friend;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactsServices")
public class ContactsServicesImpl implements ContactsServices {

    @Autowired
    private ContactsDao contactsDao;  //通过Spring注入ContactsDao对象

    @Autowired
    private UserDao userDao;  //通过Spring注入UserDao对象

    @Autowired
    private MessageDao messageDao; //通过Spring注入messageDao对象
    /**
     * 查询所有联系人列表
     * @return
     */
    @Override
    public List<Contact> findAll() {
        return contactsDao.findAll();
    }

    /**
     * 查询联系人列表，并查询联系人信息
     * @param username
     * @return
     */
    @Override
    public List<Friend> findFriendListByUsername(String username) {
        List<Friend> friendList = new ArrayList<Friend>();
        List<Contact> contactList = contactsDao.findContactsByUsername(username);
        for (Contact contact : contactList) {
            //查询朋友的信息
            User user = userDao.findUserByUsername(contact.getFUsername());
            Friend friend = new Friend();

            BeanUtils.copyProperties(contact, friend);
            BeanUtils.copyProperties(user, friend);

            //因为username在user和contact对象中都有，封装会出问题，因此主动赋值
            friend.setUsername(contact.getUsername());
            friendList.add(friend);
        }
        return friendList;
    }

    @Override
    public void deleteContact(String username, String fUsername) {
        //级联删除, 没有添加事务控制，可能会出错
        contactsDao.deleteContact(username, fUsername);
        messageDao.deleteMessage(username, fUsername);
        messageDao.deleteMessage(fUsername, username);
    }

    @Override
    public void addContact(Contact contact) {
        contactsDao.insertContact(contact);
    }
}
