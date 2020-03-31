package com.bhdx.controller;

import com.bhdx.models.Student;
import com.bhdx.tools.AjaxTool;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private SqlSessionTemplate template;

    //通过班级ID查询学生
    @RequestMapping("/doGetStuByCId")
    public void  getStuByCId(HttpServletRequest request , HttpServletResponse response)
    {
        String classId = request.getParameter("classId");//获得班级ID
        List<Student> stuList = template.selectList("com.bhdx.DAO.TeacherMapper.GetStuByCId" , classId);
        new AjaxTool(stuList , response);
    }
}
