package com.bluemsun.demo.service;


import com.bluemsun.demo.entity.users;
import org.springframework.stereotype.Service;

@Service
public interface UserServiceInterfece {
    //学生登录验证
    users checkStudentLogin(String username,String password);

    //学生信息更改
    void updateStudent(users user);

    //查询 导出信息
    users getStudentInfo(String username);

}
