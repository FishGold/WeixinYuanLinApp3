package com.hbuas.pojo.entity.shop;

import com.hbuas.pojo.entity.SNSUserInfo;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zss on 2016/6/9.
 * 购物车 实体
 */
@Entity
public class Cart {

    int id;//主键id
    private SNSUserInfo snsUserInfo;//微信用户
    private List<Ware> list;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public SNSUserInfo getSnsUserInfo() {
        return snsUserInfo;
    }

    public void setSnsUserInfo(SNSUserInfo snsUserInfo) {
        this.snsUserInfo = snsUserInfo;
    }
    @OneToMany(mappedBy = "cart")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<Ware> getList() {
        return list;
    }

    public void setList(List<Ware> list) {
        this.list = list;
    }
}
