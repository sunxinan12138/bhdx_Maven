package com.bhdx.service.impl;

import com.bhdx.DAO.SelectMapper;
import com.bhdx.models.*;
import com.bhdx.service.SelectService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {
    @Autowired
    private SqlSessionTemplate template;

    @Override
    public List<JingFei> findJF() {
        List<JingFei> jfList = template.selectList("com.bhdx.DAO.SelectMapper.findJF");
        return jfList;
    }

    @Override
    public List<JingFei> findJK() {
        List<JingFei> jkList = template.selectList("com.bhdx.DAO.SelectMapper.findJK");
        return jkList;
    }

    @Override
    public List<JingFei> findKF() {
        List<JingFei> kfList = template.selectList("com.bhdx.DAO.SelectMapper.findKF");
        return kfList;
    }

    @Override
    public List<JingFei> findKK() {
        List<JingFei> kkList = template.selectList("com.bhdx.DAO.SelectMapper.findKK");
        return kkList;
    }

    @Override
    public List<JingFei> findZZ() {
        List<JingFei> zzList = template.selectList("com.bhdx.DAO.SelectMapper.findZZ");
        return zzList;
    }

    @Override
    public List<JingFei> findZQ() {
        List<JingFei> zqList = template.selectList("com.bhdx.DAO.SelectMapper.findZQ");
        return zqList;
    }

    @Override
    public List<JingFei> findHK() {
        List<JingFei> hkList = template.selectList("com.bhdx.DAO.SelectMapper.findHK");
        return hkList;
    }

    @Override
    public List<JingFei> findHS() {
        List<JingFei> hsList = template.selectList("com.bhdx.DAO.SelectMapper.findHS");
        return hsList;
    }

    @Override
    public List<JingFei> findHST() {
        List<JingFei> hstList = template.selectList("com.bhdx.DAO.SelectMapper.findHST");
        return hstList;
    }

    @Override
    public List<JingFei> findHX() {
        List<JingFei> hktList = template.selectList("com.bhdx.DAO.SelectMapper.findHX");
        return hktList;
    }

    @Override
    public List<JingFei> findHSZ() {
        List<JingFei> sztList = template.selectList("com.bhdx.DAO.SelectMapper.findHSZ");
        return sztList;
    }

    //c查询分数
    @Override
    public List<JIngFei_mark> findjkmark() {
        List<JIngFei_mark> jkList = template.selectList("com.bhdx.DAO.SelectMapper.findjkmark");
        return jkList;
    }

    @Override
    public List<JIngFei_mark> findmark(Integer id) {
        List<JIngFei_mark> jIngFei_markList = template.selectList("com.bhdx.DAO.SelectMapper.findJFmark", id);
        return jIngFei_markList;
    }

    @Override
    public List<JIngFei_mark> findkkmark(Integer id) {
        List<JIngFei_mark> kkList = template.selectList("com.bhdx.DAO.SelectMapper.findKKmark", id);
        return kkList;
    }

    @Override
    public List<JIngFei_mark> findkfmark(Integer id) {
        List<JIngFei_mark> kfList = template.selectList("com.bhdx.DAO.SelectMapper.findKFmark", id);
        return kfList;
    }

    @Override
    public List<JIngFei_mark> findzqMark(Integer id) {
        List<JIngFei_mark> zqList = template.selectList("com.bhdx.DAO.SelectMapper.findZQmark", id);
        return zqList;
    }

    @Override
    public List<JIngFei_mark> findhkMark(Integer id) {
        List<JIngFei_mark> hkList = template.selectList("com.bhdx.DAO.SelectMapper.findHKmark", id);
        return hkList;
    }

    @Override
    public List<JIngFei_mark> findhsMark(Integer id) {
        List<JIngFei_mark> hsList = template.selectList("com.bhdx.DAO.SelectMapper.findHSmark", id);
        return hsList;
    }

    @Override
    public List<JIngFei_mark> findhstMark(Integer id) {
        List<JIngFei_mark> hstList = template.selectList("com.bhdx.DAO.SelectMapper.findHSTmark", id);
        return hstList;
    }

    //学生细节分数查询
    @Override
    public List<DetailMark> findXC() {
        List<DetailMark> xcList = template.selectList("com.bhdx.DAO.SelectMapper.findXCAll");
        return xcList;
    }

    @Override
    public List<JIngFei_mark> findzzMark() {
        List<JIngFei_mark> zzMList = template.selectList("com.bhdx.DAO.SelectMapper.findzzMark");
        return zzMList;
    }

    @Override
    public List<JIngFei_mark> findhxMark() {
        List<JIngFei_mark> hxMMList = template.selectList("com.bhdx.DAO.SelectMapper.findhxMark");
        return hxMMList;
    }

    @Override
    public List<JIngFei_mark> findhszMark() {
        List<JIngFei_mark> hszMList = template.selectList("com.bhdx.DAO.SelectMapper.findhszMark");
        return hszMList;
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
