package com.js.mapper;

import com.js.pojo.Activity;
import com.js.pojo.Registration;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegistrationMapper {

    // 根据用户id和活动id查询
    Integer getByUserIdAndActivityId(Integer userId, Integer activityId);

    //添加报名记录
    void insert(Registration registration);

    //根据id查询
    List<Registration> getById(Integer id);

    //根据活动id删除
    void deleteByActivityId(Integer userId, Integer activityId);
}
