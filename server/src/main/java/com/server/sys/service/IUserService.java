package com.server.sys.service;

import com.server.common.Result;
import com.server.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YuHong
 * @since 2023-09-13
 */
public interface IUserService extends IService<User> {

    public Result<Map<String,Object>> login(User user);

}
