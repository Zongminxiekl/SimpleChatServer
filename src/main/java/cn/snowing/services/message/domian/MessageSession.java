package cn.snowing.services.message.domian;

import cn.snowing.domain.Message;

import java.util.List;

public class MessageSession {
    private List<Message> messageSession;

    public List<Message> getMessageSession() {
        return messageSession;
    }

    public void setMessageSession(List<Message> messageSession) {
        this.messageSession = messageSession;
    }
}
