package com.bhdx.DAO;

import com.bhdx.models.*;

import java.util.List;

public interface AdminMapper {
   List<Admin> Select_Admin();//查询管理员
   List<CXDetail> SelectCXDetail(String classID);//通过班级管理员ID查询创新证书细节
   List<ZCDetail> SelectZCDetail(String classID);//通过班级管理员ID查询综测证书细节
   List<Student>  selectStudentByClassid(String classID);//查询班级所有学生
   void ChangePsw(Admin admin);//修改密码
   SubjectClass queryClass(String ID);//根据ID查询班级
   int addStuAdmin(Admin admin);//添加班级管理员
}

