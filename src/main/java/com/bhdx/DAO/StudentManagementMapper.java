package com.bhdx.DAO;

import com.bhdx.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentManagementMapper {
    List<Student> SelectStudentByID(String ID);//根据学生学号查询学生
   /* List<Student> psdCheck(Map<String, String> params);
    void changePsd(Map<String, String> params);
    List<Student> IDCheck(String ID);*/
}
