package com.hbuas.pojo.entity.shop;



import javax.persistence.*;


/**
 * Created by zss on 2016/6/10.
 */
@Entity
public class ShopUser {
    private int id;//主键
    private String realName;//真实姓名
    private String addressDetal;//详细地址
    private String phoneNum;//联系方式
    private String email;//邮箱
    private int userId;//与snsUserInfo 表主键关联，这里手动维护
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
