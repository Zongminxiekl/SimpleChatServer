package cn.snowing.domain;

import java.io.Serializable;
import java.util.Date;


/**Message表的实体类
 *
 */
public class Message implements Serializable {
    private Integer messageId;
    private String username;
    private  String fUsername;
    private String messageContent;
    private Date messageDate;
    private Integer type;
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getfUsername() {
        return fUsername;
    }

    public void setfUsername(String fUsername) {
        this.fUsername = fUsername;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", username='" + username + '\'' +
                ", fUsername='" + fUsername + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageDate=" + messageDate +
                ", type=" + type +
                '}';
    }
}
