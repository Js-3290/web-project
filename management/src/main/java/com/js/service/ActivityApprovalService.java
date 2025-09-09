package com.js.service;

import com.js.pojo.ActivityApproval;
import com.js.pojo.PageResult;

public interface ActivityApprovalService {

    /**
     * 创建审批记录
     */
    void createApproval(Integer activityId);

    /**
     * 审批活动
     */
    void approveActivity(Integer approvalId, Integer approverId, Integer approvalStatus, String approvalComment);

    /**
     * 根据活动ID查询审批记录
     */
    ActivityApproval getByActivityId(Integer activityId);

    /**
     * 根据ID查询审批记录
     */
    ActivityApproval getById(Integer id);

    /**
     * 根据审批状态查询审批记录（分页）
     */
    PageResult<ActivityApproval> getByApprovalStatus(Integer page, Integer pageSize, Integer approvalStatus);

    /**
     * 查询待审批记录（分页）
     */
    PageResult<ActivityApproval> listPendingApprovals(Integer page, Integer pageSize);

    /**
     * 查询审批记录（带条件）
     */
    PageResult<ActivityApproval> list(Integer page, Integer pageSize, ActivityApproval activityApproval);
}
