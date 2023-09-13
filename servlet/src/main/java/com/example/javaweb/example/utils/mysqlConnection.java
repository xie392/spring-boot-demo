package com.example.javaweb.example.utils;

import java.sql.*;

public class mysqlConnection {
    private static Connection connection;
    private static Statement stmt = null;

    public static void main(String[] args) {
        try {
            System.out.println("Connecting to database...");
            String url = "jdbc:mysql://localhost:3306/example_db";
            String user = "root";
            String password = "123456";
            String driver = "com.mysql.cj.jdbc.Driver";
            // 加载数据库驱动
            Class.forName(driver);
            // 获取数据库连接
            connection = DriverManager.getConnection(url, user, password);
            // 创建Statement对象
            stmt = connection.createStatement();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * 查询
     *
     * @param sql
     * @return
     */
    public static ResultSet query(String sql) throws SQLException {
        if(stmt == null) {
            main(null);
        }
        return stmt.executeQuery(sql);
    }

    /**
     * 增删改
     *
     * @param sql
     * @return
     */
    public static int update(String sql) throws SQLException {
        if(stmt == null) {
            main(null);
        }
        return stmt.executeUpdate(sql);
    }
}
