package com.bluemsun.demo.dao;

import com.bluemsun.demo.entity.SystemLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogDaoInterface {

    void addLog(SystemLog systemLog);

    int getLogCount();

    List<SystemLog> getAllLogs(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

}
