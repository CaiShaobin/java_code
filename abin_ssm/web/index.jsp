<%--
  Created by IntelliJ IDEA.
  User: Loggo
  Date: 2023/1/15
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
  a{
    text-decoration: none;
    color: black;
    font-size: 18px;
  }
  h3{
    width: 180px;
    height: 38px;
    margin: 100px auto;
    text-align:center;
    line-height: 38px;
    background: deepskyblue;
    border-radius: 5px;
  }
</style>
<html>
  <head>
    <title>Welcome</title>
  </head>

  <body>

      <h3>
        <a href="${pageContext.request.contextPath}/book/allBook">进入书籍管理页面</a>
      </h3>

  </body>
</html>
