package com.example.javaweb.example.service;

import com.example.javaweb.example.dao.InfoDao;
import com.example.javaweb.example.entity.InfoEntity;

import java.sql.SQLException;
import java.util.List;

public class InfoService {
    private InfoDao infoDao = new InfoDao();

    public List<InfoEntity> getAll() throws SQLException {
        List<InfoEntity> list = infoDao.getAll();
        return list;
    }
}
