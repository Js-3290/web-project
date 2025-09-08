package com.js.service;

import com.js.pojo.Activity;
import com.js.pojo.Registration;
import com.js.pojo.Result;

import java.util.List;

public interface RegistrationService {

    /**
     * 用户报名活动
     * @param
     * @param
     */
    Result register(Integer userId, Integer activityId);


    /**
     * 根据用户id查询用户报名的活动
     * @param
     * @return
     */
    List<Registration> getById(Integer id);

    /**
     * 根据活动id删除用户报名的活动
     * @param
     */
    void delete(Integer activityId);
}
