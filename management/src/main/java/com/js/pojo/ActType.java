package com.js.pojo;

import java.time.LocalDateTime;

public class ActType {
    private Integer id;
    private String name;
    private LocalDateTime createTime;



    @Override
    public String toString() {
        return "ActType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public ActType() {
    }

    public ActType(Integer id, String name, LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }
}
