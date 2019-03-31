package com.bluemsun.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testbooot {


    @RequestMapping("/boot/index")
    public @ResponseBody String index(){


        return "hello world";
    }


    @RequestMapping("/boot/testjava")
    public void hello(){
        System.out.println("hello sout java");

    }


    @RequestMapping("/boot/index1")
    public  String index1(Model model){

        model.addAttribute("msg","how are you ");

        return "index";
    }


    @RequestMapping("/boot/index2")
    public  String index2(Model model){

        model.addAttribute("msg","how are you  2");

        return "index2";
    }


}
