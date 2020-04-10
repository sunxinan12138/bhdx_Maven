package com.bhdx.DAO;

import com.bhdx.models.Student;

import java.util.List;

public interface OutExcelMapper {
    //安班级导出证书
    List<Student> selectOutCx(String classId);

    List<Student> selectOutZc(String classId);
}
