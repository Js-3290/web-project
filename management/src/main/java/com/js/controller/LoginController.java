package com.js.controller;


import com.js.pojo.LoginInfo;
import com.js.pojo.Result;
import com.js.pojo.User;
import com.js.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private  UserService userService;

    @PostMapping
    public Result login(@RequestBody User user) {
        log.info("用户登录：{}", user);
        LoginInfo loginInfo=userService.login(user);
        if (loginInfo != null) {
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误");

    }

}
