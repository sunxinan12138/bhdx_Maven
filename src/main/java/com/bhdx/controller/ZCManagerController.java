package com.bhdx.controller;

import com.bhdx.models.DelMessage;
import com.bhdx.models.OutZC;
import com.bhdx.models.SubjectClass;
import com.bhdx.models.ZCDetail;
import com.bhdx.tools.AjaxTool;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.org.mozilla.javascript.internal.ast.TryStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ZCManagerController {
    @Autowired
    private SqlSessionTemplate template;

    //根据班级查询综测详情
    @RequestMapping("/doSelectZCByClass")
    @ResponseBody
    public void selectZCByClass(HttpServletRequest request, HttpServletResponse response) {
        String classId = request.getParameter("classId");
        //System.out.println(classId);
        List<ZCDetail> list = template.selectList("com.bhdx.DAO.ZCManagerMapper.getZCByClass",classId);
      /* for (ZCDetail zcDetail : list) {
            System.out.print(zcDetail);
        }*/
        AjaxTool ajaxTool = new AjaxTool(list, response);
    }

    //查询所有班级
    @RequestMapping("/doSelectClass")
    @ResponseBody
    public void selectAllClass(HttpServletResponse response) {
            List<SubjectClass> list = template.selectList("com.bhdx.DAO.ZCManagerMapper.selectAllClass");
          /* for (SubjectClass subjectClass : list) {
                System.out.println(subjectClass);
            }*/
            AjaxTool ajaxTool = new AjaxTool(list, response);
    }
    //根据编号删除综测详情
    @RequestMapping("/doDeleteZCById")
    @ResponseBody
    public void deleteZCById(HttpServletRequest request,HttpServletResponse response){
        boolean result = false;
        String ZCidStr = request.getParameter("ZCid");
        int ZCid = Integer.parseInt(ZCidStr);
        int i = template.delete("com.bhdx.DAO.ZCManagerMapper.deleteZCById",ZCid);
        if(i==1){
            result = true;
        }else{
            result = false;
        }
        AjaxTool ajaxTool = new AjaxTool(result,response);
    }

    //综测证书通过审核
    @RequestMapping("/doAccessZC")
    @ResponseBody
    public void accexZC(HttpServletRequest request,HttpServletResponse response){
        boolean result = false;
        String remark = request.getParameter("remark");//原因
        String status = request.getParameter("status");//是否通过审核的标记
        String ZCidStr = request.getParameter("ZCid");
        int ZCid = Integer.parseInt(ZCidStr);//综测id
       // System.out.println(ZCid);
        List<ZCDetail> list = template.selectList("com.bhdx.DAO.ZCManagerMapper.getZCById",ZCid);
       /* for (ZCDetail zcDetail : list){
            System.out.println(zcDetail);
        }*/
        if (list.size() > 0){
            String stuid = list.get(0).getStuid();
            String name = list.get(0).getName();
            String zsName = list.get(0).getZsName();
            double mark = list.get(0).getMark();
            String zk = list.get(0).getZk();
            if (status.equals("0")){  //表示审核通过
                OutZC outZC = new OutZC();
                outZC.setStuid(stuid);
                outZC.setName(name);
                outZC.setZsName(zsName);
                outZC.setMark(mark);
                outZC.setZk(zk);
                outZC.setCause(remark);
                //System.out.println(outZC);

                int m = template.insert("com.bhdx.DAO.ZCManagerMapper.insertOutZC",outZC);
                int n = template.delete("com.bhdx.DAO.ZCManagerMapper.deleteZCById",ZCid);
                if (m > 0 && n > 0){
                    result = true;
                    AjaxTool ajaxTool = new AjaxTool(result,response);
                }
            }else if (status.equals("1")){//审核未通过
                String flag = "综测";
                DelMessage delMessage = new DelMessage();
                delMessage.setStuid(stuid);
                delMessage.setZsname(zsName);
                delMessage.setCause(remark);
                delMessage.setFlag(flag);

                int n =  template.insert("com.bhdx.DAO.CXManagerMapper.insertDelMessage",delMessage);
                int m = template.delete("com.bhdx.DAO.ZCManagerMapper.deleteZCById",ZCid);
                if (n > 0 && m > 0){
                    //result = false;
                    AjaxTool ajaxTool = new AjaxTool(result,response);
                }
            }
        }

    }

    //根据编号查询综测详情
    @RequestMapping("/doSelectZCById")
    @ResponseBody
    public void selectZCById(HttpServletRequest request,HttpServletResponse response){
        try{
            String ZCidStr = request.getParameter("ZCid");
            int ZCid = Integer.parseInt(ZCidStr);
            //System.out.println(ZCid);
            List<ZCDetail> list = template.selectList("com.bhdx.DAO.ZCManagerMapper.getZCById",ZCid);
            request.setAttribute("myList", list);
            request.getRequestDispatcher("managerZC/UpdateZC.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //修改综测证书
    @RequestMapping("/doUpdateZCById")
    @ResponseBody
    public void updateZCById(HttpServletRequest request,HttpServletResponse response){
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String stuid = request.getParameter("stuid");
        String name = request.getParameter("name");
        String zsName = request.getParameter("zsname");
        String zk = request.getParameter("zk");
        String markStr = request.getParameter("mark");
        Double mark = Double.parseDouble(markStr);
        String remark = request.getParameter("remark");
        String time = request.getParameter("time");
        String classID = request.getParameter("classId");

        ZCDetail zcDetail = new ZCDetail();
        zcDetail.setId(id);
        zcDetail.setStuid(stuid);
        zcDetail.setName(name);
        zcDetail.setZsName(zsName);
        zcDetail.setMark(mark);
        zcDetail.setRemark(remark);
        zcDetail.setTime(time);
        zcDetail.setZk(zk);
        zcDetail.setClassID(classID);

        try{
            int i = template.update("com.bhdx.DAO.ZCManagerMapper.updateZCById",zcDetail);
            System.out.println(i);
            if (i>0){
                request.getRequestDispatcher("managerZC/selectZCByClass.jsp").forward(request,response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        /*try{
            int i = template.update("com.bhdx.DAO.ZCManagerMapper.updateZCById",zcDetail);
            System.out.println(i);
            if (i > 0){
                request.getRequestDispatcher("managerZC/selectZCByClass.jsp").forward(request, response);
            }
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }

}
