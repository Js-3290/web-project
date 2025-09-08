package com.js.controller;

import com.js.pojo.*;
import com.js.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/users")
@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     *
     */

    //@GetMapping
    public Result list(){
        //System.out.println("查询全都的学生信息");
        log.info("查询全都的学生信息");
        List<User> userList=userService.findAll();
        return Result.success(userList);
    }


    @GetMapping
    public Result page(UserQueryParam userQueryParam){
        log.info("分页查询 {}",userQueryParam);
        PageResult<User> pageResult=userService.list(userQueryParam);
        return Result.success(pageResult);
    }



    /**
     * 根据id删除用户信息
     *
     */

    //@DeleteMapping
    public Result delete(Integer id){
        //System.out.println("根据id删除用户："+id);
        log.info("根据id删除用户：{}",id);
        userService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除用户信息
     *
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除 {}",ids);
        userService.delete(ids);
        return Result.success();
    }


    /**
     * 添加用户信息
     *
     */
    @PostMapping
    public Result add(@RequestBody User user){
        //System.out.println("添加用户："+user);
        log.info("添加用户：{}",user);
        userService.add(user);
        return Result.success();
    }

    /**
     * 根据id查询用户信息
     *
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        if (id == null) {
            return Result.error("用户ID不能为空");
        }
        log.info("查询用户id：{}",id);
        User user=userService.getById(id);
        return Result.success(user);
    }

    /**
     * 修改用户信息
     *
     */
    @PutMapping
    public Result update(@RequestBody User user){
        log.info("修改用户：{}",user);
        userService.update(user);
        return Result.success();
    }


}
