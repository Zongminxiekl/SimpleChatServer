package cn.snowing.services.message;

import cn.snowing.domain.Message;
import cn.snowing.services.message.domian.MessageItem;

import java.util.List;

public interface MessageServices {

    /**
     * 查询所有
     * @return
     */
    public List<Message> findAll();

    /**
     * 通过用户名查找消息记录
     * @param username
     * @return
     */
    public List<Message> findMessageByUsername(String username);
    /**
     * 导航页面处的消息列表
     * @param username
     * @return
     */
    public List<MessageItem> getUiMessageItemList(String username);

    /**
     * 保存消息到Message表
     * @param msg
     */
    public  void saveMsg(Message msg);

    /**
     * 查找用户和某一联系人的消息记录
     * @param username  用户
     * @param fUsername 联系人
     * @return 消息记录
     */
    public List<Message> findMessageListByfUsernameAndUsername(String username, String fUsername);
}
