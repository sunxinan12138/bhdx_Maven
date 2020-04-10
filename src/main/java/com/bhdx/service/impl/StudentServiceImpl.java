package com.bhdx.service.impl;

import com.bhdx.DAO.StudentMapper;
import com.bhdx.models.OutCX;
import com.bhdx.models.Student;
import com.bhdx.service.StudentService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SqlSessionTemplate template;

    @Override
    public List<Student> findStudent() {
        List<Student> studentList = studentMapper.findAll();
        return studentList;
    }

    @Override
    public String findStuidByClassId(String stuid) {
        String classId1 = studentMapper.findClassIdBystuid(stuid);
        return classId1;
    }

    @Override
    public void changepsw(Map map) {
        studentMapper.changepsw(map);
    }

    @Override
    public boolean changemessage(Student student) {
        boolean btn = false;
        int a = studentMapper.changemessage(student);
        if (a != 0) {
            btn = !btn;
        }
        return btn;
    }


}
