package com.bhdx.controller;

import com.bhdx.models.Student;
import com.bhdx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {

    //注入服务
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String showStudent(Model model) {
        List<Student> studentList = studentService.findStudent();
        model.addAttribute("student", studentList);
        //返回视图
        return "student";
    }
}
