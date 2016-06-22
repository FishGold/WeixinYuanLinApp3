package com.hbuas.dao;

import com.hbuas.pojo.entity.PlantReportInfo;

import java.util.List;

/**
 * Created by dell on 2016/5/29.
 */
public interface PlantReportDao {
    public boolean insertReportPlantInfo(PlantReportInfo plantReportInfo);
    public PlantReportInfo getPlantInfoReport(String openid);
    public List<PlantReportInfo> queryTenRecords(int userId,int index);
}
