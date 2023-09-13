<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<p style="display: flex; flex-direction: column; gap: 10px;">
    <a href="hello">Hello Servlet</a>
    <a href="test?name=zhangsan">Test Servlet</a>
    <a href="login.jsp">Login</a>
    <a href="json">Json Servlet</a>
    <a href="info.jsp">Info Table</a>
</p>
</body>
</html>