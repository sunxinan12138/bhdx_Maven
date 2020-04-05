package com.bhdx.controller;

import com.bhdx.models.SubjectClass;
import com.bhdx.models.ZCDetail;
import com.bhdx.tools.AjaxTool;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ZCManagerController {
    @Autowired
    private SqlSessionTemplate template;

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

    @RequestMapping("/doSelectClass")
    @ResponseBody
    public void selectAllClass(HttpServletResponse response) {
            List<SubjectClass> list = template.selectList("com.bhdx.DAO.ZCManagerMapper.selectAllClass");
          /* for (SubjectClass subjectClass : list) {
                System.out.println(subjectClass);
            }*/
            AjaxTool ajaxTool = new AjaxTool(list, response);
    }
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

    //修改综测证书信息
    @RequestMapping("/doUpdateZCById")
    @ResponseBody
    public void updateZCById(HttpServletRequest request,HttpServletResponse response){
        String ZCid = request.getParameter("ZCid");

    }
}
