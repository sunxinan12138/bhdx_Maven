package com.bhdx.service;

import com.bhdx.models.OutCX;
import com.bhdx.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public List<Student> findStudent();

    //通过学号找班级
    public String findStuidByClassId(String stuid);

    public void changepsw(Map map);

    boolean changemessage(Student student);

    //批量添加学生
    int addStudentMore(List<Student> students);


}
