package com.bluemsun.demo.controller;


import com.bluemsun.demo.annotation.Anno;
import com.bluemsun.demo.entity.users;
import com.bluemsun.demo.service.UserServiceInterfece;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class StudentServlet {

    @Autowired
    UserServiceInterfece userServiceInterfece;


    //根据id查对应的student对象所有属性
    @RequestMapping("/student/getInfo")
    @Anno(operationType = "select操作",operationName = "根据id查信息")
    public void getAllInfoById(HttpServletResponse response, @RequestParam("username")String username) throws IOException {
        users studentInfo = userServiceInterfece.getStudentInfo(username);
        JSONObject jsonObject =  new JSONObject();

        if (studentInfo != null) {
            jsonObject.put("studentInfo",studentInfo);
        }else {
            jsonObject.put("ERROR","查无此人！");
        }
        response.getWriter().write(jsonObject.toString());
    }







}
