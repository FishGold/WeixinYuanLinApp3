package com.hbuas.controller;
import com.hbuas.dao.PlantReportDao;
import com.hbuas.daoImpl.IllPlantInfoDaoImpl;
import com.hbuas.pojo.entity.PlantReportInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by dell on 2016/5/29.
 */
@Controller
@RequestMapping(value = "/report", method = RequestMethod.POST)
public class ReportPlantControl extends HttpServlet {
    private String imagePath;
    private String fileName;

    @RequestMapping(value = "/plant", method = RequestMethod.POST)
    public String demo(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

        uploadIllPlantImage(request);
        illPlantInfoToDb(request);

        return "donateSuccess.jsp";
    }

    public void uploadIllPlantImage(HttpServletRequest request) {
       // int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        String path = request.getSession().getServletContext().getRealPath("/images/illPlantPic");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile imgFile = multipartRequest.getFile("reportPlantImage");
        if (!(imgFile.getOriginalFilename() == null || "".equals(imgFile.getOriginalFilename()))) {

            fileName =3+ imgFile.getOriginalFilename();
            File file = new File(path + "/" + fileName);
            imagePath = path + "/" + fileName;//全路径
            try {
                imgFile.transferTo(file);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void illPlantInfoToDb(HttpServletRequest request){

        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
        PlantReportDao plantReportDao = applicationContext.getBean(IllPlantInfoDaoImpl.class);


        PlantReportInfo plantReportInfo = new PlantReportInfo();


        //int userId = ((Integer)request.getSession().getAttribute("userId")).intValue();
        String detail_about_address = request.getParameter("detail_about_address");
        String describe_about_plant = request.getParameter("describe_about_plant");
        String address_about_plant = request.getParameter("address_about_plant");

        plantReportInfo.setIllPlantImagesAddress(fileName);//前缀为request.getSession().getServletContext().getRealPath("/images/illPlantPic")+"/"+fileName
        plantReportInfo.setDetailAddressAboutPlant(detail_about_address);
        plantReportInfo.setDescribeAboutPlant(describe_about_plant);
        plantReportInfo.setAddressAboutReport(address_about_plant);
        plantReportInfo.setUserId(3);//注意修改为userId
        java.util.Date  date=new java.util.Date();
        plantReportInfo.setReportDate(new Date(date.getTime()));
        imagePath = "";
        fileName = "";
        plantReportDao.insertReportPlantInfo(plantReportInfo);
    }
}
