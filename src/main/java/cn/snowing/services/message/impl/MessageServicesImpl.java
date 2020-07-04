package cn.snowing.services.message.impl;

import cn.snowing.dao.MessageDao;
import cn.snowing.dao.UserDao;
import cn.snowing.domain.Message;
import cn.snowing.domain.User;
import cn.snowing.services.message.MessageServices;
import cn.snowing.services.message.domian.MessageItem;
import org.springframework.beans.factory.annotation.Autowired;
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
            messageItem.setHead(friend.getHead());
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

    @Override
    public void saveMsg(Message msg) {
        messageDao.saveMsg(msg);
    }

    @Override
    public List<Message> findMessageListByfUsernameAndUsername(String username, String fUsername) {
        //我与联系人的消息记录
        List<Message> msgList=new ArrayList<Message>();

        //获取我发送的消息记录
        List<Message>  msgs1=messageDao.findMessageByfUsernameAndUsername(username,fUsername);
        //获取联系人发送的消息记录
        List<Message>  msgs2=messageDao.findMessageByfUsernameAndUsername(fUsername,username);

        //type=1表示我发送的消息
        for (Message msg : msgs1) {
            msg.setType(1);
            msgList.add(msg);
        }

        //type=0表示联系人发送的消息
        for (Message msg : msgs2) {
            msg.setType(0);
            msgList.add(msg);
        }

        //合并我和联系人的消息记录后，根据发送时间排序
        Collections.sort(msgList, new Comparator<Message>() {

            public int compare(Message item1, Message item2) {

                Long value1 = item1.getMessageDate().getTime();
                Long value2 = item2.getMessageDate().getTime();
                return value1.compareTo(value2);
            }
        });

        return  msgList;
    }
}
