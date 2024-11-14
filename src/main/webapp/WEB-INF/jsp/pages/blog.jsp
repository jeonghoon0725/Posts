<%--<%@ page contentType="text/html; charset=UTF-8" language="java" %>--%>
<%--<jsp:include page="/WEB-INF/jsp/templates/header.jsp" />--%>
<%--<html>--%>
<%--<head>--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<script type="text/javascript">

    $(document).ready(function(){
        $.get("/blog", function(data) {
            var blogTableHtml = "";
            // 데이터가 있을 경우
            if (data.length > 0) {
                data.forEach(function(blog) {
                    blogTableHtml += "<tr>";
                    blogTableHtml += "<td>" + blog.id + "</td>";
                    blogTableHtml += "<td>" + blog.title + "</td>";
                    blogTableHtml += "<td>" + blog.writer + "</td>";
                    blogTableHtml += "<td>" + blog.contents + "</td>";
                    blogTableHtml += "<td>" + blog.cdate + "</td>";
                    blogTableHtml += "</tr>";
                });
            } else {
                blogTableHtml = "<tr><td colspan='5'>No blogs available.</td></tr>";
            }

            // 생성된 HTML을 테이블의 tbody에 추가
            $("#blogTable tbody").html(blogTableHtml);
        });
    });
</script>
</head>
<body>
<h1>main</h1>
<table id="blogTable" border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Writer</th>
        <th>Contents</th>
        <th>Created Date</th>
    </tr>
    </thead>
    <tbody>
    <!-- 블로그 데이터가 여기에 추가될 예정 -->
    </tbody>
</table>

</body>
</html>