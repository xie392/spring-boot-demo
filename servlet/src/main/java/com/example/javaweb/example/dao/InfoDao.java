package com.example.javaweb.example.dao;

import com.example.javaweb.example.utils.mysqlConnection;

import com.example.javaweb.example.entity.InfoEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoDao {

    /**
     * 查询所有信息
     *
     * @return
     */
    public List<InfoEntity> getAll() throws SQLException {
        ArrayList<InfoEntity> AllList = new ArrayList<>();

        try {
            ResultSet res = mysqlConnection.query("select * from info");
            while (res.next()) {
                String name = res.getString("name");
                int age = res.getInt("age");
                String gender = res.getString("gender");
                String major = res.getString("major");
                // 添加到集合中
                AllList.add(new InfoEntity(name, age, gender, major));
            }
;
            return AllList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭连接
            mysqlConnection.close();
        }


    }
}
