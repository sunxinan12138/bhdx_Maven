package com.bhdx.DAO;

import com.bhdx.models.SubjectClass;
import com.bhdx.models.Student;
import java.util.List;

public interface StudentManagementMapper {
    List<Student> SelectStudentByID(String ID);//根据学生学号查询学生
    int AddNewclass(SubjectClass nclass);//添加新班级
    List<SubjectClass> SelectAllClass();//查询所有班级
    int deleteClassByID(String sid);//根据班级ID删除班级
    int updateClass(SubjectClass subjectClass);//根据班级ID修改班级
}
