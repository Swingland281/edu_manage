package com.bluemsun.demo.controller;


import com.bluemsun.demo.annotation.Anno;
import com.bluemsun.demo.entity.users;
import com.bluemsun.demo.service.UserServiceInterfece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginServlet {

    @Autowired
    UserServiceInterfece userServiceInterfece;


    //判断登录类型 1 学生 2 公司 3 教师/学校/竞赛承办机构 4 教育部
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Integer> judgeType(HttpServletRequest request,@RequestParam("rating") int flag ,@RequestParam("username") String username, @RequestParam("password")String password) throws IOException {

        Map<String,Integer> result = new HashMap<String, Integer>();
        int ifSucceed=0;
        switch (flag){
            case 1:{
                ifSucceed  = stuLogin(request,username,password);
                System.out.println("login end...");
                break;
            }

            //公司函数...
            case 2:{

                break;
            }
        }

        result.put("stateCode",ifSucceed);
        return result;

    }



    @Anno(operationName = "学生登录", operationType = "select操作")
    private int stuLogin(HttpServletRequest request, String username, String password) throws IOException {

        users student = userServiceInterfece.checkStudentLogin(username, password);

        int ifSucceed;
        if (student != null){
            request.getSession().setAttribute("student",student);
            ifSucceed = 1;
        }
        else {
            ifSucceed = 0;
        }

        return ifSucceed;

    }
}
