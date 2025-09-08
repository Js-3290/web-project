package com.js.service.impl;

import com.js.mapper.ActMapper;
import com.js.mapper.UserMapper;
import com.js.pojo.TypeOption;
import com.js.service.ReportSevice;
import com.js.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportSevice {

    @Autowired
    private ActMapper actMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public TypeOption getActivityTypeData() {
        List<Map<String,Object>> list=actMapper.countActivityTypeData();

        List<Object> typeList=list.stream().map(dataMap->dataMap.get("typeName")).toList();
        List<Object> dataList=list.stream().map(dataMap->dataMap.get("num")).toList();

        return new TypeOption(typeList,dataList);
    }

    @Override
    public List<Map<String, Option>> getUserGenderData() {
        return userMapper.countUserGenderData();
    }
}
