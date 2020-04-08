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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;
import  com.bhdx.tools.StringSplittingTool;


@Controller
public class StudentManagementController {
    @Autowired
    private SqlSessionTemplate template;
    //根据学号查询学生
    @RequestMapping("doSelectStudentByID")
    public void SelectStudentByID(HttpServletRequest request,HttpServletResponse response){
        String ID = request.getParameter("hhh");
        System.out.println(ID);
        List<Student> S = template.selectList("com.bhdx.DAO.StudentManagementMapper.SelectStudentByID",ID);
        for(Student students: S ){
            System.out.println(students);
        }
        AjaxTool ajaxTool = new AjaxTool(S, response);
    }
    //查询所有班级
    @RequestMapping("doSelectAllClass")
    public void SelectAllClass(HttpServletResponse response){
        List<SubjectClass> slist = template.selectList("com.bhdx.DAO.StudentManagementMapper.SelectAllClass");
        AjaxTool ajaxTool = new AjaxTool(slist,response);
    }
    //添加班级
    @RequestMapping("doAddNewClass")
    public void AddNewClass(HttpServletRequest request,HttpServletResponse response){
        boolean result = false;
        String newClassID = request.getParameter("newClass");
        StringSplittingTool stringSplittingTool = new StringSplittingTool();
        String newClass = stringSplittingTool.GetSubjectByClassID(newClassID);
        SubjectClass nclass = new SubjectClass();
        nclass.setId(newClassID);
        nclass.setSubject(newClass);
        boolean b = newClass.startsWith("e");
        if(b == false){
            template.insert("com.bhdx.DAO.StudentManagementMapper.AddNewclass",nclass);
            result = true;
        }else{
            result = false;
        }
        AjaxTool ajaxTool = new AjaxTool(result,response);
    }

    //修改班级
    @RequestMapping("commitUpdateClass")
    public void updateClass(HttpServletRequest request,HttpServletResponse response){
        boolean result;
        String sAndsid = request.getParameter("sAndsid");
        String[] s = sAndsid.split("_");
        SubjectClass subjectClass = new SubjectClass();
        subjectClass.setId(s[0]);
        subjectClass.setSubject(s[1]);
        System.out.println(subjectClass);
        int i = template.update("com.bhdx.DAO.StudentManagementMapper.updateClass",subjectClass);
        if(i == 1){
            result = true;
        }else{
            result = false;
        }
        AjaxTool ajaxTool = new AjaxTool(result,response);
    }
        //删除班级
    @RequestMapping("doDeleteClass")
    public void deleteClassByID(HttpServletResponse response,HttpServletRequest request){
        boolean result;
        String sid = request.getParameter("sid");
        System.out.println(sid);
        int i = template.delete("com.bhdx.DAO.StudentManagementMapper.deleteClassByID",sid);
        int j = template.delete("com.bhdx.DAO.StudentManagementMapper.deleteStudentByID",sid);
        int k = template.delete("com.bhdx.DAO.StudentManagementMapper.deleteCXDetailByID",sid);
        int m = template.delete("com.bhdx.DAO.StudentManagementMapper.deleteZCDetailByID",sid);
        if(i+j+k+m<4){
            result = false;
        }else{
            result = true;
        }
        AjaxTool ajaxTool = new AjaxTool(result,response);
    }
    @RequestMapping("doUpdateStudentClass")
    public void updateStudentClass(HttpServletResponse response,HttpServletRequest request){
        boolean result = false;
        String ID = request.getParameter("stuid");
        String classId = request.getParameter("classId");
        Map<String, String> params = new HashMap<String, String>();
        params.put("ID", ID);
        params.put("classId", classId);
        int i = template.update("com.bhdx.DAO.StudentManagementMapper.updateStudentClass",params);
        if(i == 1){
            result = true;
        }else{
            result = false;
        }
        AjaxTool ajaxTool = new AjaxTool(result,response);
    }
    //根据班级id查询班级所有学生
    @RequestMapping("doselectAllStudentById")
    public ModelAndView selectAllStudentById (HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String subjectId = request.getParameter("sid");
        System.out.println(subjectId);
        List<Student> studentList = template.selectList("com.bhdx.DAO.StudentManagementMapper.selectAllStudentById",subjectId);
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("SM_test");
        return modelAndView;
    }
}
