package com.bhdx.controller;

import com.bhdx.models.*;
import com.bhdx.service.AddZsService;
import com.bhdx.service.StudentService;
import com.bhdx.tools.AjaxTool;
import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddZsController {
    ModelAndView mav = null;
    @Autowired
    private AddZsService addZsService;
    @Autowired
    private StudentService studentService;

    //综测
    @RequestMapping("/doaddZC")
    @ResponseBody
    public void doaddZs(HttpServletRequest request, HttpServletResponse response, ZCDetail zcDetail, @RequestParam("file") MultipartFile file) {
        boolean btn = false;
        System.out.println("添加");
        try {

            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String originalName = file.getOriginalFilename();
            originalName = originalName.substring(originalName.length() - 4);
            String imgName = "imgZC" + originalName;
            /**
             * detail: "国家级"
             * mark: "12"
             * remark: "请二位发我QQ"
             * stuid: "220123"
             * time: "2019-2020"
             * zsname: "1去去去"
             * zk：折扣
             */
            String detail = request.getParameter("detail");
            String remark = request.getParameter("remark");
            String mark = request.getParameter("mark");
            String stuid = request.getParameter("stuid");
            String zsname = request.getParameter("zsname");
            String zk = request.getParameter("zk");
            String time = request.getParameter("time");
            double markdou = Double.parseDouble(mark);
            //System.out.println(markdou);
            zcDetail.setStuid(stuid);
            zcDetail.setRemark(remark);
            zcDetail.setTime(time);
            zcDetail.setZsName(zsname);
            zcDetail.setMark(markdou);
            zcDetail.setZk(zk);
            zcDetail.setImgName(imgName);
            zcDetail.setImg(file.getBytes());
            System.out.println(zcDetail);
            btn = addZsService.zcadd(zcDetail);
            System.out.println(btn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new AjaxTool(btn, response);
        }
    }

    //  创新
    @RequestMapping("/doaddCX")
    @ResponseBody
    public void doaddCx(HttpServletRequest request, HttpServletResponse response, CXDetail cxDetail, @RequestParam("file") MultipartFile file) {
        boolean btn = false;

        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String iname = file.getOriginalFilename();
            iname = iname.substring(iname.length() - 4);
            String imgName = "imgCX" + iname;
            cxDetail.setImgName(imgName);
            cxDetail.setImg(file.getBytes());
            System.out.println(cxDetail);
            btn = addZsService.cxadd(cxDetail);
            System.out.println(btn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new AjaxTool(btn, response);
        }
    }

    @RequestMapping("/doaddZAC")
    @ResponseBody
    public void doaddZAC(HttpServletRequest request, HttpServletResponse response, ZCDetail zcDetail, CXDetail cxDetail, @RequestParam("file") MultipartFile file) {
        boolean btn = false;
        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            String stuidAN = request.getParameter("stuidAname");
            String[] a = stuidAN.split("-");
            zcDetail.setName(a[1]);
            zcDetail.setStuid(a[0]);
            cxDetail.setName(a[1]);
            cxDetail.setStuid(a[0]);
            String classId = studentService.findStuidByClassId(a[0]);
            System.out.println(classId);
            cxDetail.setClassID(classId);
            zcDetail.setClassID(classId);
            String zsname = request.getParameter("zsname");
            String markzc = request.getParameter("markzc");
            double markzcd = Double.parseDouble(markzc);
            String markcx = request.getParameter("markcx");
            double markcxd = Double.parseDouble(markcx);
            String iname = file.getOriginalFilename();
            iname = iname.substring(iname.length() - 4);
            String imgCXName = "imgCX" + iname;
            String imgZCName = "imgZC" + iname;
            zcDetail.setZsName(zsname);
            zcDetail.setMark(markzcd);
            zcDetail.setImgName(imgZCName);
            zcDetail.setImg(file.getBytes());
            cxDetail.setMark(markcxd);
            cxDetail.setImgName(imgCXName);
            cxDetail.setImg(file.getBytes());
            System.out.println(cxDetail);
            System.out.println(zcDetail);
            //综测添加
            if (zcDetail.getMark() != 0) {
                btn = addZsService.zcadd(zcDetail);
            }
            //创新添加
            if (cxDetail.getMark() != 0) {
                btn = addZsService.cxadd(cxDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new AjaxTool(btn, response);
        }
    }

    //管理员添加证书创新
    @RequestMapping("/doAddMark")
    public void doAddMark(HttpServletRequest request, HttpServletResponse response, OutCX outCX) {
        boolean a = false;
        a = addZsService.addMark(outCX);
        new AjaxTool(a, response);
    }


    //管理员添加证书创新
    @RequestMapping("/doAddMarkZC")
    public void doAddMarkZC(HttpServletRequest request, HttpServletResponse response, OutZC outZC) {
        outZC.setZk("打折");
        boolean a = false;
        a = addZsService.addMarkZC(outZC);
        new AjaxTool(a, response);
    }

    //批量添加学生
    @RequestMapping("/addStudentMore")
    public void addStudentMore(HttpServletRequest request, HttpServletResponse response, Student student, @RequestParam("file") MultipartFile file) {
        List<Student> studentList = new ArrayList<>();
        String classid = file.getOriginalFilename();
        classid = classid.substring(0, classid.indexOf("."));
        try {
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            int lenth = sheet.getLastRowNum();//最后一行
            for (int i = 0; i < lenth; i++) {
                student = new Student();
                Row row = sheet.getRow(i);
                short lastCell = row.getLastCellNum();
                for (int j = 0; j < lastCell; j++) {
                    Cell cell = row.getCell(j);
                    Object value = cell.getStringCellValue();
                    if (j == 0) {
                        String id = value.toString();
                        student.setId(id);
                        student.setPsw(id.substring(4, 12));
                    } else if (j == 1) {
                        student.setName(value.toString());
                    }
                }
                student.setClassID(classid);
                studentList.add(i, student);
                student = null;
            }
            System.out.println(studentList);
            if (studentList.size() != 0) {
                System.out.println("添加");
                System.out.println(studentList);
                int a = studentService.addStudentMore(studentList);
                new AjaxTool("成功", response);
            } else {
                new AjaxTool("失败", response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

