package com.bhdx.service;

import com.bhdx.models.Student;

import java.util.List;

public interface OutService {
    List<Student> outExcel(String classid, String path);

}
