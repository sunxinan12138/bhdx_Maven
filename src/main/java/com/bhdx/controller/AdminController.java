package com.bhdx.controller;

import com.bhdx.models.*;
import com.bhdx.tools.AjaxTool;
import com.bhdx.tools.StringSplittingTool;
import com.google.gson.Gson;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class AdminController {
    ModelAndView mav = null;
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping("doSelectAdmin")//测试
    public void  SelectAdmin(){
        List<Admin> lAdmin = template.selectList("com.bhdx.DAO.AdminMapper.Select_Admin");
        for ( Admin admin : lAdmin ){
            System.out.println(admin);
        }
    }

    @RequestMapping("dologin")//管理员登录（待优化）
    public ModelAndView selectUser(HttpServletRequest request, HttpSession session)
    {
        ModelAndView andView = new ModelAndView();
        String ID = request.getParameter("ID");
        String Psd = request.getParameter("password");
        List <Admin> list = template.selectList("com.bhdx.DAO.AdminMapper.Select_Admin");
        boolean flag = false;
        for(int i=0;i<list.size();++i){
            Admin temp = list.get(i);
            if(temp.getID()!=null||temp.getPassword()!=null){
                if(temp.getID().equals(ID)&&temp.getPassword().equals(Psd)){//登陆成功
                    session.setAttribute("UserName",temp.getName());//把登录用户存储到session里
                    session.setAttribute("ID",ID);
                    andView.addObject("UserName",temp.getName());
                    if(temp.getMark().equals("CX")){
                        andView.setViewName("managerCX/manager");
                    }else if(temp.getMark().equals("ZC")){
                        andView.setViewName("managerZC/manager");
                    }else if(temp.getMark().equals("stu")){
                        andView.addObject("UserID",ID);
                        andView.addObject("UserName",temp.getName());
                        //跳回主页面
                        andView.setViewName("ClassAudit");
                    }
                    flag=true;
                    break;
                }
            }else if(temp.getID()==null||temp.getPassword()==null){
                System.out.println("账号或密码不能为空");
            }
            if(!flag){
                andView.setViewName("login");
            }
        }return andView;
    }
    //修改密码

    @RequestMapping("doChangePsw")
    public void ChangePsw(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        boolean result;
        String ID = session.getAttribute("ID").toString();
        String newPassword = request.getParameter("newPassword");
        Admin admin = new Admin();
        admin.setID(ID);
        admin.setPassword(newPassword);
        int i = template.update("com.bhdx.DAO.AdminMapper.ChangePsw",admin);
        if(i==1){
            result = true;
        }else{
            result = false;
        }
        AjaxTool ajaxTool = new AjaxTool(result,response);
    }
    @RequestMapping("selectClassByID")
    public void selectClassByID(HttpServletRequest request,HttpServletResponse response){
        String ID = request.getParameter("stuAdmin");
        SubjectClass subjectClass = template.selectOne("com.bhdx.DAO.AdminMapper.queryClass",ID);
        if (subjectClass==null){
            AjaxTool ajaxTool = new AjaxTool("error",response);
        }else{
            AjaxTool ajaxTool = new AjaxTool(subjectClass.getSubject(),response);
        }
    }
    //添加班级管理员
    @RequestMapping("doAddStuAdmin")
    public void addStuAdmin(HttpServletResponse response,HttpServletRequest request){
        String ID = request.getParameter("classID");
        StringSplittingTool splittingTool = new StringSplittingTool();
        boolean result;
        int max=1000000,min=1;
        String password = Integer.toString((int) (Math.random()*(max-min)+min));
        System.out.println(password);
        Admin admin = new Admin();
        admin.setID(ID);admin.setName(splittingTool.GetSubjectByClassID(ID));admin.setPassword(password);
        int i = template.insert("com.bhdx.DAO.AdminMapper.addStuAdmin",admin);
        if(i==1){
           result = true;
        }else{
           result = false;
        }
        AjaxTool ajaxTool = new AjaxTool(result,response);
    }

    @RequestMapping("doSelectZCByClassID")
    public void SelectZCByClassID (HttpServletRequest request, HttpServletResponse response){
        String ID = request.getParameter("ID");
        List <ZCDetail> zcDetails = template.selectList("com.bhdx.DAO.AdminMapper.SelectZCDetail",ID);
        AjaxTool ajaxTool = new AjaxTool(zcDetails,response);
    }
    @RequestMapping("doSelectCXByClassID")
    public void SelectCXByClassID (HttpServletRequest request, HttpServletResponse response){
        String ID = request.getParameter("ID");
        List <CXDetail> cxDetails = template.selectList("com.bhdx.DAO.AdminMapper.SelectCXDetail",ID);
        AjaxTool ajaxTool = new AjaxTool(cxDetails,response);
    }
}
