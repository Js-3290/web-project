package com.js.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.js.mapper.ActivityApprovalMapper;
import com.js.pojo.ActivityApproval;
import com.js.pojo.PageResult;
import com.js.service.ActivityApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActivityApprovalServiceImpl implements ActivityApprovalService {

    @Autowired
    private ActivityApprovalMapper activityApprovalMapper;

    @Override
    public void createApproval(Integer activityId) {
        ActivityApproval activityApproval = new ActivityApproval();
        activityApproval.setActivityId(activityId);
        activityApproval.setApprovalStatus(0); // 默认待审批
        activityApproval.setCreateTime(LocalDateTime.now());
        activityApproval.setUpdateTime(LocalDateTime.now());
        activityApprovalMapper.insert(activityApproval);
    }

    @Override
    public void approveActivity(Integer approvalId, Integer approverId, Integer approvalStatus, String approvalComment) {
        ActivityApproval activityApproval = activityApprovalMapper.getById(approvalId);
        if (activityApproval != null) {
            activityApproval.setApproverId(approverId);
            activityApproval.setApprovalStatus(approvalStatus);
            activityApproval.setApprovalComment(approvalComment);
            activityApproval.setApprovalTime(LocalDateTime.now());
            activityApproval.setUpdateTime(LocalDateTime.now());
            activityApprovalMapper.update(activityApproval);
        }
    }

    @Override
    public ActivityApproval getByActivityId(Integer activityId) {
        return activityApprovalMapper.getByActivityId(activityId);
    }

    @Override
    public ActivityApproval getById(Integer id) {
        return activityApprovalMapper.getById(id);
    }

    @Override
    public PageResult<ActivityApproval> getByApprovalStatus(Integer page, Integer pageSize, Integer approvalStatus) {
        PageHelper.startPage(page, pageSize);
        List<ActivityApproval> list = activityApprovalMapper.getByApprovalStatus(approvalStatus);
        Page<ActivityApproval> p = (Page<ActivityApproval>) list;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public PageResult<ActivityApproval> listPendingApprovals(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<ActivityApproval> list = activityApprovalMapper.listPendingApprovals();
        Page<ActivityApproval> p = (Page<ActivityApproval>) list;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public PageResult<ActivityApproval> list(Integer page, Integer pageSize, ActivityApproval activityApproval) {
        PageHelper.startPage(page, pageSize);
        List<ActivityApproval> list = activityApprovalMapper.list(activityApproval);
        Page<ActivityApproval> p = (Page<ActivityApproval>) list;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}