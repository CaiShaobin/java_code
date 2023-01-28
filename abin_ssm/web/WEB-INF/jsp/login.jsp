<%--
  Created by IntelliJ IDEA.
  User: UncleHippo
  Date: 2023/1/28
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<html>
<style>
    h1{
        width: 180px;
        height: 38px;
        margin: 100px auto;
        text-align:center;
    }
</style>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/js/jquery-3.1.1.min.js"></script>
<script>
    function login() {
        $.ajax({
           type: "POST",
           url: "${pageContext.request.contextPath}/user/login",
           data: {
               username : $("#username").val(),
               password : $("#password").val()
           },
           dataType: "json",
           success: function (data) {
                if (data.toString() === '200'){
                    location.href = "${pageContext.request.contextPath}/book/allBook"
                }else {
                    location.href = "${pageContext.request.contextPath}/user/loginFail"
                }
           }
        });
    }
</script>
<head>
    <title>login</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>Abin_Books</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-3 column"></div>
        <div class="col-md-6 column">
            <form action="" method="post">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名" required>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码" required>
                </div>
                <div style="text-align: center">
                    <button type="submit" class="btn btn-default" onclick="return login(this)">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
