package com.bhdx.service.impl;

import com.bhdx.DAO.OutExcelMapper;
import com.bhdx.DAO.StudentMapper;
import com.bhdx.models.Student;
import com.bhdx.service.OutService;
import com.bhdx.tools.ExcelTest;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutServiceImpl implements OutService {
    @Autowired
    private SqlSessionTemplate template;
    @Autowired
    private OutExcelMapper outExcelMapper;

    @Override
    public List<Student> outExcel(String classid, String path) {

        List zslist = outExcelMapper.selectOutCx(classid);
        //System.out.println(zslist);
        new ExcelTest(zslist, classid, path);
        return zslist;
    }
}
