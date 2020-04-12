package com.bhdx.controller;

import com.bhdx.models.OutCX;
import com.bhdx.models.Student;
import com.bhdx.service.OutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class OutExcelController {

    @Autowired
    private OutService outService;

    // 导出创新表
    @RequestMapping("/doOutExcel")
    public ModelAndView outExcel(HttpServletRequest request, HttpServletResponse response, String classId, String className) {
        String contextPath = request.getContextPath();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        ModelAndView modelAndView = new ModelAndView();
        String path = realPath + "excel" + "/" + className + "创新" + classId + ".xlsx";
        String name = className + "创新" + classId + ".xlsx";
        List<Student> list = outService.outExcel(classId, path);
        int lenth = list.size();
        //跳转sucess。jsp
        modelAndView.setViewName("sucess");
        //int lenth = 0;
        request.setAttribute("lenth", lenth);
        request.setAttribute("name", name);
        return modelAndView;
    }

    // 导出创综测
    @RequestMapping("/doOutExcelZC")
    public ModelAndView doOutExcelZC(HttpServletRequest request, HttpServletResponse response, String classId, String className) {
        //String contextPath = request.getContextPath();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        ModelAndView modelAndView = new ModelAndView();
        String  path = realPath  + "excel" + "/" + className + "综测" + classId + ".xlsx";
        System.out.println(path);
        String name = className + "综测" + classId + ".xlsx";
        List<Student> list = outService.outExcelZC(classId, path);
        int lenth = list.size();
        //跳转sucess。jsp
        modelAndView.setViewName("sucess");
        request.setAttribute("lenth", lenth);
        request.setAttribute("name", name);
        return modelAndView;
    }

    //下载表格
    @RequestMapping("/downCX")
    public void downCX(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = request.getParameter("fileName");
            fileName = new String(fileName.getBytes("ISO-8859-1"), "utf-8");
            response.setCharacterEncoding("utf-8");
            String filePath = request.getSession().getServletContext().getRealPath("excel/" + fileName);
            System.out.println(filePath);
            //输出流
            FileInputStream inputStream = new FileInputStream(filePath);
            ServletOutputStream servletOutputStream = response.getOutputStream();
            fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            int len = 1;
            byte[] b = new byte[1024];
            while ((len = inputStream.read(b)) != -1) {
                servletOutputStream.write(b, 0, len);
            }
            servletOutputStream.close();
            inputStream.close();
            boolean delete_flag = false;
            //删除
            File deleteFile = new File(filePath);
            if (deleteFile.exists() && deleteFile.isFile() && deleteFile.delete()) {
                delete_flag = true;
            } else {
                delete_flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
