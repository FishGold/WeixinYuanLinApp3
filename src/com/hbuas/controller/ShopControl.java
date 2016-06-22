package com.hbuas.controller;

import com.hbuas.dao.SNSUserDao;
import com.hbuas.pojo.entity.SNSUserInfo;
import com.hbuas.pojo.entity.shop.*;
import com.hbuas.service.CategoryService;
import com.hbuas.service.ClassifyService;
import com.hbuas.service.SearchService;
import com.hbuas.serviceImpl.ShopHomeService;
import com.hbuas.utils.EncodingTool;
import com.hbuas.utils.PageUtil;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by zss on 2016/5/2.
 */
@Controller
@RequestMapping("/shop")
public class ShopControl {
    @Autowired
    private SNSUserDao snsUserDao;
    @Autowired
    private ShopHomeService shopHomeService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ClassifyService classifyService;
    @Autowired
    private SearchService searchService;
    @Resource
    private HttpSession session;
    private Logger logger = LogManager.getLogger();

    /*主页*/
    @RequestMapping("/home")
    public String home(ModelMap map){
        map.addAttribute("carousels",shopHomeService.getShopCarousel());
        map.addAttribute("wareMap",shopHomeService.getWaresByCategory(2));
        Integer integer = (Integer)session.getAttribute("userId");
        int userId = -1;
        if (integer!=null){
            userId = integer.intValue();
        }
        map.addAttribute("likes",shopHomeService.getUserLikeWares(1,0,2));//进入用户并没有登陆，也不知道用户喜欢什么商品。
        return "shop/home.jsp";
    }
   /*商品分类*/
    @RequestMapping("/sorts")
    public String sorts(ModelMap map ){
        List<PlantCategory> list = categoryService.getAllPlants();
        map.addAttribute("list",list);
        return "/shop/sorts.jsp";
    }


    /*推荐商品*/
    @RequestMapping("/recommend")
    public String recommend(ModelMap map,@RequestParam int page){
        Integer integer = (Integer)session.getAttribute("useId");
        int userId = -1;
        if(integer != null){
            userId = integer.intValue();
        }
        logger.info("shopUserId"+userId);
        List<Ware> list = shopHomeService.getUserLikeWares(userId,page,2);
        map.addAttribute("list",list);
        return "shop/recommendWares.jsp";
    }

    @RequestMapping("/recommend_json")
    @ResponseBody
    public String recommed_json(@RequestParam int page){
        Integer integer = (Integer)session.getAttribute("useId");
        int userId = -1;
        if(integer != null){
            userId = integer.intValue();
        }
        List<Ware> list = shopHomeService.getUserLikeWares(userId,page,2);
        JSONArray jsonArray= categoryService.wareList2Json(list);
        return jsonArray.toString();
    }

