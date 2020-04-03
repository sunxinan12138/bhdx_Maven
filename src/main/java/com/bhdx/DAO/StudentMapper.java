package com.bhdx.DAO;

import com.bhdx.models.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    public List<Student> findAll();

    public List<Student> selectInfo(String id);

    public void changepsw(@Param("map") Map map);

    public int changemessage(Student student);

    public void addStudent(Student stu);

    public void getStudentID(String condition);//获取最大学号

    public void deleteStudent(String ID);

    String findClassIdBystuid(String stuid);
}
