package com.bluemsun.demo;

import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class testServlet extends HttpServlet {

    @RequestMapping(value = "/helloservlet")
    public void hello(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello");

    }
}
