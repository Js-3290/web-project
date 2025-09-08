package com.js.service;

import com.js.pojo.ActQueryParam;
import com.js.pojo.Activity;
import com.js.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface ActService {
    /**
     * 分页查询
     *
     * @param
     * @return
     */
//    PageResult<Activity> list(Integer page, Integer pageSize, String name, Integer typeId,
//                              LocalDate begin, LocalDate end);

    PageResult<Activity> list(ActQueryParam actQueryParam);


    /**
     * 新增活动
     *
     * @param
     */
    void save(Activity activity);

    /**
     * 批量删除活动
     *
     * @param
     */
    void delete(List<Integer> ids);

    /**
     * 根据id查询活动
     *
     * @param
     * @return
     */
    Activity getInfo(Integer id);

    /**
     * 修改活动
     *
     * @param
     */
    void update(Activity activity);

    /**
     * 根据创建者id查询活动
     *
     * @param
     * @return
     */
    List<Activity> getByCreatorId(Integer creatorId);
}
