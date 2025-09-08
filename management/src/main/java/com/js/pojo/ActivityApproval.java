package com.js.pojo;

import java.time.LocalDateTime;

public class ActivityApproval {
    private Integer id;
    private Integer activityId;
    private Integer approverId;
    private Integer approvalStatus; // 0-待审批，1-审批通过，2-审批拒绝
    private String approvalComment;
    private LocalDateTime approvalTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    // 审批人姓名（用于展示）
    private String approverName;

    // 活动名称（用于展示）
    private String activityName;

    // 构造函数
    public ActivityApproval() {}

    public ActivityApproval(Integer id, Integer activityId, Integer approverId, Integer approvalStatus,
                            String approvalComment, LocalDateTime approvalTime, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.activityId = activityId;
        this.approverId = approverId;
        this.approvalStatus = approvalStatus;
        this.approvalComment = approvalComment;
        this.approvalTime = approvalTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // Getter 和 Setter 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getApproverId() {
        return approverId;
    }

    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalComment() {
        return approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public LocalDateTime getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(LocalDateTime approvalTime) {
        this.approvalTime = approvalTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public String toString() {
        return "ActivityApproval{" +
                "id=" + id +
                ", activityId=" + activityId +
                ", approverId=" + approverId +
                ", approvalStatus=" + approvalStatus +
                ", approvalComment='" + approvalComment + '\'' +
                ", approvalTime=" + approvalTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", approverName='" + approverName + '\'' +
                ", activityName='" + activityName + '\'' +
                '}';
    }
}
