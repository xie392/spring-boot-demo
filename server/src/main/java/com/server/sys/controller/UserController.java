package com.server.sys.controller;

import com.server.common.Result;
import com.server.sys.entity.User;
import com.server.sys.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YuHong
 * @since 2023-09-13
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result<Map<String,Object>> login(@RequestBody User user) {
        return userService.login(user);
    }
}
