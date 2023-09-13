package com.example.javaweb.demo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/**
 * This is a simple example of an HTTP Servlet.
 * 生命週期: init() -> service() -> destroy()
 */
@WebServlet(name = "testServlet", value = "/test")
public class TestServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        var out = servletResponse.getWriter();
        out.println("<html><body>");
        out.println("<h1>"+ servletRequest.getParameter("name") +"</h1>");
        out.println("</body></html>");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
