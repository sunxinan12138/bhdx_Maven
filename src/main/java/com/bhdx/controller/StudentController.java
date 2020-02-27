package com.bhdx.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.bhdx.models.Student;
import com.bhdx.service.StudentService;
import com.google.gson.Gson;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    ModelAndView mav = null;
    @Autowired
    private SqlSessionTemplate template;
    //注入服务
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String showStudent(Model model) {
        System.out.println("hahaS");
        List<Student> studentList = studentService.findStudent();
        model.addAttribute("student", studentList);
        //返回视图
        return "student";
    }

    // ajax查询订单
    @RequestMapping("/doSelectStu")
    @ResponseBody
    public void doSelectStu(Student s, HttpServletRequest request, HttpServletResponse response) {
        /* System.out.println("ajax!");*/
        boolean log = false;
        boolean pswvoolean = false;
        Object objid = request.getParameter("stuid");
        String id = objid.toString();
        Object psw = request.getParameter("psw");
        List<Student> slist = new ArrayList<>();
        slist = template.selectList("com.bhdx.DAO.StudentMapper.selectInfo", id);
        if (slist.size() != 0) {
            pswvoolean = psw.equals(slist.get(0).getPsw());
        }
        try {
            response.setHeader("Content-Type", "text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            if (pswvoolean) {
                Gson g = new Gson();
                String value = g.toJson(slist);
                //System.out.println(slist);

               // response.setCharacterEncoding("UTF-8");
               // System.out.println(value);
                out.print(value);// 返给ajax请求
            } else {
                out.print(log);
            }
            // 刷新
            out.flush();
            // 关闭
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

}
