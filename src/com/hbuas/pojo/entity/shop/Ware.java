package com.hbuas.pojo.entity.shop;



import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zss on 2016/5/27.
 * 商品信息实体类
 */
@Entity
@Table()
public class Ware {
    private int wareId;
    private WareClassify wareClassify;//商品分类id
    private Store store;//店铺或者苗圃场
    private String name;//商品名称
    private int categoryId;//植物所属科目id
    private float oldPrice;//商品原价
    private float price;//商品现价
    private String shortDescription;
    private String description;//商品描述
    private List<ShopImageUrl> imgUrl;//商品图片地址数组
    private String area;//商品地区
    private int areaId;//商品地区
    private String areaDetail;//商品详细地址
    private int remainNum;//库存
    private int salesNum;//销量
    private WareHeights wareHeights;//植株高度
    private List<Assess> assess;//商品评价
    private int assessNum;//评价数量
    private Cart cart;
    private List<ShopOrder> shopOrderList;//商品订单
    public Ware(){}
    public Ware(int categoryId){
        this.categoryId = categoryId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getWareId() {
        return wareId;
    }

    public void setWareId(int wareId) {
        this.wareId = wareId;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public WareClassify getWareClassify() {
        return wareClassify;
    }

    public void setWareClassify(WareClassify wareClassify) {
        this.wareClassify = wareClassify;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(columnDefinition="INT default 0")
    public int getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(int salesNum) {
        this.salesNum = salesNum;
    }
   @Column(nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }
    @Column(nullable = true)
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    @Column(nullable = false)
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    @Type(type = "text")
    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ware")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<ShopImageUrl> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<ShopImageUrl> imgUrl) {
        this.imgUrl = imgUrl;
    }



    @Column(nullable = false)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    @Column(nullable = false)
    public String getAreaDetail() {
        return areaDetail;
    }

    public void setAreaDetail(String areaDetail) {
        this.areaDetail = areaDetail;
    }

    @Column(columnDefinition="INT default 0")
    public int getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(int remainNum) {
        this.remainNum = remainNum;
    }
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "ware",fetch = FetchType.LAZY)
    public WareHeights getWareHeights() {
        return wareHeights;
    }

    public void setWareHeights(WareHeights wareHeights) {
        this.wareHeights = wareHeights;
    }
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ware")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<Assess> getAssess() {
        return assess;
    }

    public void setAssess(List<Assess> assess) {
        this.assess = assess;
    }
    @Transient
    public int getAssessNum() {
        return assessNum;
    }

    public void setAssessNum(int assessNum) {
        this.assessNum = assessNum;
    }
    @Column(columnDefinition="INT default 0")
    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ware")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<ShopOrder> getShopOrderList() {
        return shopOrderList;
    }

    public void setShopOrderList(List<ShopOrder> shopOrderList) {
        this.shopOrderList = shopOrderList;
    }
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
