package com.js.controller;


import com.js.pojo.Result;
import com.js.pojo.TypeOption;
import com.js.service.ReportSevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;


@RequestMapping("/report")
@RestController
public class ReportController {
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportSevice reportSevice;

    /**
     * 获取活动类型数据
     * @return
     */

    @GetMapping("/actTypeData")
    public Result getActivityTypeData() {
        log.info("获取活动类型数据");
        TypeOption typeOption=reportSevice.getActivityTypeData();
        return Result.success(typeOption);
    }

    /**
     * 获取用户性别数据
     * @return
     */

    @GetMapping("/userGenderData")
    public Result getUserGenderData() {
        log.info("获取用户性别数据");
        List<Map<String , Option>>  genderList= reportSevice.getUserGenderData();
        return Result.success(genderList);
    }
}
