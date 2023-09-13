package com.mybatis.service;

import com.mybatis.entity.InfoEntity;
import com.mybatis.mapper.InfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InfoService {
    private InfoMapper infoMapper;
    private SqlSession sqlSession;

    public InfoService() throws IOException {
        String resources = "mybatis-config.xml";
        // 1. 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resources);
        // 2. 创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4. 执行sql语句
        InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);

        this.infoMapper = infoMapper;
        this.sqlSession = sqlSession;

        // sqlSession.close();
    }

    public List<InfoEntity> getInfoList() {
        return infoMapper.getInfoList();
    }

    public InfoEntity getInfoById(String id) {
        return infoMapper.getInfoById(id);
    }

    public int insertInfo(InfoEntity infoEntity) {
        int result = infoMapper.insertInfo(infoEntity);
        // 提交事务
        sqlSession.commit();
        return result;
    }

    public int updateInfo(InfoEntity infoEntity) {
        int result = infoMapper.updateInfo(infoEntity);
        // 提交事务
        sqlSession.commit();
        return result;
    }

    public int deleteInfo(String id) {
        int result = infoMapper.deleteInfo(id);
        // 提交事务
        sqlSession.commit();
        return result;
    }

    public List<InfoEntity> getInfoSearch(InfoEntity infoEntity) {
        return infoMapper.getInfoSearch(infoEntity);
    }
}


