package com.hbuas.pojo.entity.shop;

import com.hbuas.pojo.entity.SNSUserInfo;

import javax.persistence.*;

/**
 * Created by zss on 2016/6/4.
 * 商品评价表
 */
@Entity
public class Assess {

    private int id;//主键Id
    private Ware ware;//评价商品
    private SNSUserInfo snsUserInfo;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Ware getWare() {
        return ware;
    }
    public void setWare(Ware ware) {
        this.ware = ware;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public SNSUserInfo getSnsUserInfo() {
        return snsUserInfo;
    }

    public void setSnsUserInfo(SNSUserInfo snsUserInfo) {
        this.snsUserInfo = snsUserInfo;
    }
}
