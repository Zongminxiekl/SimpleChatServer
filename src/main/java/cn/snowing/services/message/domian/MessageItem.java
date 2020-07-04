package cn.snowing.services.message.domian;

import java.util.Date;

/**
 * MessageItem是用于展示消息列表的实体类
 */
public class MessageItem {
    private String username;
    private String fUsername;
    private  String nickname;
    private String head;
    private String lastMsg;
    private Date lastMsgDate;

    public String getFUsername() {
        return fUsername;
    }

    public void setFUsername(String fUsername) {
        this.fUsername = fUsername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public Date getLastMsgDate() {
        return lastMsgDate;
    }

    public void setLastMsgDate(Date lastMsgDate) {
        this.lastMsgDate = lastMsgDate;
    }

    @Override
    public String toString() {
        return "MessageItem{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", head=" + head +
                ", lastMsg='" + lastMsg + '\'' +
                ", lastMsgDate=" + lastMsgDate +
                '}';
    }
}
