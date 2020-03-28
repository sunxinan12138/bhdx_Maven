package com.bhdx.DAO;

import com.bhdx.models.SubjectClass;
import com.bhdx.models.Student;
import java.util.List;

public interface StudentManagementMapper {
    List<Student> SelectStudentByID(String ID);//根据学生学号查询学生
    int AddNewclass(SubjectClass nclass);
}
