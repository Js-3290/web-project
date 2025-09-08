package com.js.service.impl;

import com.js.mapper.ActMapper;
import com.js.mapper.RegistrationMapper;
import com.js.pojo.Activity;
import com.js.pojo.Registration;
import com.js.pojo.Result;
import com.js.service.RegistrationService;
import com.js.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationMapper registrationMapper;

    @Autowired
    private ActMapper actMapper;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Result register(Integer userId, Integer activityId) {
        try {
            //检查活动状态和活动人数
            Activity activity = actMapper.getById(activityId);
            if(activity.getStatus() != 1){
                return Result.error("活动已开始或活动已经结束");
            }
            if(activity.getCurrentPeople() >= activity.getMaxPeople()){
                return Result.error("活动人数已满");
            }

            //检查是否已报名
            if(registrationMapper.getByUserIdAndActivityId(userId, activityId) != null){
                return Result.error("已报名");
            }

            //报名
            registrationMapper.insert(new Registration(null, userId, activityId, null));

            //更新活动人数
            actMapper.updateCurrentPeople(activityId);
            return Result.success();
        } catch (Exception e) {
            throw e;
            //return Result.error("报名失败");
        }

    }

    /**
     * 获取用户报名的活动
     * @param
     * @return
     */
    @Override
    public List<Registration> getById(Integer id) {
        return registrationMapper.getById(id);
    }

    /**
     * 删除用户报名的活动
     * @param
     * @return
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(Integer activityId) {

        try {
            Integer userId = CurrentHolder.getCurrentId();
            //删除报名记录
            registrationMapper.deleteByActivityId(userId,activityId);

            //更新活动人数(减少)
            actMapper.updateCurrentPeople2(activityId);
        } catch (Exception e) {
            throw e;
        }


    }
}
