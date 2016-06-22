package com.hbuas.daoImpl;

import com.hbuas.dao.CategoryDao;
import com.hbuas.pojo.entity.shop.PlantCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zss on 2016/6/4.
 * 植物分类Dao 操作
 */
@Repository
public class CategoryDaoImpl implements CategoryDao{
    @Autowired
    private SessionFactory sessionFactory;
    public String getCategoryNameById(int id){
        Session session = sessionFactory.getCurrentSession();
        PlantCategory plantCategory = (PlantCategory)session.get(PlantCategory.class,id);
        return plantCategory.getName();
    }

    @Override
    public PlantCategory getPlantCategoryById(int id) {
        Session session = sessionFactory.getCurrentSession();
        PlantCategory plantCategory =(PlantCategory)session.load(PlantCategory.class, id);
        return plantCategory;
    }

    @Override
    public List<PlantCategory> getAllCategory() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from PlantCategory ");
        List<PlantCategory> list = query.list();
        return list;
    }

}
