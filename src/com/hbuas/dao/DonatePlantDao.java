package com.hbuas.dao;

import com.hbuas.pojo.entity.DonatePlantInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by dell on 2016/6/5.
 */
public interface DonatePlantDao {
    public boolean donatePlantInfoInsert(DonatePlantInfo dpi);
    public List<DonatePlantInfo> queryTenRecords(int currentIndex);
    public DonatePlantInfo queryPlant(int plantId);
    public List<DonatePlantInfo> queryUsersDonates(int userId,int index);
}
