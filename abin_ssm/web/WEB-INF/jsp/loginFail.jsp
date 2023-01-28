<%--
  Created by IntelliJ IDEA.
  User: UncleHippo
  Date: 2023/1/28
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<html>
<head>
    <title>login_fail</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12" style="text-align: center">
            <img src="${pageContext.request.contextPath}/image/Snipaste_2021-11-11_13-58-16.jpg" alt="登录失败">
        </div>
        <br>
        <br>
        <div id="btn1" class="col-md-12">
            <div style="text-align: center">
                <a class="btn btn-default" href="${pageContext.request.contextPath}/user/toLogin">返回登录界面</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
