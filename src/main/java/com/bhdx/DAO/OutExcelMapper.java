package com.bhdx.DAO;

import com.bhdx.models.Student;

import java.util.List;

public interface OutExcelMapper {
    List<Student> selectOutCx(String classId);
}
