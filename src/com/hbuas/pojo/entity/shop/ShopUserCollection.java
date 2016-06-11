package com.hbuas.pojo.entity.shop;

import com.hbuas.pojo.entity.SNSUserInfo;

import javax.persistence.*;

/**
 * Created by zss on 2016/5/30.
 * 用户收藏实体类
 */
@Entity
public class ShopUserCollection {
    private int id;//收藏表主键
    private int storeId;//收藏店铺Id
    private int wareId;//商品Id
    private SNSUserInfo snsUserInfo;
    public ShopUserCollection(){}
    public ShopUserCollection(int wareId){
        this.wareId = wareId;
    }
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Column(nullable = true)
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
   @Column(nullable = true)
    public int getWareId() {
        return wareId;
    }

    public void setWareId(int wareId) {
        this.wareId = wareId;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    public SNSUserInfo getSnsUserInfo() {
        return snsUserInfo;
    }

    public void setSnsUserInfo(SNSUserInfo snsUserInfo) {
        this.snsUserInfo = snsUserInfo;
    }
}
