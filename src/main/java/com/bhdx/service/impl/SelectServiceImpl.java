package com.bhdx.service.impl;

import com.bhdx.models.*;
import com.bhdx.service.SelectService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {
    @Autowired
    private SqlSessionTemplate template;


    //学生细节分数查询
    @Override
    public List<DetailMark> findXC() {
        List<DetailMark> xcList = template.selectList("com.bhdx.DAO.SelectMapper.findXCAll");
        return xcList;
    }

    @Override
    public String getHeader(HttpServletRequest request) {
        String sessionid = null;
        //自己封装sessionContext
//        HashMap mymap = new HashMap();
//        Enumeration<String> headerNames = request.getHeaderNames();
//        for (Enumeration<String> e = headerNames; e.hasMoreElements(); ) {
//            String thisName = e.nextElement().toString();
//            String thisValue = request.getHeader(thisName);
//            if (thisName.equals("cookie")) {
//                sessionid = thisValue;
//            }
//            // System.out.println("header的key:" + thisName + "--------------header的value:" + thisValue);
//        }
//        System.out.println(sessionid);
//        HttpSession session = (HttpSession) mymap.get(sessionid);
//        // HttpSession session = MySessionContext.getSession(sessionid);
//        System.out.println(session.getAttribute("stuid"));
        return sessionid;
    }

    @Override
    public boolean cchcx(String zsname) {
        boolean btn = true;
        List list = new ArrayList();
        template.selectList("",zsname);
        if (list.size() != 0) {
            btn = !btn;
        }
        return btn;
    }

    @Override
    public boolean cchzc(String zsname) {
        boolean btn = true;
        List list = new ArrayList();
        if (list.size() != 0) {
            btn = !btn;
        }
        return btn;
    }

    @Override
    public String cchall(String zsname) {
        String message = "";
        boolean btn = true;
        boolean btn1 = true;
        boolean btn2 = true;
        btn1 = cchzc(zsname);
        btn2 = cchcx(zsname);
        if (!btn1) {
            message = "综测证书提交过了只需提交创新证书即可";
        }
        if (!btn2) {
            message = "创新证书提交过了只需提交综测证书即可";
        }
        btn = btn1 && btn2;
        if (btn1 || btn2) {
            message = "证书重复，请勿重复提交";
        }
        if (btn) {
            message = "";
        }
        return message;
    }
}
