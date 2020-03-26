package com.bhdx.service.impl;

import com.bhdx.DAO.StudentMapper;
import com.bhdx.models.Student;
import com.bhdx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findStudent() {
        List<Student> studentList = studentMapper.findAll();
        return studentList;
    }

    @Override
    public void changepsw(Map map) {
        studentMapper.changepsw(map);
    }
}
