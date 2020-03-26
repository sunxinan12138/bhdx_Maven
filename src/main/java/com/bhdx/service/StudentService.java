package com.bhdx.service;

import com.bhdx.models.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public List<Student> findStudent();

    public void changepsw(Map map);
}
