package com.byz.boot2cruddemo.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.byz.boot2cruddemo.bean.Student;
import com.byz.boot2cruddemo.bean.User;
import com.byz.boot2cruddemo.service.StudentService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

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
    public String indexPage(@RequestParam(name = "currentPage",defaultValue = "1") Integer current, String name,Model model){

        List<Student> studentList = studentService.getStudentList(name, current);
        PageInfo page = new PageInfo(studentList);

        model.addAttribute("page",page);

        return "index";
    }

    @ResponseBody
    @RequestMapping("/delStudent")
    public String delStudent(Integer id){
        Integer delFlag = studentService.delStudentById(id);
        Map<String,String> map = new HashMap<String,String>();
        if(delFlag == 1){
            //成功
            map.put("result", "删除成功！");
        }else{
            //失败
            map.put("result", "删除失败！");
        }
        return JSONUtils.toJSONString(map);
    }

    @GetMapping("/addStudentPage")
    public String addStudentPage(){

        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestPart("headImgFile") MultipartFile headImgFile,@RequestPart("photosFile")MultipartFile[] photosFile,Student student) throws IOException {

        String headImgFileUrl = "";
        String photosImgFileUrl = "";

        if(!headImgFile.isEmpty()){
            //保存到文件服务器
            String originalFilename = headImgFile.getOriginalFilename();
            headImgFileUrl = "E:\\Develop\\WorkSpace\\IDEAWorkSpace\\boo2-crud-demo\\src\\main\\resources\\static\\images\\" + originalFilename;
            headImgFile.transferTo(new File(headImgFileUrl));
        }

        if(photosFile.length > 0){
            for (MultipartFile photo:photosFile){
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    String photoImgFileUrl = "E:\\Develop\\WorkSpace\\IDEAWorkSpace\\boo2-crud-demo\\src\\main\\resources\\static\\images\\" + originalFilename;
                    photo.transferTo(new File(photoImgFileUrl));
                    photosImgFileUrl += photoImgFileUrl + ",";
                }
            }
        }
        student.setHeadImg(headImgFileUrl);
        student.setPhotos(photosImgFileUrl);

        Integer flag = studentService.addStudent(student);
        if(flag == 1){
            return "redirect:/index";
        }else{
            return "addStudent";
        }
    }

    @GetMapping("/updStudentPage")
    public String updStudent(Integer id,Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "updStudent";
    }

    @PostMapping("/updStudent")
    public String updStudent(@RequestPart("headImgFile") MultipartFile headImgFile,@RequestPart("photosFile")MultipartFile[] photosFile,Student student) throws IOException {

        String headImgFileUrl = "";
        String photosImgFileUrl = "";

        if(!headImgFile.isEmpty()){
            //保存到文件服务器
            String originalFilename = headImgFile.getOriginalFilename();
            headImgFileUrl = "E:\\Develop\\WorkSpace\\IDEAWorkSpace\\boo2-crud-demo\\src\\main\\resources\\static\\images\\" + originalFilename;
            headImgFile.transferTo(new File(headImgFileUrl));
        }

        if(photosFile.length > 0){
            for (MultipartFile photo:photosFile){
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    String photoImgFileUrl = "E:\\Develop\\WorkSpace\\IDEAWorkSpace\\boo2-crud-demo\\src\\main\\resources\\static\\images\\" + originalFilename;
                    photo.transferTo(new File(photoImgFileUrl));
                    photosImgFileUrl += photoImgFileUrl + ",";
                }
            }
        }
        student.setHeadImg(headImgFileUrl);
        student.setPhotos(photosImgFileUrl);

        Integer flag = studentService.updStudentById(student);
        if(flag == 1){
            return "redirect:/index";
        }else{
            return "updStudent";
        }
    }


//    @GetMapping("/error")
//    public String errorPage(){
//        int i = 5 / 0;
//        return "index";
//    }



}


