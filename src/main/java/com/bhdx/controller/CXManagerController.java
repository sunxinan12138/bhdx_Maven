package com.bhdx.controller;

import com.bhdx.models.CXDetail;
import com.bhdx.models.DelMessage;
import com.bhdx.models.OutCX;
import com.bhdx.tools.AjaxTool;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CXManagerController {
    ModelAndView mav = null;
    @Autowired
    private SqlSessionTemplate template;
    @RequestMapping("/doSelectCXByClass")
    @ResponseBody
    public void selectCXByClass(HttpServletRequest request, HttpServletResponse response){
        String classId = request.getParameter("classId");
       // System.out.println(classId);
        List<CXDetail> list = template.selectList("com.bhdx.DAO.CXManagerMapper.selectCXByClass",classId);
        /*for (CXDetail cxDetail : list){
            System.out.println(cxDetail);
        }*/
        AjaxTool ajaxTool = new AjaxTool(list,response);

    }
//根据编号删除证书详情
    @RequestMapping("/doDeleteCXById")
    @ResponseBody
    public void deleteCXById(HttpServletRequest request,HttpServletResponse response){
        String CXidStr = request.getParameter("CXid");
        int CXid = Integer.parseInt(CXidStr);
        //System.out.println(CXid);
        boolean result = false;
        int i = template.delete("com.bhdx.DAO.CXManagerMapper.deleteCXById",CXid);
        //System.out.println(i);
        if(i==1){
            result = true;
        }else{
            result = false;
        }
        AjaxTool ajaxTool = new AjaxTool(result,response);
    }

    //修改创新证书详情
    @RequestMapping("/doUpdateCXById")
    @ResponseBody
    public void updateCXById(HttpServletRequest request,HttpServletResponse response){
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String stuid = request.getParameter("stuid");
        String name = request.getParameter("name");
        String zsname = request.getParameter("zsname");
        String markStr = request.getParameter("mark");
        double mark = Double.parseDouble(markStr);
        String sort = request.getParameter("sort");
        String time = request.getParameter("time");
        String remark = request.getParameter("remark");
        String classid = request.getParameter("classId");

        CXDetail cxDetail = new CXDetail();
        cxDetail.setId(id);
        cxDetail.setStuid(stuid);
        cxDetail.setName(name);
        cxDetail.setZsname(zsname);
        cxDetail.setMark(mark);
        cxDetail.setTime(time);
        cxDetail.setSort(sort);
        cxDetail.setRemark(remark);
        cxDetail.setClassID(classid);
        try{
            int i = template.update("com.bhdx.DAO.CXManagerMapper.updateCXById",cxDetail);
            System.out.println(i);
            if (i > 0){
                request.getRequestDispatcher("managerCX/selectCXByClass.jsp").forward(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    //创新证书通过审核
    @RequestMapping("/doAccessCX")
    @ResponseBody
    public void accessCX(HttpServletRequest request,HttpServletResponse response){
        boolean result = false;
        String remark = request.getParameter("remark");//原因
        String status = request.getParameter("status");//是否通过审核的标记
        String CXidStr = request.getParameter("CXid");
        int CXid = Integer.parseInt(CXidStr);//创新id
        List<CXDetail> list = template.selectList("com.bhdx.DAO.CXManagerMapper.selectCXById",CXid);
        if (list.size() > 0){
                String stuid = list.get(0).getStuid();
                String name = list.get(0).getName();
                String zsname = list.get(0).getZsname();
                Double mark = list.get(0).getMark();
                String sort = list.get(0).getSort();
                if (status.equals("0")){//审核通过
                    OutCX outCX = new OutCX();
                    outCX.setStuid(stuid);
                    outCX.setName(name);
                    outCX.setZsname(zsname);
                    outCX.setMark(mark);
                    outCX.setSort(sort);
                    outCX.setCause(remark);
                    int m = template.insert("com.bhdx.DAO.CXManagerMapper.insertOutCX",outCX);
                    int n = template.delete("com.bhdx.DAO.CXManagerMapper.deleteCXById",CXid);
                   // System.out.println(n);
                    if (m > 0 && n > 0){
                       result = true;
                       AjaxTool ajaxTool = new AjaxTool(result,response);
                    }
                }else if(status.equals("1")){//审核不通过
                    //System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
                    String flag = "创新";
                    DelMessage delMessage = new DelMessage();
                    delMessage.setStuid(stuid);
                    delMessage.setZsname(zsname);
                    delMessage.setCause(remark);
                    delMessage.setFlag(flag);
                    //System.out.println(delMessage);
                  int n =  template.insert("com.bhdx.DAO.CXManagerMapper.insertDelMessage",delMessage);
                  int m = template.delete("com.bhdx.DAO.CXManagerMapper.deleteCXById",CXid);
                  if (n > 0 && m > 0){
                      //result = false;
                      AjaxTool ajaxTool = new AjaxTool(result,response);
                  }
                }
        }

    }

    //通过id查询证书详情  然后修改
    @RequestMapping("/doSelectCXById")
    @ResponseBody
    public void selectCXById(HttpServletRequest request,HttpServletResponse response){
        try{
            String CXidStr = request.getParameter("CXid");
            int CXid = Integer.parseInt(CXidStr);
            //System.out.println(CXid);
            List<CXDetail> list = template.selectList("com.bhdx.DAO.CXManagerMapper.selectCXById",CXid);
            request.setAttribute("myList", list);
            request.getRequestDispatcher("managerCX/UpdateCX.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
