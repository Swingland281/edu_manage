package com.bluemsun.demo.controller;

import com.bluemsun.demo.annotation.Anno;
import com.bluemsun.demo.entity.users;
import com.bluemsun.demo.service.LogServiceInterface;
import com.bluemsun.demo.service.UserServiceInterfece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class SchoolControl {
    @Autowired
    UserServiceInterfece userServiceInterfece;

    @Autowired
    LogServiceInterface logServiceInterface;

    @Anno(operationName = "在系统中创立一个学生的信息",operationType = "insert操作")
    @RequestMapping("/registUser")
    public Map<String,Integer> registUser(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("nickname") String nickname,@RequestParam("rating") int rating) throws Exception{
        Map<String,Integer> result = new HashMap();
        int stateCode;
        users tempUser = userServiceInterfece.getStudentInfo(username);  //检查该账号是否已存在
        if (tempUser != null) {
            stateCode = 0;  //失败
        }else {
//            users newUser = new users();
//            newUser.setUsername(username);
//            newUser.setPassword(password);
//            newUser.setNickname(nickname);
//            newUser.setRating(rating);
            userServiceInterfece.registUserInfo(username, password, nickname, rating);
            stateCode = 1;  //成功
        }
        result.put("stateCode",stateCode);
        return result;
    }




}
