package com.bhdx.controller;

import com.bhdx.models.OutCX;
import com.bhdx.models.Student;
import com.bhdx.service.OutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class OutExcelController {

    @Autowired
    private OutService outService;

    @RequestMapping("/doOutExcel")
    public void outExcel(HttpServletRequest request, HttpServletResponse response, String classId, String path, String className) {
        System.out.println(classId);
        System.out.println(path);
        path = path + "\\" + className + "综测" + classId + ".xlsx";
        System.out.println(path);
        List<Student> list = outService.outExcel(classId, path);
    }
}
