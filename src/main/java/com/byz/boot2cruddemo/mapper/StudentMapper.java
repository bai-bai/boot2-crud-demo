package com.byz.boot2cruddemo.mapper;


import com.byz.boot2cruddemo.bean.Student;

import java.rmi.StubNotFoundException;
import java.util.List;


/**
 * mybatis 参数详解
 * 单个参数
 *      简单类型，#{参数名}，此时参数名可以随便写，但为了直观推荐参数名保持一致
 *      复杂类型，对象和map最为常见，它们最后都会被mybatis处理成map。接口参数为对象就用#{属性名}，接口参数为map就用#{key}即可
 *      其他复杂类型：略，https://blog.csdn.net/qq_43052725/article/details/105577159
 * 多个参数
 *      mybatis会做特殊处理，多个参数会被封装到一个map中，key为param1,param2…paramN,也可以是索引:0,1…N
 *          User getUserByIdAndName(Integer id,String name);
 *          此时对应mapper文件中通过#{id}和#{name}取值就会报错，报错的原因就是没有找到名为id以及name的key。
 *          解决办法就是通过#{param1}和#{param2}获取，当然也可以使用索引获取。
 *      常用方法：
 *          User getUserByIdAndName(@Param("id")Integer id,@Param("name")String name);
 *          最终就可以通过注解@Param(“key”)指定key的名字了，在mapper文件中#{id}和#{name}取值就不会再报错了。
 */
public interface StudentMapper{

    Integer getStudentCount();

    Integer delStudentById(Integer id);

    List<Student> getStudentList(String name);

    Integer addStudent(Student student);

    Student getStudentById(Integer id);

    Integer updStudentById(Student student);

}
