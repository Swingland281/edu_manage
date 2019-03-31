package com.bluemsun.demo.service;

import com.bluemsun.demo.entity.Page;
import com.bluemsun.demo.entity.SystemLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogServiceInterface {

    void addLog(SystemLog log); // 插入日志


    Page<SystemLog> getAllLogs(int pageNum, int pageSize);

}
