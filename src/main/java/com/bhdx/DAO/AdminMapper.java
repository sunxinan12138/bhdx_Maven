package com.bhdx.DAO;

import com.bhdx.models.Admin;
import com.bhdx.models.ZsDetail;

import java.util.List;

public interface AdminMapper {
   List<Admin> Select_Admin();//查询管理员
   List<ZsDetail> SelectZsDetail();//查询证书细节
}
