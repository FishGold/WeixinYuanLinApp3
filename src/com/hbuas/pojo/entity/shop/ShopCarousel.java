package com.hbuas.pojo.entity.shop;

import javax.persistence.*;

/**
 * Created by zss on 2016/5/29.
 * 商城主页轮播实体
 *
 */
@Entity
public class ShopCarousel {

    private int id;//id主键
    private String imgUrl;//轮播地址url

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(nullable = false)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
