package com.hbuas.pojo.entity;


import java.sql.Date;

/**
 * Created by dell on 2016/5/29.
 */
public class PlantReportInfo {
    private int id;
    private int userId;
    private String describeAboutPlant;
    private String addressAboutReport;
    private String detailAddressAboutPlant;
    private String illPlantImagesAddress;
    private Date reportDate;

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getDescribeAboutPlant() {
        return describeAboutPlant;
    }

    public void setDescribeAboutPlant(String describeAboutPlant) {
        this.describeAboutPlant = describeAboutPlant;
    }

    public String getAddressAboutReport() {
        return addressAboutReport;
    }

    public void setAddressAboutReport(String addressAboutReport) {
        this.addressAboutReport = addressAboutReport;
    }

    public String getDetailAddressAboutPlant() {
        return detailAddressAboutPlant;
    }

    public void setDetailAddressAboutPlant(String detailAddressAboutPlant) {
        this.detailAddressAboutPlant = detailAddressAboutPlant;
    }

    public String getIllPlantImagesAddress() {
        return illPlantImagesAddress;
    }

    public void setIllPlantImagesAddress(String illPlantImagesAddress) {
        this.illPlantImagesAddress = illPlantImagesAddress;
    }

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
}
