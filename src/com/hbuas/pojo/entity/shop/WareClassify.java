package com.hbuas.pojo.entity.shop;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zss on 2016/5/28.
 * 商品分类表
 */
@Entity
public class WareClassify {
    private int classifyId;//商品类别id
    private String name;//类别名称
    private List<Ware> list;
    private PlantCategory category;//植物分类
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "wareClassify")
    public List<Ware> getList() {
        return list;
    }

    public void setList(List<Ware> list) {
        this.list = list;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public PlantCategory getCategory() {
        return category;
    }

    public void setCategory(PlantCategory category) {
        this.category = category;
    }
}
