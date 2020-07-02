package cn.snowing.services.contacts.domain;

import java.io.Serializable;
import java.util.Date;

public class Friend implements Serializable {
    private String username;
    private String fUsername;
    private String nickname;
    private String remark;
    private String sex;
    private String tel;
    private Date birthday;
    private String email;
    private String imgSrc;
    private String signature;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFUsername() {
        return fUsername;
    }

    public void setFUsername(String fUsername) {
        this.fUsername = fUsername;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "username='" + username + '\'' +
                ", fUsername='" + fUsername + '\'' +
                ", nickname='" + nickname + '\'' +
                ", remark='" + remark + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
