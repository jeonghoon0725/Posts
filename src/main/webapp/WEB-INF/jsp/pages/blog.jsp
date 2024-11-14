<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/jsp/templates/header.jsp" />
<html>
<head>
<script type="text/javascript">
    $(document).ready(function(){

    });
</script>
</head>
<body>
<h1>main</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Writer</th>
        <th>Contents</th>
        <th>Created Date</th>
        <th>Updated Date</th>
    </tr>
    </thead>
    <tbody>
    <!-- blogs 리스트를 순회하면서 출력 -->
    <c:forEach var="blog" items="${blogs}">
        <tr>
            <td>${blog.id}</td>
            <td>${blog.title}</td>
            <td>${blog.writer}</td>
            <td>${blog.contents}</td>
            <td>${blog.cdate}</td>
            <td>${blog.mdate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>