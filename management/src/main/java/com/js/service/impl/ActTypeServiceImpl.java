package com.js.service.impl;

import com.js.mapper.ActTypeMapper;
import com.js.pojo.ActType;
import com.js.service.ActTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActTypeServiceImpl implements ActTypeService {

    @Autowired
    private  ActTypeMapper actTypeMapper;

    /**
     * 获取所有活动类型
     *
     * @return
     */
    @Override
    public List<ActType> getAll() {
        return actTypeMapper.getAll();
    }

    /**
     * 添加活动类型
     *
     * @param
     */
    @Override
    public void add(ActType actType) {
        actTypeMapper.add(actType);
    }

    /**
     * 根据id获取活动类型
     *
     * @param
     * @return
     */
    @Override
    public ActType getById(Integer id) {
        return actTypeMapper.getById(id);
    }


    /**
     * 修改活动类型
     *
     * @param
     */
    @Override
    public void update(ActType actType) {
        actTypeMapper.update(actType);
    }

    /**
     * 删除活动类型
     *
     * @param
     */
    @Override
    public void delete(Integer id) {
        actTypeMapper.delete(id);
    }
}
