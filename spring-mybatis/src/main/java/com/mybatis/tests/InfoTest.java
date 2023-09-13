package com.mybatis.tests;

import com.mybatis.mapper.InfoMapper;
import com.mybatis.service.InfoService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.mybatis.entity.InfoEntity;

public class InfoTest {

    public static void main(String[] args) throws IOException {
        InfoService infoService = new InfoService();
        // 插入测试
//        infoService.insertInfo(new InfoEntity("4", "test", 10, "女", "测试专业"));
        // 删除测试
//        infoService.deleteInfo("4");
        // 更新测试
//        infoService.updateInfo(new InfoEntity("3", "update", 10, "女", "测试专业"));
        //  查询所有测试
//        List<InfoEntity> infoList = infoService.getInfoList();
        // 根据id查询测试
//        InfoEntity infoEntity = infoService.getInfoById("4");
        // 模糊查询测试
        List<InfoEntity> searchList =  infoService.getInfoSearch(new InfoEntity(null, "李四",null,null,null));
        // 打印结果
        System.out.println(searchList);
    }
}
