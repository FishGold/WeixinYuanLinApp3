package com.hbuas.dao;

import com.hbuas.pojo.entity.AdoptPlantInfo;
import com.hbuas.pojo.entity.DonatePlantInfo;

import java.util.List;

/**
 * Created by dell on 2016/6/9.
 */
public interface AdoptPlantDao {
    public boolean adoptPlantInfoInsert(AdoptPlantInfo adoptPlantInfo);
    public List<AdoptPlantInfo> queryAdoptedPlantInfo(int index);
    public List<AdoptPlantInfo> queryAdoptedPlantInfoByUserId(int userId,int index);
}
