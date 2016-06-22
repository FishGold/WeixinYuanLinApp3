package com.hbuas.pojo.entity.shop;

import com.hbuas.pojo.entity.SNSUserInfo;

import javax.persistence.*;

/**
 * Created by zss on 2016/5/30.
 * 记录用户购买过的商品类别
 */
@Entity
public class BuyRecord {
    private int recordId;//记录表主键
    private int classifyId;//商品类别Id
    private int wareId;//购买商品Id
    private SNSUserInfo snsUserInfo;
    public BuyRecord(){}
    public BuyRecord(int classifyId){
        this.classifyId = classifyId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }
    @Column(nullable = false)
    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }
    public int getWareId() {
        return wareId;
    }

    public void setWareId(int wareId) {
        this.wareId = wareId;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public SNSUserInfo getSnsUserInfo() {
        return snsUserInfo;
    }

    public void setSnsUserInfo(SNSUserInfo snsUserInfo) {
        this.snsUserInfo = snsUserInfo;
    }
}
