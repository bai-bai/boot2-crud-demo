package com.byz.boot2cruddemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String userName;

    private String password;

    private Date createTime;

    private String ip;

    //冗余字段1
    private String field1;

    //冗余字段2
    private String field2;

}
