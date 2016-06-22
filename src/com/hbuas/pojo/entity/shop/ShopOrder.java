package com.hbuas.pojo.entity.shop;



import com.hbuas.pojo.entity.SNSUserInfo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zss on 2016/5/27.
 * 订单实体类
 */
@Entity
public class ShopOrder {
    private int id;//订单主键id
    private int postingId;//快递单号
    private Ware ware;
    private int receiveAddressId;//收获地址id
    private int deliveryCompanyId;//物流公司id
    private String postingStatus;//订单物流状态
    private int dealStatus;//订单处理的状态：待付款  待发货 待收货 待评价
    private float fare;//运费
    private Date beginDate;//下单时间
    private Date endDate;//订单结束时间 有一个默认值下单时间加上14天
    private boolean  isValid;//订单是否有效
    private boolean  isPaied;//订单是否被支付
    private SNSUserInfo snsUserInfo;//微信用户
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        public int getPostingId() {
        return postingId;
    }
    @Column(nullable = true)
    public void setPostingId(int postingId) {
        this.postingId = postingId;
    }




    public int getReceiveAddressId() {
        return receiveAddressId;
    }

    public void setReceiveAddressId(int receiveAddressId) {
        this.receiveAddressId = receiveAddressId;
    }

    public int getDeliveryCompanyId() {
        return deliveryCompanyId;
    }

    public void setDeliveryCompanyId(int deliveryCompanyId) {
        this.deliveryCompanyId = deliveryCompanyId;
    }

    public String getPostingStatus() {
        return postingStatus;
    }

    public void setPostingStatus(String postingStatus) {
        this.postingStatus = postingStatus;
    }

    public int getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(int dealStatus) {
        this.dealStatus = dealStatus;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }
    @Temporal(TemporalType.TIME)
    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    @Temporal(TemporalType.TIME)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    @org.hibernate.annotations.Type(type="yes_no")
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }
    @org.hibernate.annotations.Type(type="yes_no")
    public boolean isPaied() {
        return isPaied;
    }

    public void setPaied(boolean isPaied) {
        this.isPaied = isPaied;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public SNSUserInfo getSnsUserInfo() {
        return snsUserInfo;
    }

    public void setSnsUserInfo(SNSUserInfo snsUserInfo) {
        this.snsUserInfo = snsUserInfo;
    }
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }
}
