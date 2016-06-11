package com.hbuas.pojo.entity;


import com.hbuas.pojo.entity.shop.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ZSS on 2016/4/27.
 * 通过网页授权获取的用户信息
 */
@Entity
@Table(name="sns_user_info")
public class SNSUserInfo {
    private String openId;
    private String nickname;
    private String sex;
    private String country;
    private String province;
    private String city;
    private String headImgUrl;
    private int id;
    private Cart cart;   //购物车列表
    private List<ReceiveAddress> addressesList;//收货地址列表
    private List<Assess> assessList;//评价表
    private List<ShopUserCollection> collectionslist;//用户收藏表
    private List<ShopOrder> orderList;//我的订单列表
    private List<SearchRecord> list;
    private List<BuyRecord> buyRecordList;//用户购买商品列表
    private List<ShopOrder> shopOrderList;//用户订单列表
    public SNSUserInfo(){}
    public SNSUserInfo(int id){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
    //oneToMany指定了一对多的关系，mappedBy="room"指定了由多的那一方来维护关联关系，m
    // appedBy指的是多的一方对1的这一方的依赖的属性，(注意：如果没有指定由谁来维护关联关系，则系统会给我们创建一张中间表)
   //LazyCollection属性设置成EXTRA指定了当如果查询数据的个数时候，只会发出一条 count(*)的语句，提高性能
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "snsUserInfo")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @OneToMany(mappedBy = "snsUserInfo")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<ReceiveAddress> getAddressesList() {
        return addressesList;
    }

    public void setAddressesList(List<ReceiveAddress> addressesList) {
        this.addressesList = addressesList;
    }
    @OneToMany(mappedBy = "snsUserInfo")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<Assess> getAssessList() {
        return assessList;
    }

    public void setAssessList(List<Assess> assessList) {
        this.assessList = assessList;
    }
    @OneToMany(mappedBy = "snsUserInfo")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<ShopUserCollection> getCollectionslist() {
        return collectionslist;
    }

    public void setCollectionslist(List<ShopUserCollection> collectionslist) {
        this.collectionslist = collectionslist;
    }
    @OneToMany(mappedBy = "snsUserInfo")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<ShopOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ShopOrder> orderList) {
        this.orderList = orderList;
    }
    @OneToMany(mappedBy = "snsUserInfo")//oneToMany指定了一对多的关系，mappedBy="room"指定了由多的那一方来维护关联关系，mappedBy指的是多的一方对1的这一方的依赖的属性，(注意：如果没有指定由谁来维护关联关系，则系统会给我们创建一张中间表)
    @LazyCollection(LazyCollectionOption.EXTRA)//LazyCollection属性设置成EXTRA指定了当如果查询数据的个数时候，只会发出一条 count(*)的语句，提高性能
    public List<SearchRecord> getList() {
        return list;
    }

    public void setList(List<SearchRecord> list) {
        this.list = list;
    }
      @OneToMany(mappedBy = "snsUserInfo")
      @LazyCollection(LazyCollectionOption.EXTRA)
    public List<BuyRecord> getBuyRecordList() {
        return buyRecordList;
    }

    public void setBuyRecordList(List<BuyRecord> buyRecordList) {
        this.buyRecordList = buyRecordList;
    }
    @OneToMany(mappedBy = "snsUserInfo")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<ShopOrder> getShopOrderList() {
        return shopOrderList;
    }

    public void setShopOrderList(List<ShopOrder> shopOrderList) {
        this.shopOrderList = shopOrderList;
    }

    private String realName;//真实姓名
    private String addressDetal;//详细地址
    private String phoneNum;//联系方式
    private String email;//邮箱
   @Column(nullable = true)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    @Column(nullable = true)
    public String getAddressDetal() {
        return addressDetal;
    }

    public void setAddressDetal(String addressDetal) {
        this.addressDetal = addressDetal;
    }
   @Column(nullable = true)
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
   @Column(nullable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
