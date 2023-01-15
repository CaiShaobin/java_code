<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Loggo
  Date: 2023/1/15
  Time: 14:30
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
<head>
    <title>All_Books</title>
</head>
<body>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>书籍展示</small>
                    </h1>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-default" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>书籍编号</th>
                            <th>书籍名称</th>
                            <th>书籍数量</th>
                            <th>书籍详情</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="book">
                            <tr>
                                <th>${book.bookId}</th>
                                <th>${book.bookName}</th>
                                <th>${book.bookCounts}</th>
                                <th>${book.bookDesc}</th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
