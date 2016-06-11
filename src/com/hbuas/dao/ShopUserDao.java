package com.hbuas.dao;


import com.hbuas.pojo.entity.shop.ShopUser;
import com.hbuas.pojo.entity.shop.WareClassify;


import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

/**
 * Created by zss on 2016/6/1.
 * 商城用户操作接口
 */
@Service
public interface ShopUserDao {
    /*
      @param userId 用户Id
      @return 返回用户购买的商品类别list
    * */
    public List<WareClassify>getUserRecoderWareClassify(int userId);
    /*
    * @param userId 用户Id
    * @return 返回用户收藏的商品 类别
    * */
    public List<WareClassify> getUserCollectionClassify(int userId);
    public boolean saveUserSearch(int id,String keyWord);
    public Map<String,String> getUserInfo(int id);
    public boolean updateUserinfo(int userId,ShopUser shopUser);
}
