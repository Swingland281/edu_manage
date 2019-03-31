package com.edu.dao;

import com.edu.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Repository
@WebServlet(name = "InstitutionDao")
public interface InstitutionDao {
    public void regist(User user);
    public User login(@Param("username") String username);
    public void addTest(Test test);
    public void addInternship(Internship internship);
    public void addCompetition(Competition competition);
    public void updTest(@Param("uptodate") String uptodate,@Param("test") String test,@Param("name") String name);
    public void updInternship(@Param("uptodate") String uptodate,@Param("company") String company,@Param("period") String period,@Param("name") String name);
    public void updCompetition(@Param("uptodate") String uptodate,@Param("competition") String competition,@Param("name") String name);
}
