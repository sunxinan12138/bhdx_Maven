package com.bhdx.service;

import com.bhdx.models.Student;

import java.util.List;

public interface OutService {
    //创新导出
    List<Student> outExcel(String classid, String path);

}
