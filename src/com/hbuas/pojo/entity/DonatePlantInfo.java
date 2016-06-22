package com.hbuas.pojo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by dell on 2016/6/5.
 */
@Entity
public class DonatePlantInfo {
    private int id;
    private int userId;
    private String userName;
    private String phone;
    private String plantName;
    private String reason;
    private String image_1;
    private String image_2;
    private String image_3;
    private String plantDesc;
    private Date donateDate;
    private int isAdopted;
    public DonatePlantInfo(){}
    public DonatePlantInfo(String image_1,String plantName,String reason,String plantDesc){
        super();
        this.image_1 = image_1;
        this.reason = reason;
        this.plantDesc = plantDesc;
        this.plantName = plantName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPlantName() {
        return plantName;
    }
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getImage_1() {
        return image_1;
    }
    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }
    public String getImage_2() {
        return image_2;
    }
    public void setImage_2(String image_2) {
        this.image_2 = image_2;
    }
    public String getImage_3() {
        return image_3;
    }
    public void setImage_3(String image_3) {
        this.image_3 = image_3;
    }
    public Date getDonateDate() {
        return donateDate;
    }
    public void setDonateDate(Date donateDate) {
        this.donateDate = donateDate;
    }

    public String getPlantDesc() {
        return plantDesc;
    }

    public void setPlantDesc(String plantDesc) {
        this.plantDesc = plantDesc;
    }

    public int getIsAdopted() {
        return isAdopted;
    }

    public void setIsAdopted(int isAdopted) {
        this.isAdopted = isAdopted;
    }
}
