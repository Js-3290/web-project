package com.js.mapper;

import com.js.pojo.ActivityApproval;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ActivityApprovalMapper {

    /**
     * 创建审批记录
     */
    @Insert("INSERT INTO activity_approval(activity_id, approval_status) VALUES(#{activityId}, #{approvalStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(ActivityApproval activityApproval);

    /**
     * 更新审批记录
     */
    @Update("UPDATE activity_approval SET approver_id = #{approverId}, approval_status = #{approvalStatus}, " +
            "approval_comment = #{approvalComment}, approval_time = NOW() WHERE id = #{id}")
    void update(ActivityApproval activityApproval);

    /**
     * 根据活动ID查询审批记录
     */
    @Select("SELECT aa.*, u.name approverName, a.name activityName " +
            "FROM activity_approval aa " +
            "LEFT JOIN user u ON aa.approver_id = u.id " +
            "LEFT JOIN activity a ON aa.activity_id = a.id " +
            "WHERE aa.activity_id = #{activityId}")
    ActivityApproval getByActivityId(Integer activityId);

    /**
     * 根据ID查询审批记录
     */
    @Select("SELECT aa.*, u.name approverName, a.name activityName " +
            "FROM activity_approval aa " +
            "LEFT JOIN user u ON aa.approver_id = u.id " +
            "LEFT JOIN activity a ON aa.activity_id = a.id " +
            "WHERE aa.id = #{id}")
    ActivityApproval getById(Integer id);

    /**
     * 根据审批状态查询审批记录
     */
    @Select("SELECT aa.*, u.name approverName, a.name activityName " +
            "FROM activity_approval aa " +
            "LEFT JOIN user u ON aa.approver_id = u.id " +
            "LEFT JOIN activity a ON aa.activity_id = a.id " +
            "WHERE aa.approval_status = #{approvalStatus} " +
            "ORDER BY aa.create_time DESC")
    List<ActivityApproval> getByApprovalStatus(Integer approvalStatus);

    /**
     * 查询所有待审批记录（分页）
     */
    List<ActivityApproval> listPendingApprovals();

    /**
     * 查询审批记录（带条件）
     */
    List<ActivityApproval> list(ActivityApproval activityApproval);
}