<%--
  Created by IntelliJ IDEA.
  User: UncleHippo
  Date: 2022/12/30
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="${pageContext.request.getContextPath()}/login" method="get">
        用户名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        <input type="submit">
    </form>
</body>
</html>
