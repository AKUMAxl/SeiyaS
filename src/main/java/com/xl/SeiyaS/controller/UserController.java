package com.xl.SeiyaS.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.xl.SeiyaS.common.CommonPath;
import com.xl.SeiyaS.common.GenericController;
import com.xl.SeiyaS.entity.User;
import com.xl.SeiyaS.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController extends GenericController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserService userService;

    //返回jsp视图展示
    @RequestMapping(value = "/getUserModel",method = RequestMethod.GET)
    public ModelAndView getUsers1(@RequestParam Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        //调用service方法得到用户列表
        List<User> users = userService.getUsers(userId);
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("users",users);
        //设置响应的jsp视图
        modelAndView.setViewName("getUsers");
        logger.info("===============================成功查询用户列表！");
        return modelAndView;
    }
    //返回json格式数据，形式1
    /*@RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public List getUsers2(@RequestParam Integer userId, HttpServletRequest request, HttpServletResponse response) {
        //调用service方法得到用户列表
        List<User> users = userService.getUsers(userId);
        logger.info("===============================成功查询用户列表！");
        return users;
    }*/
    //返回json格式数据，形式2（自定义了返回的格式）
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public void getUsers3(@RequestParam Integer userId, HttpServletRequest request, HttpServletResponse response) {
        //调用service方法得到用户列表
        List<User> users = userService.getUsers(userId);
        logger.info("===============================成功查询用户列表！");
        renderSuccessString(response, users);
    }

    @RequestMapping(value = "/uploadPic",method = RequestMethod.POST)
    public ModelAndView uploadPic(HttpServletRequest request) throws IllegalStateException,IOException{

        System.out.println("当前操作系统："+System.getProperties().getProperty("os.name"));
        //创建文件夹
        File file1 = new File(CommonPath.BASE_URI+"uploadPic/");
        boolean ok = false;
        if (!file1.exists()){
            ok = file1.mkdir();
        }
        if (ok){
            System.out.println("文件夹创建成功");
        }else {
            System.out.println("文件夹已存在或创建失败");
        }

        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)){
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
                String a = request.getParameter("no");
            System.out.println("提交文件时的其他字段NO:"+a);
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    //String path="E:/uploadPic/"+file.getOriginalFilename();
                    String path=CommonPath.BASE_URI+"uploadPic/"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }

            }
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("上传用时："+String.valueOf(endTime-startTime)+"ms");

        //设置响应的jsp视图
        ModelAndView modelAndView = new ModelAndView();
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("users","123");
        modelAndView.setViewName("uploadsuccess");
        logger.info("===============================上传图片成功！");
        return modelAndView;
    }

    @RequestMapping(value = "/getQRcode",method = RequestMethod.GET)
    @ResponseBody
    public void getQRcode(HttpServletRequest request,HttpServletResponse response){
        String filePath = "E://";
        String fileName = "zxing.png";
        String content = "测试zxing生成二维码";
        int width = 300; // 图像宽度
        int height = 300; // 图像高度
        String format = "png";// 图像类型
        
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
            Path path = FileSystems.getDefault().getPath(filePath, fileName);
            MatrixToImageWriter.writeToPath(bitMatrix, format, path);// 输出图像
        } catch (IOException e) {
            e.printStackTrace();
        }catch (WriterException e){
            e.printStackTrace();
        }
        System.out.println("输出成功.");
        //renderSuccessString(response, users);
    }
}
