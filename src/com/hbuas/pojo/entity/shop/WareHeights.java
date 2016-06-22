package com.hbuas.pojo.entity.shop;

import javax.persistence.*;

/**
 * Created by zss on 2016/6/2.
 */
@Entity
public class WareHeights {
    private int id;//主键Id
    private int minGd;//最小植株高度
    private int maxGd;//最大植株高度
    private int minXj;//最小胸径
    private int maxXj;//最大胸径
    private int minDj;//最小地径
    private int maxDj;//最大地径
    private int minGf;//最小冠幅
    private int maxGf;//最大冠幅
    private Ware ware;//商品
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Column(columnDefinition="INT default 1")
    public int getMinGd() {
        return minGd;
    }

    public void setMinGd(int minGd) {
        this.minGd = minGd;
    }
    @Column(nullable = false)
    public int getMaxGd() {
        return maxGd;
    }

    public void setMaxGd(int maxGd) {
        this.maxGd = maxGd;
    }
    @Column(columnDefinition="INT default 1")
    public int getMinXj() {
        return minXj;
    }

    public void setMinXj(int minXj) {
        this.minXj = minXj;
    }
    @Column(nullable = false)
    public int getMaxXj() {
        return maxXj;
    }

    public void setMaxXj(int maxXj) {
        this.maxXj = maxXj;
    }
    @Column(columnDefinition="INT default 1")
    public int getMinDj() {
        return minDj;
    }

    public void setMinDj(int minDj) {
        this.minDj = minDj;
    }
    @Column(nullable = false)
    public int getMaxDj() {
        return maxDj;
    }

    public void setMaxDj(int maxDj) {
        this.maxDj = maxDj;
    }
    @Column(columnDefinition="INT default 1")
    public int getMinGf() {
        return minGf;
    }

    public void setMinGf(int minGf) {
        this.minGf = minGf;
    }
    @Column(nullable = false)
    public int getMaxGf() {
        return maxGf;
    }

    public void setMaxGf(int maxGf) {
        this.maxGf = maxGf;
    }
    @OneToOne()
    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }
}
