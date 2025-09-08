package com.js.mapper;

import com.js.pojo.ActType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ActTypeMapper {

    //获取所有活动类型
    @Select("SELECT id, name,create_time FROM activity_type order by create_time desc ")
    List<ActType> getAll();


    //添加活动类型
    @Insert("INSERT INTO activity_type(name) VALUES(#{name})")
    void add(ActType actType);

    //根据id获取活动类型
    @Select("SELECT id, name,create_time FROM activity_type WHERE id=#{id}")
    ActType getById(Integer id);

    //更新活动类型
    @Update("UPDATE activity_type SET name=#{name} WHERE id=#{id}")
    void update(ActType actType);

    //删除活动类型
    @Delete("DELETE FROM activity_type WHERE id=#{id}")
    void delete(Integer id);
}
