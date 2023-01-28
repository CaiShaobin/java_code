<%--
  Created by IntelliJ IDEA.
  User: Loggo
  Date: 2023/1/15
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<html>
<head>
    <title>Add_Book</title>
</head>

<style>
    h1{
        width: 180px;
        height: 38px;
        margin: 100px auto;
        text-align:center;
    }
</style>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>新增书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/book/addBook" method="post">
            <div class="form-group">
                <label for="bookName">书籍名称</label>
                <input type="text" name="bookName" class="form-control" id="bookName">
            </div>
            <div class="form-group">
                <label for="bookCounts">书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" id="bookCounts">
            </div>
            <div class="form-group">
                <label for="bookDesc">书籍描述</label>
                <input type="text" name="bookDesc" class="form-control" id="bookDesc">
            </div>
            <button type="submit" class="btn btn-default">提交修改</button>
        </form>
    </div>
</body>
</html>
