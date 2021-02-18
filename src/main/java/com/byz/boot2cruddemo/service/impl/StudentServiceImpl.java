package com.byz.boot2cruddemo.service.impl;

import com.byz.boot2cruddemo.bean.Student;
import com.byz.boot2cruddemo.mapper.StudentMapper;
import com.byz.boot2cruddemo.service.StudentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Integer getStudentCount() {
        return studentMapper.getStudentCount();
    }

    @Override
    public Integer delStudentById(Integer id) {
        return studentMapper.delStudentById(id);
    }

    @Override
    public List<Student> getStudentList(String name,Integer pageNum) {
        PageHelper.startPage(pageNum,2);
        List<Student> studentList = studentMapper.getStudentList(name);
        return studentList;
    }

    @Override
    public Integer addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public Integer updStudentById(Student student) {
        return studentMapper.updStudentById(student);
    }
}
