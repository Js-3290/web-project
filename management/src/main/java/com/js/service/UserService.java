package com.js.service;


import com.js.pojo.LoginInfo;
import com.js.pojo.PageResult;
import com.js.pojo.User;
import com.js.pojo.UserQueryParam;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id删除用户
     * @param
     */
    void deleteById(Integer id);

    /**
     * 添加用户
     * @param
     */
    void add(User user);

    /**
     * 根据id查询用户
     * @param
     * @return
     */
    User getById(Integer id);

    /**
     * 修改用户
     * @param
     */
    void update(User user);

    /**
     * 登录
     * @param
     * @return
     */
    LoginInfo login(User user);


    /**
     * 分页查询
     * @param
     * @return
     */
    PageResult<User> list(UserQueryParam userQueryParam);


    /**
     * 批量删除
     * @param
     */
    void delete(List<Integer> ids);
}
