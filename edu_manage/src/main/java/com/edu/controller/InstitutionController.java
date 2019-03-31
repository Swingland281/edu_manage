package com.edu.controller;

import com.edu.entity.*;
import com.edu.service.InstitutionService;
import com.edu.service.serviceImp.InstitutionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import com.edu.entity.*;


@Controller
@WebServlet(name = "InstitutionController")
public class InstitutionController {
    @Autowired
    InstitutionServiceImp institutionServiceImp;
    @Autowired
    User user;
    @Autowired
    Test test;
    @Autowired
    Internship internship;
    @Autowired
    Competition competition;

    @RequestMapping(value = "/identification",method = RequestMethod.POST)
    @ResponseBody
    public void identification(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam("username")String username, @RequestParam("rating")int rating,
                               @RequestParam("password")String password) throws ServletException, IOException {

        if(username!=null&&password!=null) {
            user.setUsername(username);
            user.setPassword(password);
            user.setRating(rating);
        }
        institutionServiceImp.regist(user);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam("username")String username,@RequestParam("password")String password)throws ServletException, IOException {
        if(institutionServiceImp.login(username,password)){
            request.getSession().setAttribute("current_user",username);
            request.getRequestDispatcher("/addInformation.jsp").forward(request,response);
        }
         else
        response.getWriter().write("UNSUCCESS");
    }


    @RequestMapping(value = "/addTest",method = RequestMethod.POST)
    @ResponseBody
    public void addTest(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam("name")String name,@RequestParam("subject")String subject,
                        @RequestParam("grade")String grade,@RequestParam("test")String test,@RequestParam("score")String score,
                        @RequestParam("describe")String describe)throws ServletException, IOException {
        //学生姓名
        this.test.setName(name);
        //记录信息者
        this.test.setRecorder((String)request.getSession().getAttribute("current_user"));
        //记录学科
        this.test.setSubject(subject);
        //记录年级
        this.test.setGrade(grade);
        //记录考试名称
        this.test.setTest(test);
        //记录得分
        this.test.setScore(score);
        //记录补充
        this.test.setDescribe(describe);
        //记录记录时间
        this.test.setRecord_time(new Date().toString());

        institutionServiceImp.addTest(this.test);
    }

    @RequestMapping(value = "/addInternship",method = RequestMethod.POST)
    @ResponseBody
    public void addInternship(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam("name")String name,@RequestParam("company")String company,
                        @RequestParam("period")String period,@RequestParam("describe")String describe)throws ServletException, IOException {
        //学生姓名
        this.internship.setName(name);
        //记录信息者
        this.internship.setRecorder((String)request.getSession().getAttribute("current_user"));
        //记录补充
        this.internship.setDescribe(describe);
        //记录记录时间
        this.internship.setRecord_time(new Date().toString());
        //记录公司
        this.internship.setCompany(company);
        //记录实习日期
        this.internship.setPeriod(period);

        institutionServiceImp.addInternship(this.internship);
    }

    @RequestMapping(value = "/addCompetition",method = RequestMethod.POST)
    @ResponseBody
    public void addCompetition(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam("name")String name,@RequestParam("competition")String competition,
                               @RequestParam("degree")String degree,@RequestParam("achievement")String achievement,
                               @RequestParam("describe")String describe)throws ServletException, IOException {
        //学生姓名
        this.competition.setName(name);
        //记录信息者
        this.competition.setRecorder((String)request.getSession().getAttribute("current_user"));
        //记录时间
        this.competition.setRecord_time(new Date().toString());
        //记录竞赛名称
        this.competition.setCompetition(competition);
        //记录成绩
        this.competition.setCompetition(competition);
        //记录描述
        this.competition.setDescribe(describe);
        //记录竞赛等级
        this.competition.setDegree(degree);

        institutionServiceImp.addCompetition(this.competition);

    }


    @RequestMapping(value = "updTest",method = RequestMethod.POST)
    @ResponseBody
    public void updTest(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam("uptodate")String uptodate,@RequestParam("test")String test,
                               @RequestParam("name")String name)throws ServletException, IOException{
    institutionServiceImp.updTest(uptodate,test,name);
    }

    @RequestMapping(value = "updInternship",method = RequestMethod.POST)
    @ResponseBody
    public void updInternship(HttpServletRequest request, HttpServletResponse response,
                        @RequestParam("uptodate")String uptodate,@RequestParam("company")String company,
                        @RequestParam("period")String period, @RequestParam("name")String name)throws ServletException, IOException{
    institutionServiceImp.updInternship(uptodate,company,period,name);
    }

    @RequestMapping(value = "updCompetition",method = RequestMethod.POST)
    @ResponseBody
    public void updCompetition(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam("uptodate")String uptodate,@RequestParam("competition")String competition,
                               @RequestParam("name")String name)throws ServletException, IOException{
    institutionServiceImp.updCompetition(uptodate,competition,name);
    }

}
