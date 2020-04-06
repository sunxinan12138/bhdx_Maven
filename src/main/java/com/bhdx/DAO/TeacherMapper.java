package com.bhdx.DAO;

import com.bhdx.models.OutCX;
import com.bhdx.models.OutZC;
import com.bhdx.models.Student;

import java.util.List;

public interface TeacherMapper {

    List<OutCX> GetCXedByStuId(String stuId);//通过学生ID获得已审核的创新证书信息

    List<OutZC> GetZCedByStuId(String stuId);//通过学生ID获得已审核的综测证书信息
}
