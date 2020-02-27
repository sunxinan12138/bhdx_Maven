package com.bhdx.DAO;

import com.bhdx.models.Student;

import java.util.List;

public interface StudentMapper {
    public List<Student> findAll();
    public List<Student> selectInfo(String id);
}
