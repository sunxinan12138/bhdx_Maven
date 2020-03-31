package com.bhdx.DAO;

import com.bhdx.models.Student;

import java.util.List;

public interface TeacherMapper {

    List<Student> GetStuByCId(String classId);//通过班级ID查询学生信息
}
