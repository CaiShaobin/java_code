<%--
  Created by IntelliJ IDEA.
  User: UncleHippo
  Date: 2023/1/16
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<html>
<style>
    .hide {
        display: none;
    }
</style>
<head>
    <title>更新书籍</title>
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>编辑书籍</small>
                    </h1>
                </div>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <div class="hide">
            <label for="bookName">书籍编号</label>
            <input type="text" name="bookId" class="form-control" id="bookId" value="${books.bookId}">
        </div>
        <div class="form-group">
            <label for="bookName">书籍名称</label>
            <input type="text" name="bookName" class="form-control" id="bookName" value="${books.bookName}">
        </div>
        <div class="form-group">
            <label for="bookCounts">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" id="bookCounts" value="${books.bookCounts}">
        </div>
        <div class="form-group">
            <label for="bookDesc">书籍描述</label>
            <input type="text" name="bookDesc" class="form-control" id="bookDesc" value="${books.bookDesc}">
        </div>
        <button type="submit" class="btn btn-default">提交修改</button>
    </form>
</body>
</html>
