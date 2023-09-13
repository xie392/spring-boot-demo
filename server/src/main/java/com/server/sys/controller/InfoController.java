package com.server.sys.controller;

import com.server.common.Result;
import com.server.sys.entity.Info;
import com.server.sys.service.impl.InfoServiceImpl;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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
public class InfoController {
    @Resource
    private InfoServiceImpl infoService;
    @RequestMapping("/infoList")
    public Result<List<Info>> findAll() {
        return infoService.findAll();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<Info> Add(@RequestBody Info info)  {
        return infoService.add(info);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PATCH)
    public Result Update(@RequestBody Info info) {
        return infoService.update(info);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Result Delete(@PathVariable("id") String id) {
        return infoService.delete(id);
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public Result<List<Info>> Search(@RequestParam("name") String name) {
        return infoService.search(name);
    }
}
