package com.mybatis.mapper;

import com.mybatis.entity.InfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InfoMapper {
    List<InfoEntity> getInfoList();

    InfoEntity getInfoById(@Param("id") String id);

    int insertInfo(InfoEntity infoEntity);

    int updateInfo(InfoEntity infoEntity);

    int deleteInfo(String id);

     List<InfoEntity> getInfoSearch(InfoEntity infoEntity);
}
