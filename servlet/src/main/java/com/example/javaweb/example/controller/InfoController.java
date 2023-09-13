package com.example.javaweb.example.controller;

import com.example.javaweb.example.entity.InfoEntity;
import com.example.javaweb.example.service.InfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "infoServlet", value = "/info")
public class InfoController extends HttpServlet {

    private InfoService service = new InfoService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<InfoEntity> list = service.getAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(list);

            // 设置响应的内容类型为JSON
            response.setContentType("application/json");

            // 将JSON数据写入响应
            PrintWriter out = response.getWriter();
            out.print(json);
            // 转发到 jsp 中
//            request.setAttribute("list", list);
//            request.getRequestDispatcher("/info.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
