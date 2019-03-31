package com.bluemsun.demo.dao;

import com.bluemsun.demo.entity.users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserdaoInterface {

    //学生登录验证
    users checkStudentLogin(@Param("username") String username, @Param("password") String password);

    //学生信息更改
    void updateStudent(users user);

    //查询 导出信息
    users getStudentInfo(@Param("username") String username);
}
