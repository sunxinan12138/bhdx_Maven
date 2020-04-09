package com.bhdx.controller;

import com.bhdx.models.Student;
import com.bhdx.models.SubjectClass;
import com.bhdx.service.StudentService;
import com.bhdx.tools.AjaxTool;
import com.bhdx.tools.StringSplittingTool;
import com.google.gson.Gson;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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

    // ajax查询
    @RequestMapping("/doSelectStu")
    @ResponseBody
    public void doSelectStu(Student s, HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("ajax!");
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
//                System.out.println("session");
                // request.getSession().setAttribute("assTel", slist.get(0).getId());
                request.getSession().setAttribute("stuid", slist);
                String sessionId = request.getSession().getId() + "--" + slist.get(0).getId() + "--" + slist.get(0).getName();
                System.out.println(sessionId);
                Gson g = new Gson();
                String value = g.toJson(sessionId);
                // System.out.println(request.getSession().getAttribute("stuid"));
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

    @RequestMapping("/dochangeStu")
    @ResponseBody
    public void dochangeStu(Student s, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> pswmap = new HashMap<>();
        boolean btn = false;
        String stuid = request.getParameter("stuid");
        String pawend = request.getParameter("pswend");
        pswmap.put(stuid, pawend);
        //更改数据库
        studentService.changepsw(pswmap);
        System.out.println(stuid + "-" + pawend);
        new AjaxTool(btn, response);
    }

    @RequestMapping("/doselectall")
    @ResponseBody
    public void doselectall(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        System.out.println(id);
        String classid = "";
        List<Student> slist = template.selectList("com.bhdx.DAO.StudentMapper.selectInfo", id);
//        if (slist.size() != 0) {
//            classid = slist.get(0).getClassID();
//            //查找班级
//        }
        new AjaxTool(slist, response);
    }

    @RequestMapping("/changemessage")
    @ResponseBody
    public void changemessage(HttpServletRequest request, HttpServletResponse response, Student student) {
        boolean btn = false;
        btn = studentService.changemessage(student);
        new AjaxTool(btn, response);
    }

    @RequestMapping("/doAddStudent")
    public void addStudent(Student stu, HttpServletRequest request, HttpServletResponse response) {
        String id = stu.getId();
        id = id + "成功";
        String classId = StringSplittingTool.GetSubjectID(id);
        stu.setClassID(classId);
        String psw = id.substring(4, 12);
        stu.setPsw(psw);
        boolean result = false;
        try {
            int i = template.insert("com.bhdx.DAO.StudentMapper.addStudent", stu);
            if (i == 1) {
                result = true;
                AjaxTool ajaxTool = new AjaxTool(id, response);
            } else {
                result = false;
                AjaxTool ajaxTool = new AjaxTool(result, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/doGetStudentID")
    public void getStudentID(HttpServletRequest request, HttpServletResponse response) {
        String condition = request.getParameter("condition");
        System.out.println(condition);
        String ID = template.selectOne("com.bhdx.DAO.StudentMapper.getStudentID", condition);
        System.out.println(ID);
        String sid = null;
        if (ID != null) {
            sid = ID.substring(ID.length() - 2, ID.length());
        } else {
            sid = "none";
        }
        System.out.println(sid);
        response.setHeader("Content-Type", "text/html; charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(sid);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/doGetStudentClass")
    public void getStudentClass(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        System.out.println(id);
        String SubjectID = id.substring(2, 10);
        String className = StringSplittingTool.GetSubject(id);
        SubjectClass subjectClass = new SubjectClass();
        subjectClass.setId(SubjectID);
        subjectClass.setSubject(className);
        System.out.println(className);
        List<SubjectClass> list = new ArrayList<>();
        list.add(subjectClass);
        for (SubjectClass students : list) {
            System.out.println(students);
        }
        AjaxTool ajaxTool = new AjaxTool(list, response);
    }

    @RequestMapping("doDeleteStudent")
    public void deleteStudent(HttpServletResponse response, HttpServletRequest request) {
        boolean result = false;
        String ID = request.getParameter("hhh");
        int i = template.delete("com.bhdx.DAO.StudentMapper.deleteStudent", ID);
        if (i == 1) {
            result = true;
        } else {
            result = false;
        }
        AjaxTool ajaxTool = new AjaxTool(result, response);
    }
}
