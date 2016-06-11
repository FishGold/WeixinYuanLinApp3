package com.hbuas.pojo.entity.shop;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zss on 2016/5/30.
 * 商品分类所属植物科目
 */
@Entity
public class PlantCategory {
    private int categoryId;
    private String name;
    private List<WareClassify> list;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<WareClassify> getList() {
        return list;
    }

    public void setList(List<WareClassify> list) {
        this.list = list;
    }
}
