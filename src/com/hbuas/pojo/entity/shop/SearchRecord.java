package com.hbuas.pojo.entity.shop;

import com.hbuas.pojo.entity.SNSUserInfo;

import javax.persistence.*;

/**
 * Created by zss on 2016/6/7.
 * 用户搜索记录表
 */
@Entity
public class SearchRecord {
    private int id;//主键id
    private String keyWord;//用户搜索的关键词

    private SNSUserInfo snsUserInfo;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Column(nullable = false)
    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    public SNSUserInfo getSnsUserInfo() {
        return snsUserInfo;
    }

    public void setSnsUserInfo(SNSUserInfo snsUserInfo) {
        this.snsUserInfo = snsUserInfo;
    }
}
