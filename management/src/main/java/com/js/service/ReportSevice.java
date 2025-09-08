package com.js.service;

import com.js.mapper.ActMapper;
import com.js.pojo.TypeOption;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;

public interface ReportSevice {


    /**
     * 获取活动类型数据
     * @return
     */
    TypeOption getActivityTypeData();

    /**
     * 获取用户性别数据
     * @return
     */
    List<Map<String, Option>> getUserGenderData();
}
