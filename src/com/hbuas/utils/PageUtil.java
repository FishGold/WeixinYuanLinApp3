package com.hbuas.utils;

import com.hbuas.pojo.entity.shop.Ware;

import java.util.List;

/**
 * Created by zss on 2016/6/5.
 * 将list 分页 工具类
 */
public class PageUtil {
    public static List getPage(int page,int num,List list){
        List list1 =null;
        int min = page*num;
        int max = min+num;
        int size = list.size();
        if(size>=max)
            list1 = list.subList(min,max);
        else  if(size<min)
            list1 = null;
        else if(size>=min&&size<max)
            list1 = list.subList(min,size);
        return list1;
    }
}
