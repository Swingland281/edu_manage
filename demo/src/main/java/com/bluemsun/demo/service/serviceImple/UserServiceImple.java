package com.bluemsun.demo.service.serviceImple;


import com.bluemsun.demo.dao.UserdaoInterface;
import com.bluemsun.demo.entity.users;
import com.bluemsun.demo.service.UserServiceInterfece;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImple implements UserServiceInterfece {

    /**
     * @author  liup
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



    public void registUserInfo(String username,String password,String nickname,int rating){
        userdaoInterface.registUserInfo(username,password,nickname,rating);
    }
}
