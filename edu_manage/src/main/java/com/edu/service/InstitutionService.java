package com.edu.service;

import com.edu.entity.*;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@WebServlet(name = "InstitutionService")
public interface InstitutionService{
    public void regist(User user);
    public boolean login(String username,String password);
    public void addTest(Test test);
    public void addInternship(Internship internship);
    public void addCompetition(Competition competition);
    public void updTest(String uptodate,String test,String name);
    public void updInternship(String uptodate,String company,String period,String name);
    public void updCompetition(String uptodate,String competition,String name);
}
