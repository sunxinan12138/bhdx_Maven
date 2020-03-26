package com.bhdx.controller;

import com.bhdx.models.Student;
import com.bhdx.tools.AjaxTool;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentManagementController {
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping("doSelectStudentByID")//根据学号查询学生
    public void SelectStudentByID(HttpServletRequest request,HttpServletResponse response){
//        ModelAndView modelAndView = new ModelAndView();
        System.out.println("我进来啦哈哈哈哈");
        String ID = request.getParameter("hhh");
        System.out.println(ID);
        List<Student> S = template.selectList("com.bhdx.DAO.StudentManagementMapper.SelectStudentByID",ID);
        for(Student students: S ){
            System.out.println(students);
        }
//        modelAndView.addObject("Student",S);
//        modelAndView.setViewName("StudentManagementTest");
        AjaxTool ajaxTool = new AjaxTool(S, response);
//        return modelAndView;
    }


}