    /*用于处理 猜你喜欢 和 推荐商品ajax请求*/
    @RequestMapping("/guessYouLike")
    @ResponseBody
    public String guessYouLike_json(@RequestParam int page){
       Integer integer = (Integer)session.getAttribute("useId");
      int userId = -1;
        if(integer != null){
           userId = integer.intValue();
        }
        List<Ware> list = shopHomeService.getUserLikeWares(userId,page,2);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName()+list.get(i).getImgUrl());
        }
        JSONArray jsonArray = shopHomeService.PartWareList2Json1(list);
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }


    /*热卖商品*/
    @RequestMapping("/hot")
    public String hot(ModelMap map,@RequestParam int page){
        List<Ware> list = categoryService.getHotWare(page,3);
        map.addAttribute("list",list);
        return "/shop/hotWares.jsp";
    }


    /*用于处理热卖商品的ajax*/
    @RequestMapping("/hot_json")
    @ResponseBody
    public String hot_json(@RequestParam int page){
        List<Ware> list = categoryService.getHotWare(page,3);
        JSONArray jsonArray = categoryService.wareList2Json(list);
        return jsonArray.toString();
    }

    /*处理某一大分类的植物*/
    @RequestMapping("/categoryMore")
    public String categoryMore(ModelMap map,@RequestParam int categoryId,@RequestParam int page){
        List<Ware> list = categoryService.getWareByCategory(categoryId,page,2);
        PlantCategory category = categoryService.getCategory(categoryId);
        map.addAttribute("list",list);
        map.addAttribute("category",category);
        return "shop/categoryWares.jsp";
    }
    @RequestMapping("/categoryMore_json")
    @ResponseBody
    public String categoryMore_json(@RequestParam int categoryId,@RequestParam int page){
        System.out.println(categoryId+"**"+page);
        List<Ware> list = categoryService.getWareByCategory(categoryId,page,2);
        JSONArray jsonArray = categoryService.wareList2Json(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName()+list.get(i).getImgUrl().get(0).getImgUrl());
        }
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }

    /*处理某一类别植物的请求*/
    @RequestMapping("/classifyMore")
    public String classifyMore(ModelMap map,@RequestParam int classifyId,@RequestParam int page){
        List<Ware> list = classifyService.getClassifyWareById(classifyId,page,1);
        WareClassify classify = classifyService.getClassifyById(classifyId);
        map.addAttribute("list",list);
        map.addAttribute("classify",classify);
        return "shop/classifyWares.jsp";
    }

    /*处理某一类别植物的ajax请求*/
    @RequestMapping("/classifyMore_json")
    @ResponseBody
    public String classifyMore_json (@RequestParam int classifyId,@RequestParam int page){
        List<Ware> list = classifyService.getClassifyWareById(classifyId,page,1);
        JSONArray jsonArray = categoryService.wareList2Json(list);
        return jsonArray.toString();
    }
    @RequestMapping("/wareDetail")
    public String wareDetial(ModelMap map,@RequestParam int wareId){
        Ware ware = shopHomeService.getWare(wareId);
        map.addAttribute(ware);
       WareHeights list =  ware.getWareHeights();
        return "/shop/showWare.jsp";
    }

    /*进入商品搜索页面*/
    @RequestMapping("/goToSearch")
    public String gotoSearch(ModelMap map){
        Integer integer = (Integer)session.getAttribute("userId");
        int id = -1;//会话中没有“userId”表示用户未登陆
        if (integer != null){
            id = integer.intValue();
        }
        logger.info(id);
        HashSet<String> set1 = searchService.getUserRecentSearch(id);
        HashSet<String> set2 = searchService.getHotSearch(0,6);//第0页取12章
        map.addAttribute("set1",set1);
        map.addAttribute("set2",set2);
        return "shop/goToSearch.jsp";
    }
    /*处理商品搜索*/
    @RequestMapping("/search")
    public String wareSerch(ModelMap map,@RequestParam String keyWord){
        String key = EncodingTool.encodeStr(keyWord);
        List<Ware> list = searchService.searchWare(key,0,12);
        map.addAttribute("list",list);
        map.addAttribute("key",key);
        Integer integer = (Integer)session.getAttribute("userId");
        int id = -1;//会话中没有“userId”表示用户未登陆
        if (integer != null){
            id = integer.intValue();
        }
        boolean result =searchService.saveUserSearch(id,key);
        if (result)
            logger.info("插入一条搜索记录"+key);
        return "shop/searchResult.jsp";
    }
    /*用户清楚搜素记录*/
    @RequestMapping("/search_Result_clear")
    public void search_Result_clear(){
        logger.info("search_Result_clear");
    }
    @RequestMapping("/hot_change_ano_json")
    @ResponseBody
    public String hot_change_ano_json(@RequestParam int page){
        HashSet<String> set = searchService.getHotSearch(page,6);//第page页取6条记录
        JSONArray jsonArray = JSONArray.fromObject(set);
        logger.info(jsonArray.toString());
        return jsonArray.toString();
    }
    /*处理商品搜索 获取更多 数据 ajax请求*/
    @RequestMapping("/search_json")
    @ResponseBody
    public String search_json(@RequestParam String keyWord,@RequestParam int page){
        String key = EncodingTool.encodeStr(keyWord);
        List<Ware> list = searchService.searchWare(key,page,12);
        JSONArray jsonArray =categoryService.wareList2Json(list);
        return jsonArray.toString();
    }
}
