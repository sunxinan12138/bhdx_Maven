package com.bhdx.service.impl;

import com.bhdx.models.ZsDetail;
import com.bhdx.service.AddZsService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddZsServiceImpl implements AddZsService {
    @Autowired
    private SqlSessionTemplate template;

    @Override
    public boolean sout(ZsDetail zsDetail) {
        //添加成功返回true
        boolean b =false;
        int a = template.insert("com.bhdx.DAO.AddzsMapper.addZs",zsDetail);
        if (a==1){
            b = true;
        }
        return b;
    }
}
