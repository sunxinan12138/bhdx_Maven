package com.bhdx.controller;

import com.bhdx.models.OutCX;
import com.bhdx.models.OutZC;
import com.bhdx.models.Student;
import com.bhdx.tools.AjaxTool;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private SqlSessionTemplate template;

    //通过班级ID查询学生
    @RequestMapping("/doGetStuByCId")
    public void  getStuByCId(HttpServletRequest request , HttpServletResponse response)
    {
        String classId = request.getParameter("classId");//获得班级ID
        List<Student> stuList = template.selectList("com.bhdx.DAO.StudentManagementMapper.selectAllStudentById" , classId);
        new AjaxTool(stuList , response);
    }
    //通过学生ID查询证书
    @RequestMapping("/doGetCerByStuId")
    public void getCerByStuId( HttpServletRequest request , HttpServletResponse response )
    {
        String rd = request.getParameter("rd");//获得证书类型zc Or cx
        String stuId = request.getParameter("stuId");//获得学生ID
        List<OutCX> cxList = new ArrayList<OutCX>();
        List<OutZC> zcList = new ArrayList<OutZC>();

       if( rd.equals("zc") ) {
           zcList = template.selectList("com.bhdx.DAO.TeacherMapper.GetZCedByStuId" , stuId);

           new AjaxTool(zcList , response);
           }
       else{
           cxList = template.selectList("com.bhdx.DAO.TeacherMapper.GetCXedByStuId" , stuId);
          //System.out.println(cxList);
           new AjaxTool(cxList , response);
       }

    }
}
