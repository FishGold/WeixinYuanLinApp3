package com.hbuas.pojo.menu;


//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;



import com.hbuas.pojo.Token;
import com.hbuas.utils.CommonUtil;
import com.hbuas.utils.MenuUtil;

/**
 * Created by 王成 on 2015/11/21.
 */
public class Test {
    // private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    /**
     * 定义菜单结构
     *
     * @return
     */
    private static Menu getMenu() {

        ViewButton btn11 = new ViewButton();
        btn11.setName("园林咨询");
        btn11.setType("view");
        btn11.setUrl("http://www.yunjoke.com/yuanlin/sx/Gardenconsulting.html");

        ViewButton btn12 = new ViewButton();
        btn12.setName("园林科普");
        btn12.setType("view");
        btn12.setUrl("http://www.yunjoke.com/yuanlin/shop");

        ViewButton btn13 = new ViewButton();
        btn13.setName("园林观赏");
        btn13.setType("view");
        btn13.setUrl("http://www.yunjoke.com/yuanlin/test");

//        ClickButton btn14 = new ClickButton();//111111111111111click
//        btn14.setName("联系我们");
//        btn14.setType("click");
//        btn14.setKey("callus");//联系我们
//
//        ViewButton btn15 = new ViewButton();
//        btn15.setName("个人注册");
//        btn15.setType("view");
//        btn15.setUrl("http://111.177.117.94/three/shop.html");


        ViewButton btn21 = new ViewButton();
        btn21.setName("探索发现");
        btn21.setType("view");
        btn21.setUrl("http://www.yunjoke.com/yuanlin/bgm/html/report.html");

        ViewButton btn22 = new ViewButton();//11111111111111111click
        btn22.setName("认捐认养");
        btn22.setType("view");
        btn22.setUrl("http://www.yunjoke.com/yuanlin/bgm/html/donateAndAdopt.html");//通知公告

        ViewButton btn23 = new ViewButton();
        btn23.setName("趣商城");
        btn23.setType("view");
        btn23.setUrl("http://www.yunjoke.com/yuanlin/shop/home");



        ViewButton btn31 = new ViewButton();//11111111111111111click
        btn31.setName("园林社区");
        btn31.setType("view");
        btn31.setUrl("http://www.yunjoke.com/yuanlin/wc/home.html");

        ViewButton btn32 = new ViewButton();
        btn32.setName("我的商城");
        btn32.setType("view");
        btn32.setUrl("http://111.177.117.94/five/html/zss/myItems.html");

        ViewButton btn33 = new ViewButton();
        btn33.setName("在线咨询");
        btn33.setType("view");
        btn33.setUrl("http://111.177.117.94/five/html/zss/myItems.html");


        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("精彩推荐");
        mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13});


        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("园林互动");
        mainBtn2.setSub_button(new Button[] { btn21, btn22, btn23});

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("我的花园");
        mainBtn3.setSub_button(new Button[] { btn31, btn32 ,btn33});


        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
        return menu;
    }

    public static void main(String[] args) {
        // 第三方用户唯一凭证

        //String appId = "wx332d45de169c738f";
        // 第三方用户唯一凭证密钥
        // String appSecret = "d4624c36b6795d1d99dcf0547af5443d";


        String appId= "wx530299b7dd584037";//zss的密码
        String appSecret="d4624c36b6795d1d99dcf0547af5443d";


        // 调用接口获取凭证
        Token token = CommonUtil.getToken(appId, appSecret);
        System.out.println(token);
        if (null != token) {
            // 创建菜单
            boolean result = MenuUtil.createMenu(getMenu(), token.getAccessToken());
           // boolean result = MenuUtil.deleteMenu(token.getAccessToken());

            // 判断菜单创建结果
            if (result)
                // log.info("菜单创建成功！");
                System.out.println("创建菜单成功！");
            else
                // log.info("菜单创建失败！");
                System.out.println("创建菜单失败");
        }
    }
}
