package com.example.javaweb.demo;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 * This is a simple example of an HTTP Servlet.
 * 生命週期: init() -> service() -> destroy()
 */
@WebServlet(name = "helloServlet", value = "/hello", loadOnStartup = 1, initParams = {
        @WebInitParam(name = "name", value = "value")
})
public class HelloServlet extends HttpServlet {
    private String message;
    private String name;

    public void init() {
        message = "Hello World!";
    }

    public void init(ServletConfig servletConfig) {
        message = "Hello World!";
        name = servletConfig.getInitParameter("name");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + request.getParameter("name") + "</h1>");
        out.println("</body></html>");
    }


    public void destroy() {
    }
}