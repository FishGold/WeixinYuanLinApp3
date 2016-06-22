package com.hbuas.serviceImpl;

import com.hbuas.dao.WareDao;
import com.hbuas.pojo.entity.shop.Ware;
import com.hbuas.pojo.entity.shop.WareClassify;
import com.hbuas.service.ClassifyService;
import com.hbuas.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zss on 2016/6/5.
 */
@Service
public class ClassifyServiceImpl implements ClassifyService{
    @Autowired
    private WareDao wareDao;
    @Override
    public List<Ware> getClassifyWareById(int id, int page, int num) {
        List<Ware> list = wareDao.getWaresByClassifyId(id);
        List<Ware> list1 = PageUtil.getPage(page,num,list);
        return list1;
    }

    @Override
    public WareClassify getClassifyById(int id) {

        return wareDao.getClassifyById(id);
    }
}
