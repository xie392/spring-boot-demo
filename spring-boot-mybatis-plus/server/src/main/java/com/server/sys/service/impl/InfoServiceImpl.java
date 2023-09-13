package com.server.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.server.common.Result;
import com.server.sys.entity.Info;
import com.server.sys.entity.User;
import com.server.sys.mapper.InfoMapper;
import com.server.sys.mapper.UserMapper;
import com.server.sys.service.IInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author YuHong
 * @since 2023-09-13
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {
    @Resource
    private InfoMapper infoMapper;

    public Result<List<Info>> findAll() {
        List<Info> list = infoMapper.selectList(null);
        return Result.success(list);
    }

    public Result<Info> add(Info info)  {
        // 生成随机唯一 id
        String id = String.valueOf(System.currentTimeMillis());
        Info InfoList = new Info(id,info.getName(),info.getAge(),info.getGender(),info.getMajor());
        int result = infoMapper.insert(InfoList);
        if(result == 0) {
            return Result.error("插入失败");
        }

        return Result.success(InfoList);
    }

    public Result update(Info info) {
        int result = infoMapper.updateById(info);
        if(result == 0) {
            return Result.error("更新失败");
        }

        return Result.success(null);
    }

    public Result delete(String id) {
        int result = infoMapper.deleteById(id);
        if(result == 0) {
            return Result.error("删除失败");
        }
        return Result.success(null);
    }

    public Result<List<Info>> search(String name) {
        QueryWrapper<Info> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name", name);
        // 模糊查询
        queryWrapper.like("name", name);
        List<Info> list = infoMapper.selectList(queryWrapper);
        return Result.success(list);
    }
}
