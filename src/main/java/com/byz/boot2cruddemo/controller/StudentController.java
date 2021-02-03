package com.byz.boot2cruddemo.controller;

import com.byz.boot2cruddemo.bean.Student;
import com.byz.boot2cruddemo.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class StudentController {

    @GetMapping(value = {"/","/login"})
    public String loginPage(HttpSession session){
//        log.info("msg>>>>>>>>>>>" + session.getAttribute("msg").toString());
        return "login";
    }

    @PostMapping(value = "/login")
    public String index(User user, HttpSession session, Model model){

        if(!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())){
            //登录成功，重定向到index页面，此方法用于解决表单重复提交
            session.setAttribute("user",user);
            return "redirect:/index";
        }else{
            //登录失败
            model.addAttribute("msg","用户名或密码错误！");
            return "login";
        }

    }

    @GetMapping("/index")
    public String indexPage(Model model){

        List<Student> students = Arrays.asList(new Student(1,"admin",20,new Date(),1,"我是管理员","static/images/h2.png"));
        model.addAttribute("students",students);

        return "index";
    }


    @GetMapping("/error")
    public String errorPage(){
        int i = 5 / 0;
        return "index";
    }



}


