package com.js.mapper;

import com.js.pojo.ActQueryParam;
import com.js.pojo.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface ActMapper {

    /**
     * 条件查询活动信息
     */

    //@Select("SELECT a.*, u.name creatorName,at.name typeName FROM activity a left JOIN user u ON a.creator_id = u.id left join activity_type at on a.type_id = at.id order by a.create_time desc ")
//    public List<Activity> list(String name, Integer typeId, LocalDate begin, LocalDate end);
    public List<Activity> list(ActQueryParam actQueryParam);


    /**
     * 新增活动
     */
    //@Insert("insert into activity(name, type_id, start_time, end_time, location, max_people, description, status, create_time, creator_id) values(#{name},#{typeId},#{startTime},#{endTime},#{location},#{maxPeople},#{description},#{status},#{createTime},#{creatorId})")
    void insert(Activity activity);



    /**
     * 批量删除活动
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据id查询活动信息
     */
    Activity getById(Integer id);


    /**
     * 修改活动信息
     */

    void updateById(Activity activity);


    /**
     * 统计活动类型
     */
    List<Map<String,Object>> countActivityTypeData();

    /**
     * 根据创建者id查询活动信息
     */
    List<Activity> getByCreatorId(Integer creatorId);

    /**
     * 修改活动当前人数
     */
    void updateCurrentPeople(Integer activityId);

    /**
     * 修改活动当前人数（减少）
     */
    void updateCurrentPeople2(Integer activityId);
}
