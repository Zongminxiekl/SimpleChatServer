package cn.snowing.services.contacts;

import cn.snowing.domain.Contact;
import cn.snowing.services.contacts.domain.Friend;

import java.util.List;

public interface ContactsServices {
    /**
     * 测试查询所有
     */
    public List<Contact> findAll();


    /**
     * 通过用户名查找用户联系人列表，再查询联系人信息封装到Friend的List里面
     * @return
     */
    public List<Friend> findFriendListByUsername(String username);

    /**
     * 删除联系人
     * @param f_username
     */
    public void deleteContact(String username, String f_username);
}
