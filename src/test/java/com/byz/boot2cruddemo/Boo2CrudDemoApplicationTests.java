package com.byz.boot2cruddemo;

import com.byz.boot2cruddemo.bean.User;
import com.byz.boot2cruddemo.mapper.StudentMapper;
import com.byz.boot2cruddemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
@Slf4j
class Boo2CrudDemoApplicationTests {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
//        jdbcTemplate.queryForObject("select * from account_tbl")
//        jdbcTemplate.queryForList("select * from account_tbl",)
        Long aLong = jdbcTemplate.queryForObject("select count(*) from student", Long.class);
        log.info("记录总数：{}",aLong);

        log.info("数据源类型：{}",dataSource.getClass());
    }

    @Test
    void  test1(){
        Integer studentCount = studentMapper.getStudentCount();
        log.info("studentCount>>>>>>>>>>" + studentCount);
    }

    @Test
    void testUserMapper(){
//        User user = userMapper.selectById(1);
//        log.info("用户信息：{}",user);
    }
}
