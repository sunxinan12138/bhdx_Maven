package com.bhdx.DAO;

import com.bhdx.models.Admin;
import com.bhdx.models.CXDetail;

import java.util.List;

public interface AdminMapper {
   List<Admin> Select_Admin();//查询管理员
   List<CXDetail> SelectCXDetail(String classID);//通过班级管理员ID查询证书细节
}
