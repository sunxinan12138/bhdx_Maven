package com.bhdx.controller;

import com.bhdx.models.Admin;
import com.bhdx.models.CXDetail;
import com.bhdx.tools.StringSplittingTool;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
//                    HttpSession sessionl = request.getSession();
//                    session.setAttribute("UserName",temp.getName());//把登录用户存储到session里
                    StringSplittingTool classID = new StringSplittingTool();
                    //拆分出专业班级代号，传到数据库进行查询
                    List <CXDetail> cxDetails = template.selectList("com.bhdx.DAO.AdminMapper.SelectCXDetail",classID.GetSubjectID(temp.getID()));
                    andView.addObject("cxDetails",cxDetails);//把查询出来的放到zsdetail里传到前端
                    andView.addObject("UserName",temp.getName());
//                    System.out.println( session.getAttribute("UserName"));
                    //跳回主页面
                    andView.setViewName("check");
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


}
