package com.js.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class UserQueryParam {
    private Integer page = 1;//页码
    private Integer pageSize = 10;//每页数量
    private String name;// 姓名
    private Integer  gender;// 性别




    @Override
    public String toString() {
        return "UserQueryParam{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public UserQueryParam() {
    }

    public UserQueryParam(Integer page, Integer pageSize, String name, Integer gender) {
        this.page = page;
        this.pageSize = pageSize;
        this.name = name;
        this.gender = gender;
    }
}
