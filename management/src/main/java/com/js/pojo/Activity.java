package com.js.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class Activity {
    private Integer id;
    private String name;
    private Integer typeId;//活动类型1-文艺、2-体育、3-学术、4-其他
    private LocalDate startTime;
    private LocalDate endTime;
    private String location;
    private Integer maxPeople;
    private Integer currentPeople;
    private String description;
    private Integer status;//1-未开始 2-进行中 3-已结束
    private LocalDateTime createTime;
    private Integer creatorId;

    private String creatorName;
    private String typeName;




    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", location='" + location + '\'' +
                ", maxPeople=" + maxPeople +
                ", currentPeople=" + currentPeople +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Integer getCurrentPeople() {
        return currentPeople;
    }

    public void setCurrentPeople(Integer currentPeople) {
        this.currentPeople = currentPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Activity() {
    }

    public Activity(Integer id, String name, Integer typeId, LocalDate startTime, LocalDate endTime, String location, Integer maxPeople, Integer currentPeople, String description, Integer status, LocalDateTime createTime, Integer creatorId, String creatorName, String typeName) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.maxPeople = maxPeople;
        this.currentPeople = currentPeople;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.typeName = typeName;
    }

    public void updateStatus() {
        if (this.startTime.isAfter(LocalDate.now())) {
            this.status = 1;
        } else if (this.startTime.isBefore(LocalDate.now()) && this.endTime.isAfter(LocalDate.now())) {
            this.status = 2;
        } else {
            this.status = 3;
        }
    }
}
