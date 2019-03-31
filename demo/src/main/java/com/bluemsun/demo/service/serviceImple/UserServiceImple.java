package com.bluemsun.demo.service.serviceImple;


import com.bluemsun.demo.dao.UserdaoInterface;
import com.bluemsun.demo.entity.users;
import com.bluemsun.demo.service.UserServiceInterfece;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImple implements UserServiceInterfece {

    /**
     *
     */
    @Resource
    UserdaoInterface userdaoInterface;

    @Override
    public users checkStudentLogin(String username, String password) {
//        System.out.println("username:" + username + "password :" + password);
        return userdaoInterface.checkStudentLogin(username, password);
    }

    @Override
    public void updateStudent(users user) {
        userdaoInterface.updateStudent(user);
    }

    @Override
    public users getStudentInfo(String username) {
        return userdaoInterface.getStudentInfo(username);
    }
}
