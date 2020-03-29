package com.bhdx.controller;

import com.bhdx.models.SubjectClass;
import com.bhdx.models.Student;
import com.bhdx.tools.AjaxTool;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import  com.bhdx.tools.StringSplittingTool;


@Controller
public class StudentManagementController {
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping("doSelectStudentByID")//根据学号查询学生
    public void SelectStudentByID(HttpServletRequest request,HttpServletResponse response){
        String ID = request.getParameter("hhh");
        System.out.println(ID);
        List<Student> S = template.selectList("com.bhdx.DAO.StudentManagementMapper.SelectStudentByID",ID);
        for(Student students: S ){
            System.out.println(students);
        }
        AjaxTool ajaxTool = new AjaxTool(S, response);
    }
    @RequestMapping("doSelectAllClass")
    public void SelectAllClass(HttpServletResponse response){
        List<SubjectClass> slist = template.selectList("com.bhdx.DAO.StudentManagementMapper.SelectAllClass");
        for(SubjectClass subjectClass : slist){
            System.out.println(subjectClass);
        }
        AjaxTool ajaxTool = new AjaxTool(slist,response);
    }
    //添加班级
    @RequestMapping("doAddNewClass")
    public void AddNewClass(HttpServletRequest request,HttpServletResponse response){
        boolean result = false;
        String newClassID = request.getParameter("newClass");
        StringSplittingTool stringSplittingTool = new StringSplittingTool();
        String newClass = stringSplittingTool.GetSubjectByClassID(newClassID);;
        SubjectClass nclass = new SubjectClass();
        nclass.setId(newClassID);
        nclass.setSubject(newClass);
        System.out.println(nclass.getId() + " " + nclass.getSubject());
        int i = template.insert("com.bhdx.DAO.StudentManagementMapper.AddNewclass",nclass);
        if (i == 1){
            result = true;
        }else  if( i == -1){
            result = false;
        }
        AjaxTool ajaxTool = new AjaxTool(result,response);
    }
}
