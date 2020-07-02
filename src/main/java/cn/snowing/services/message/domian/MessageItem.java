package cn.snowing.services.domian;

import java.util.Date;

public class MessageItem {
    private String username;
    private String fUsername;
    private  String nickname;
    private String imgSrc;
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
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
                ", imgSrc=" + imgSrc +
                ", lastMsg='" + lastMsg + '\'' +
                ", lastMsgDate=" + lastMsgDate +
                '}';
    }
}
