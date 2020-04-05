package com.bhdx.controller;

import com.bhdx.models.OutCX;
import com.bhdx.models.Student;
import com.bhdx.service.OutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class OutExcelController {

    @Autowired
    private OutService outService;

    // 导出创新表
    @RequestMapping("/doOutExcel")
    public ModelAndView outExcel(HttpServletRequest request, HttpServletResponse response, String classId, String path, String className) {
        ModelAndView modelAndView = new ModelAndView();
        path = path + "\\" + className + "综测" + classId + ".xlsx";
        List<Student> list = outService.outExcel(classId, path);
        int lenth = list.size();
        modelAndView.setViewName("sucess");
        request.setAttribute("lenth", lenth);
        return modelAndView;
    }
}
