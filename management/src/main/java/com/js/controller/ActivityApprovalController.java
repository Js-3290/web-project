package com.js.controller;

import com.js.pojo.ActivityApproval;
import com.js.pojo.PageResult;
import com.js.pojo.Result;
import com.js.service.ActivityApprovalService;
import com.js.utils.CurrentHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/approvals")
@RestController
public class ActivityApprovalController {

    private static final Logger log = LoggerFactory.getLogger(ActivityApprovalController.class);

    @Autowired
    private ActivityApprovalService activityApprovalService;

    /**
     * 获取待审批列表
     */
    @GetMapping("/pending")
    public Result getPendingApprovals(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("获取待审批列表，page={}, pageSize={}", page, pageSize);
        PageResult<ActivityApproval> pageResult = activityApprovalService.listPendingApprovals(page, pageSize);
        return Result.success(pageResult);
    }

    /**
     * 根据审批状态获取审批列表
     */
    @GetMapping
    public Result getApprovalsByStatus(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) Integer approvalStatus) {
        log.info("根据审批状态获取审批列表，page={}, pageSize={}, approvalStatus={}", page, pageSize, approvalStatus);
        PageResult<ActivityApproval> pageResult = activityApprovalService.getByApprovalStatus(page, pageSize, approvalStatus);
        return Result.success(pageResult);
    }

    /**
     * 审批活动
     */
    @PostMapping("/{id}/approve")
    public Result approveActivity(
            @PathVariable Integer id,
            @RequestParam Integer approvalStatus,
            @RequestParam(required = false) String approvalComment) {
        log.info("审批活动，id={}, approvalStatus={}, approvalComment={}", id, approvalStatus, approvalComment);

        // 验证审批状态参数
        if (approvalStatus != 1 && approvalStatus != 2) {
            return Result.error("审批状态参数错误");
        }

        try {
            Integer approverId = CurrentHolder.getCurrentId();
            activityApprovalService.approveActivity(id, approverId, approvalStatus, approvalComment);
            return Result.success();
        } catch (Exception e) {
            log.error("审批活动失败", e);
            return Result.error("审批失败");
        }
    }

    /**
     * 根据活动ID查询审批记录
     */
    @GetMapping("/activity/{activityId}")
    public Result getApprovalByActivityId(@PathVariable Integer activityId) {
        log.info("根据活动ID查询审批记录，activityId={}", activityId);
        ActivityApproval activityApproval = activityApprovalService.getByActivityId(activityId);
        return Result.success(activityApproval);
    }
}