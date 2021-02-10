package com.byz.boot2cruddemo.service.impl;

import com.byz.boot2cruddemo.mapper.StudentMapper;
import com.byz.boot2cruddemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;


    @Override
    public Integer getStudentCount() {
        return studentMapper.getStudentCount();
    }
}
