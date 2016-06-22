package com.hbuas.pojo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by dell on 2016/6/9.
 */
@Entity
public class AdoptPlantInfo {

    private int id;
    private int plantId;
    private int adoptedUserId;
    private Date adoptDate;
    public AdoptPlantInfo(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public int getAdoptedUserId() {
        return adoptedUserId;
    }

    public void setAdoptedUserId(int adoptedUserId) {
        this.adoptedUserId = adoptedUserId;
    }

    public Date getAdoptDate() {
        return adoptDate;
    }

    public void setAdoptDate(Date adoptDate) {
        this.adoptDate = adoptDate;
    }
}
