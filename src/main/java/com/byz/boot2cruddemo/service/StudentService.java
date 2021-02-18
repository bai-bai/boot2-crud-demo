package com.byz.boot2cruddemo.service;

import com.byz.boot2cruddemo.bean.Student;

import java.util.List;

public interface StudentService {

    Integer getStudentCount();

    Integer delStudentById(Integer id);

    List<Student> getStudentList(String name,Integer pageNum);

    Integer addStudent(Student student);

    Student getStudentById(Integer id);

    Integer updStudentById(Student student);

}
