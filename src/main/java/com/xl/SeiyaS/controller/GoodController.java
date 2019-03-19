package com.xl.SeiyaS.controller;

import com.xl.SeiyaS.common.GenericController;
import com.xl.SeiyaS.entity.Goods;
import com.xl.SeiyaS.entity.User;
import com.xl.SeiyaS.service.GoodService;
import com.xl.SeiyaS.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/good")
public class GoodController extends GenericController {

    private Logger logger = Logger.getLogger(GoodController.class);

    @Resource
    private GoodService goodService;

    @RequestMapping(value = "/getGoodList",method = {RequestMethod.GET})
    public void getUserById(HttpServletRequest request, HttpServletResponse response) {
        List<Goods> list = goodService.getGoodList();
        renderSuccessString(response,list);
    }

    @RequestMapping(value = "/addGoods",method = {RequestMethod.GET})
    @ResponseBody
    public String addGoods(@RequestParam("files") CommonsMultipartFile files[],HttpServletRequest request,HttpServletResponse response){
        List<String> list = new ArrayList<String>();
        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录

        /*File f = new File(path);
        if (!f.exists())
            f.mkdirs();

        for (int i = 0; i < files.length; i++) {
            // 获得原始文件名
            String fileName = files[i].getOriginalFilename();
            System.out.println("原始文件名:" + fileName);
            // 新文件名
            String newFileName = UUID.randomUUID() + fileName;
            if (!files[i].isEmpty()) {
                try {
                    FileOutputStream fos = new FileOutputStream(path
                            + newFileName);
                    InputStream in = files[i].getInputStream();
                    int b = 0;
                    while ((b = in.read()) != -1) {
                        fos.write(b);
                    }
                    fos.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("上传图片到:" + path + newFileName);
            list.add(path + newFileName);

        }*/
        // 保存文件地址，用于JSP页面回显
        //renderSuccessString(response,null);
        return path;
    }


}
