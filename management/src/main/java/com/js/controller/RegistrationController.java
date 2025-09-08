package com.js.controller;

import com.js.pojo.Activity;
import com.js.pojo.Registration;
import com.js.pojo.Result;
import com.js.service.RegistrationService;
import com.js.utils.CurrentHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/registrations")
@RestController
public class RegistrationController {

    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private RegistrationService registrationService;

    //报名活动
    @PostMapping
    public Result register(@RequestBody Activity activity) {
        Integer activityId = activity.getId();
        log.info("报名活动 {}", activityId);
        Integer userId = CurrentHolder.getCurrentId();
        return registrationService.register(userId, activityId);

    }

    //根据id查询报名信息
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("查询报名信息 {}", id);
        List<Registration> list = registrationService.getById(id);
        return Result.success(list);
    }
    //根据活动id删除报名信息
    @DeleteMapping
    public Result delete(Integer activityId) {
        log.info("删除报名信息 {}", activityId);
        registrationService.delete(activityId);
        return Result.success();
    }

}
