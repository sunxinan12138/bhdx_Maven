package com.bhdx.controller;

import com.bhdx.models.Admin;
import com.bhdx.models.CXDetail;
import com.bhdx.tools.AjaxTool;
import com.bhdx.tools.StringSplittingTool;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
                    HttpSession sessionl = request.getSession();
                    session.setAttribute("UserName",temp.getName());//把登录用户存储到session里
                    session.setAttribute("ID",ID);
                    StringSplittingTool classID = new StringSplittingTool();
                    if(temp.getMark().equals("CX")){
                        //拆分出专业班级代号，传到数据库进行查询
//                    List <CXDetail> cxDetails = template.selectList("com.bhdx.DAO.AdminMapper.SelectCXDetail",classID.GetSubjectID(temp.getID()));
//                    andView.addObject("cxDetails",cxDetails);//把查询出来的放到zsdetail里传到前端
                        andView.addObject("UserName",temp.getName());
                        //跳回主页面
                        andView.setViewName("managerCX/test");
                    }else if(temp.getMark().equals("ZC")){
                        //拆分出专业班级代号，传到数据库进行查询
                        andView.addObject("UserName",temp.getName());
                        //跳回主页面
                        andView.setViewName("check");
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


}
