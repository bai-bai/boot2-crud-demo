package com.byz.boot2cruddemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    private Date birth;

    private Integer sex;

    private String intr;

    private String headImg;

}
