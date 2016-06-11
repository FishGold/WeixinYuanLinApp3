package com.hbuas.pojo.entity.shop;

import javax.persistence.*;

/**
 * Created by zss on 2016/5/29.
 * 商城图片地址表
 */
@Entity
public class ShopImageUrl {
    private int  id ;//主键
    private int WareId;//商品id
    private String imgUrl;//图片地址
    private Ware ware;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

   @Column(nullable = false)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }



   @Column(nullable = false)
    public int getWareId() {
        return WareId;
    }

    public void setWareId(int wareId) {
        WareId = wareId;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }
}
