package com.bhdx.service.impl;

import com.bhdx.service.AddZsService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddZsServiceImpl implements AddZsService {
    @Autowired
    private SqlSessionTemplate template;

    @Override
    public boolean sout() {
        //添加成功返回true
        boolean b =false;
        System.out.println("ssssser");
        int a = template.insert("");
        if (a==1){
            b = true;
        }
        return b;
    }
}
