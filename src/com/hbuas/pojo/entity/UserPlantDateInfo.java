package com.hbuas.pojo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by dell on 2016/6/9.
 */
public class UserPlantDateInfo {
    private Date date;
    private String headImgUrl;
    private String image_1;
    private String nickname;
    public UserPlantDateInfo(){}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
