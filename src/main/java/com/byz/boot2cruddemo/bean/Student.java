package com.byz.boot2cruddemo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

    private Integer sex;

    private String intr;

    private String headImg;

    private String photos;

}
