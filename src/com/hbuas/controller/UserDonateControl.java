package com.hbuas.controller;
import com.hbuas.dao.DonatePlantDao;
import com.hbuas.daoImpl.DonatePlantDaoImpl;
import com.hbuas.pojo.entity.DonatePlantInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
/**
 * Created by dell on 2016/6/5.
 */
@Controller
@RequestMapping(value = "/donate", method = RequestMethod.POST)
public class UserDonateControl extends HttpServlet {

    private String imagePath_1,fileName_1;
    private String imagePath_2,fileName_2;
    private String imagePath_3,fileName_3;

    @RequestMapping(value = "/store",method = RequestMethod.POST)
    public String  handleDonateInfo(HttpServletRequest request){
        uploadImage(request);
        storeData(request);
        return "donateSuccess.jsp";
    }
    public void uploadImage(HttpServletRequest request ) {
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        for(int i=1;i<4;i++){
            String path = request.getSession().getServletContext().getRealPath("/images/userDonate/"+i);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile imgFile = multipartRequest.getFile("picture_"+i);
            if (!(imgFile.getOriginalFilename() == null || "".equals(imgFile.getOriginalFilename()))) {
                String fileName = 3+imgFile.getOriginalFilename();
                File file = new File(path + "/" + fileName);
                switch (i){
                    case 1:imagePath_1 = path + "/" + fileName;fileName_1=fileName;break;
                    case 2:imagePath_2 = path + "/" + fileName;fileName_2=fileName;break;
                    case 3:imagePath_3 = path + "/" + fileName;fileName_3=fileName;break;
                    default:break;
                }
                try {
                    imgFile.transferTo(file);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void storeData(HttpServletRequest request) {

        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
        DonatePlantDao dpd = applicationContext.getBean(DonatePlantDaoImpl.class);


        DonatePlantInfo dpi = new DonatePlantInfo();
        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();

        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String plantName = request.getParameter("plantName");
        String reason = request.getParameter("reason");
        String plantDesc = request.getParameter("plantDesc");
        java.util.Date  date=new java.util.Date();

        dpi.setUserName(userName);
        dpi.setPhone(phone);
        dpi.setPlantName(plantName);
        dpi.setReason(reason);
        dpi.setDonateDate(new Date(date.getTime()));
        dpi.setUserId(3);//注意修改为userId
        dpi.setPlantDesc(plantDesc);
        dpi.setImage_1(fileName_1);
        dpi.setImage_2(fileName_2);
        dpi.setImage_3(fileName_3);
        dpi.setIsAdopted(0);
        fileName_3 = "";
        fileName_2 = "";
        fileName_1 = "";
        imagePath_1 = "";
        imagePath_2 = "";
        imagePath_3 = "";
        dpd.donatePlantInfoInsert(dpi);
    }

}
