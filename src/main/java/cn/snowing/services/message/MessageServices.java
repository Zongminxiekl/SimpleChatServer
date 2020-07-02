package cn.snowing.services.message;

import cn.snowing.domain.Message;
import cn.snowing.services.domian.MessageItem;
import cn.snowing.services.message.domian.MessageSession;

import java.util.List;

public interface MessageServices {
        /**
         * 查询所有
         * @return
         */
        public List<Message> findAll();
        public List<Message> findMessageByUsername(String username);

    /**
     * 查询用户的消息列表
     * @param username
     * @return
     */
    public List<MessageSession> getMessageSessionList(String username);

    /**
     * 导航页面处的消息列表
     * @param username
     * @return
     */
    public List<MessageItem> getUiMessageItemList(String username);
}
