package com.bluemsun.demo.service.serviceImple;

import com.bluemsun.demo.annotation.Anno;
import com.bluemsun.demo.dao.LogDaoInterface;
import com.bluemsun.demo.entity.Page;
import com.bluemsun.demo.entity.SystemLog;
import com.bluemsun.demo.service.LogServiceInterface;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LogServiceImple implements LogServiceInterface {

    @Resource
    LogDaoInterface logDaoInterface;


    @Override
    public void addLog(SystemLog systemLog) {
        logDaoInterface.addLog(systemLog);
    }

    @Anno(operationType = "selectALL操作",operationName = "分页展示所有记录")
    public Page<SystemLog> getAllLogs(int pageNum, int pageSize) {
        int count=logDaoInterface.getLogCount();
        Page page=new Page(pageNum,pageSize,count);
        int startIndex = page.getStartIndex();
        List list=logDaoInterface.getAllLogs(startIndex,pageSize);
        page.setList(list);
        return page;
    }

}
