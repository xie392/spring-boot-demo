package com.server.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.server.common.Result;
import com.server.sys.entity.User;
import com.server.sys.mapper.UserMapper;
import com.server.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author YuHong
 * @since 2023-09-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    public Result<Map<String,Object>> login(User user) {
        // 查询用户名和密码是否正确
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", user.getName());
        queryWrapper.eq("password", user.getPassword());
        List<User> users = userMapper.selectList(queryWrapper);

        if (users.size() == 0) {
            return Result.error("用户名或密码错误");
        }

        Map<String,Object> data = Map.of("name", user.getName(), "token", "admin-token");

        return Result.success(data);
    }
}
