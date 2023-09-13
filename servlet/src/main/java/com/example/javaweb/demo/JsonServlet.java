package com.example.javaweb.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用的是 jackson
 * 通常配合 jackson-databind、jackson-annotations、jackson-core 三個套件使用
 */
@WebServlet(name = "jsonServlet", value = "/json")
public class JsonServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, Object> user = new HashMap<>();
        user.put("username", "admin");
        user.put("password", "123456");

        // 使用Jackson将Java对象序列化为JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        // 设置响应的内容类型为JSON
        response.setContentType("application/json");

        // 将JSON数据写入响应
        PrintWriter out = response.getWriter();
        out.print(json);
    }

}
