package cn.snowing.services.message.impl;

import cn.snowing.dao.MessageDao;
import cn.snowing.dao.UserDao;
import cn.snowing.domain.Message;
import cn.snowing.domain.User;
import cn.snowing.services.domian.MessageItem;
import cn.snowing.services.message.MessageServices;
import cn.snowing.services.message.domian.MessageSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 账户业务层实现类
 */
@Service("messageServices")
public class MessageServicesImpl implements MessageServices {
    @Autowired
    private MessageDao messageDao;  //通过Spring注入UserDao对象

    @Autowired
    private UserDao userDao;  //通过Spring注入UserDao对象

    public List<Message> findAll() {
        System.out.println("msgServicesFindAll执行了");
        return messageDao.findAll();
    }

    public List<Message> findMessageByUsername(String username) {
        return messageDao.findMessageByUsername(username);
    }

    @Override
    public List<MessageSession> getMessageSessionList(String username) {
        List<MessageSession> messageSessionList = new ArrayList<MessageSession>();
        List<String> friendUsernameList = messageDao.findFUsernameByUsername(username);
        for (String friendUsername : friendUsernameList) {
            MessageSession messageSession = new MessageSession();
            messageSession.setMessageSession( messageDao.findMessageByfUsernameAndUsername(username, friendUsername));
            messageSessionList.add(messageSession);
        } 
        return messageSessionList;
    }

    @Override
    public List<MessageItem> getUiMessageItemList(String username) {
        //要返回的消息列表对象
        List<MessageItem> messageItemList = new ArrayList<MessageItem>();

        //消息列表的朋友的用户名
        List<String> friendUsernameList = messageDao.findFUsernameByUsername(username);

        //通过朋友的用户名查询其相关信息
        for (String friendUsername : friendUsernameList) {
            MessageItem messageItem = new MessageItem();
            //通过用户名查询朋友的用户信息
            User friend = userDao.findUserByUsername(friendUsername);
            //通过用户名查询我和朋友的聊天消息列表
            List<Message> friendMessageList = messageDao.findMessageByfUsernameAndUsername(username, friendUsername);
            //得到最新的一条消息
            Message message = friendMessageList.get(0);

            //用户信息相关
            messageItem.setNickname(friend.getNickname());
            messageItem.setFUsername(friend.getUsername());
            messageItem.setImgSrc(friend.getHead());
            messageItem.setUsername(username);

            //消息相关
            messageItem.setLastMsg(message.getMessageContent());
            messageItem.setLastMsgDate(message.getMessageDate());

            messageItemList.add(messageItem);
        }

        Collections.sort(messageItemList, new Comparator<MessageItem>() {

            public int compare(MessageItem item1, MessageItem item2) {

                Long value1 = item1.getLastMsgDate().getTime();
                Long value2 = item2.getLastMsgDate().getTime();

                // 按照学生的年龄进行降序排列
                return value2.compareTo(value1);
            }
        });
        return messageItemList;
    }
}
