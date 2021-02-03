package com.byz.boot2cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//basePackages = "com.byz.boot2cruddemo"
@ServletComponentScan(basePackages = "com.byz.boot2cruddemo") //默认值为主启动类下的包和子包
@SpringBootApplication
public class Boot2CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot2CrudDemoApplication.class, args);
    }

}
