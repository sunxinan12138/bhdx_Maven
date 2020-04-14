package com.bhdx.service.impl;

import com.bhdx.models.*;
import com.bhdx.service.AddZsService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class AddZsServiceImpl implements AddZsService {
    @Autowired
    private SqlSessionTemplate template;

    @Override
    public boolean zcadd(ZCDetail zcDetail) {
        //添加成功返回true
        boolean b = false;
        int a = template.insert("com.bhdx.DAO.AddzsMapper.zcadd", zcDetail);
        if (a == 1) {
            b = true;
        }
        return b;
    }

    @Override
    public boolean cxadd(CXDetail cxDetail) {
        //添加成功返回true
        boolean b = false;
        int a = template.insert("com.bhdx.DAO.AddzsMapper.cxadd", cxDetail);
        if (a == 1) {
            b = true;
        }
        return b;
    }

    @Override
    public boolean findRepeat() {

        return false;
    }

    @Override
    public boolean addMark(OutCX outCX) {
        boolean btn = false;
        int a = template.insert("com.bhdx.DAO.AddzsMapper.addMark", outCX);
        if (a == 1) {
            btn = true;
        }
        System.out.println(btn);
        return btn;
    }

    @Override
    public boolean addMarkZC(OutZC outZC) {
        boolean btn = false;
        int a = template.insert("com.bhdx.DAO.AddzsMapper.addMarkZC", outZC);
        if (a == 1) {
            btn = true;
        }
        System.out.println(btn);
        return btn;
    }


}
