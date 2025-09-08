package com.js.service;

import com.js.pojo.ActType;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActTypeService {
    /**
     * 获取所有活动类型
     * @return
     */
    List<ActType> getAll();

    /**
     * 添加活动类型
     * @param
     */
    void add(ActType actType);

    /**
     * 根据id获取活动类型
     * @param id
     * @return
     */
    ActType getById(Integer id);

    /**
     * 修改活动类型
     * @param actType
     */
    void update(ActType actType);

    //删除活动类型
    void delete(Integer id);
}
    
