package com.js.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.js.mapper.ActMapper;
import com.js.pojo.ActQueryParam;
import com.js.pojo.Activity;
import com.js.pojo.PageResult;
import com.js.service.ActService;
import com.js.service.ActivityApprovalService;
import com.js.utils.CurrentHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActServiceImpl implements ActService {

    @Autowired
    private ActMapper actMapper;

    @Autowired
    private ActivityApprovalService activityApprovalService;


    /**
     * PageHelper
     * @return
     */
//    @Override
//    public PageResult<Activity> list(Integer page, Integer pageSize, String name, Integer typeId,
//                                     LocalDate begin, LocalDate end) {
//        //设置分页参数
//        PageHelper.startPage(page,pageSize);
//
//        //查询
//        List<Activity> ActList=actMapper.list(name,typeId,begin,end);
//
//        Page<Activity> p=(Page<Activity>)ActList;
//
//
//        //解析结果并封装
//
//        return new PageResult<Activity>(p.getTotal(),p.getResult());
//    }
    @Override
    public PageResult<Activity> list(ActQueryParam actQueryParam) {
        //设置分页参数
        PageHelper.startPage(actQueryParam.getPage(),actQueryParam.getPageSize());


        //查询
        List<Activity> ActList=actMapper.list(actQueryParam);

        //更新状态并更新数据库
        for (int i=0; i < ActList.size(); i++) {
            ActList.get(i).updateStatus();
            actMapper.updateById(ActList.get(i));
        }

        Page<Activity> p=(Page<Activity>)ActList;


        //解析结果并封装

        return new PageResult<Activity>(p.getTotal(),p.getResult());
    }

    @Override
    public void save(Activity activity) {
        actMapper.insert(activity);
        //更新状态
        activity.updateStatus();
        //activity.setCreatorId(CurrentHolder.getCurrentId());
        //System.out.println("活动创建者id："+activity.getCreatorId());
        actMapper.updateById(activity);

        // 创建审批记录
        activityApprovalService.createApproval(activity.getId());

    }


    @Override
    public void delete(List<Integer> ids) {
        actMapper.deleteByIds(ids);
    }



    @Override
    public Activity getInfo(Integer id) {
        return actMapper.getById(id);
    }


    @Override
    public void update(Activity activity) {
        actMapper.updateById(activity);
        //更新状态
        activity.updateStatus();
    }

    @Override
    public List<Activity> getByCreatorId(Integer creatorId) {
        return actMapper.getByCreatorId(creatorId);
    }

}
