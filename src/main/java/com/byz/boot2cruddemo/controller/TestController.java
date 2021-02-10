package com.byz.boot2cruddemo.controller;

import com.byz.boot2cruddemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    StudentService studentService;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from student", Long.class);
        return aLong.toString();
    }

    @ResponseBody
    @GetMapping("/getCount")
    public String getStudentCount(){
        return studentService.getStudentCount().toString();
    }

}
