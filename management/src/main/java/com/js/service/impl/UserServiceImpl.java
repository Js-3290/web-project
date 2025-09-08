package com.js.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.js.controller.ActController;
import com.js.mapper.UserMapper;
import com.js.pojo.*;
import com.js.service.UserService;
import com.js.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void add(User user) {
        //补全基础属性
       user.setCreateTime(LocalDateTime.now());
        user.setRole(1);
        user.setPassword("123456");
        userMapper.insert(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public LoginInfo login(User user) {
        //根据用户名和密码查询信息
        User u = userMapper.selectByUsernameAndPassword(user);
        //判断是否存在，如果存在，返回登录信息
        if (u != null) {
            //生成jwt令牌
            Map<String, Object> claims = new HashMap<>();

            claims.put("id", u.getId());
            claims.put("username", u.getUsername());

            String token = JwtUtils.generateToken(claims);

            return new LoginInfo(u.getId(), u.getUsername(), u.getName(), token);
        }
        //否则返回null

        return null;
    }

    @Override
    public PageResult<User> list(UserQueryParam userQueryParam) {
        //设置分页参数
        PageHelper.startPage(userQueryParam.getPage(),userQueryParam.getPageSize());

        //查询
        List<User> userList=userMapper.list(userQueryParam);


        Page<User> p=(Page<User>)userList;


        //解析结果并封装

        return new PageResult<User>(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        userMapper.deleteByIds(ids);
    }


}
