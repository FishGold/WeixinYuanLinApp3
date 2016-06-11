package com.hbuas.pojo.entity.shop;

import com.hbuas.pojo.entity.SNSUserInfo;

import javax.persistence.*;

/**
 * Created by zss on 2016/5/27.
 * 收货地址实体类
 */
@Entity
public class ReceiveAddress {
    private int id;//自动增加的主键id
    private String receiverName;//收获人姓名
    private String telNummer;//联系方式
    private String address;//收获地址
    private String appendDetail;//追加地址
    private boolean isDefaultAddress;//是否是默认收获地址
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
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    @Column(nullable = false)
    public String getTelNummer() {
        return telNummer;
    }

    public void setTelNummer(String telNummer) {
        this.telNummer = telNummer;
    }
    @Column(nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   @Column(nullable = true)
    public String getAppendDetail() {
        return appendDetail;
    }

    public void setAppendDetail(String appendDetail) {
        this.appendDetail = appendDetail;
    }
    @org.hibernate.annotations.Type(type="yes_no")
    public boolean isDefaultAddress() {
        return isDefaultAddress;
    }

    public void setDefaultAddress(boolean isDefaultAddress) {
        this.isDefaultAddress = isDefaultAddress;
    }


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public SNSUserInfo getSnsUserInfo() {
        return snsUserInfo;
    }

    public void setSnsUserInfo(SNSUserInfo snsUserInfo) {
        this.snsUserInfo = snsUserInfo;
    }
}
