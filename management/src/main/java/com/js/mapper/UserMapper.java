package com.js.mapper;

import com.js.pojo.User;
import com.js.pojo.UserQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("SELECT id, username, password, name, gender, role, phone, create_time FROM user where role=1 order by create_time desc")
    List<User> findAll();

    /**
     * 根据id删除用户
     * @param
     */
    @Delete("DELETE FROM user WHERE id=#{id}")
    void deleteById(Integer id);

    /**
     * 添加用户
     * @param
     */
    @Insert("insert into user(username, password, name, gender, role, phone,create_time) values(#{username},#{password},#{name},#{gender},#{role},#{phone},#{createTime})")
    void insert(User user);

    /**
     * 根据id查询用户
     * @param
     * @return
     */
    @Select("SELECT id, username, password, name, gender, role, phone, create_time FROM user where id=#{id}")
    User getById(Integer id);

    /**
     * 修改用户
     * @param
     */
    @Insert("update user set username=#{username},password=#{password},name=#{name},gender=#{gender},phone=#{phone} where id=#{id}")
    void update(User user);

    /**
     * 查询用户性别数据
     * @return
     */

    List<Map<String, Option>> countUserGenderData();

    /**
     * 根据用户名和密码查询用户
     *
     * @param user
     * @return
     */
    @Select("select id, username, name from user where username=#{username} and password=#{password}")
    User selectByUsernameAndPassword(User user);


    /**
     * 分页查询用户
     *
     * @param userQueryParam
     * @return
     */

    List<User> list(UserQueryParam userQueryParam);


    /**
     * 批量删除用户
     *
     * @param ids
     */
    void deleteByIds(List<Integer> ids);
}
