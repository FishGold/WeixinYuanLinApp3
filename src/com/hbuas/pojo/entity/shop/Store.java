package com.hbuas.pojo.entity.shop;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zss on 2016/6/11.
 * 店铺实体
 */
@Entity
public class Store {
    private int id;//主键
    private List<Ware> list;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "store")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public List<Ware> getList() {
        return list;
    }

    public void setList(List<Ware> list) {
        this.list = list;
    }
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
