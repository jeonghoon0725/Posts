<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/jsp/templates/header.jsp" />
<html>
<head>
<title></title>
<script type="text/javascript">

    $(document).ready(function(){

        searchBlog();


    });

    function searchBlog() {
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

                    blogTableHtml += "<td>" + formatDate(blog.cdate) + "</td>";
                    blogTableHtml += "<td>" + formatDate(blog.mdate) + "</td>";
                    //blogTableHtml += "<td>" + blog.cdate + "</td>";
                    //blogTableHtml += "<td>" + blog.mdate + "</td>";

                    // Actions 열에 버튼 추가
                    blogTableHtml += "<td>";
                    blogTableHtml += "<button onclick='viewBlog(" + blog.id + ")'>View</button> ";
                    blogTableHtml += "<button onclick='editBlog(" + blog.id + ")'>Edit</button> ";
                    blogTableHtml += "<button onclick='deleteBlog(" + blog.id + ")'>Delete</button>";
                    blogTableHtml += "</td>";

                    blogTableHtml += "</tr>";
                });
            } else {
                blogTableHtml = "<tr><td colspan='7'>No blogs available.</td></tr>";
            }

            // 생성된 HTML을 테이블의 tbody에 추가
            $("#blogTable tbody").html(blogTableHtml);
        });
    }

    function viewBlog(postId) {
        console.log(postId)
    }
    function editBlog(id) {
        var row = $("#blogTable tr").filter(function() {
            return $(this).find("td:first").text() == id;
        });

        row.find("td").each(function(index) {
            if (index > 0 && index < 4) { // title, writer, contents 열만 수정 가능
                var content = $(this).text();
                $(this).html('<input type="text" value="' + content + '"/>');
            }
        });

        var saveButton = '<button onclick="saveBlog(' + id + ')">Save</button>';
        row.find("td:last").html(saveButton); // Actions 열에 Save 버튼 추가
    }

    function saveBlog(id) {
        var row = $("#blogTable tr").filter(function () {
            return $(this).find("td:first").text() == id;
        });

        var updatedData = {
            id: id,
            title: row.find("td:eq(1) input").val(),
            writer: row.find("td:eq(2) input").val(),
            contents: row.find("td:eq(3) input").val(),
        };

        console.log(updatedData)

        $.ajax({
            url: "/blog/update",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(updatedData),
            success: function (response) {
                alert("Blog updated successfully!");
                console.log(response)
                searchBlog();

                // 페이지 새로고침 또는 갱신 필요
            }
        });
    }

    function deleteBlog(postId) {
        console.log(postId)
    }
</script>
</head>
<body>
<h1>main</h1>
<button onclick="searchBlog()">전체조회</button>
<table id="blogTable" border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Writer</th>
        <th>Contents</th>
        <th>Created Date</th>
        <th>Updated Date</th>
        <th>Actions</th> <!-- Actions 열 추가 -->
    </tr>
    </thead>
    <tbody>
    <!-- 블로그 데이터가 여기에 추가될 예정 -->
    </tbody>
</table>

</body>
</html>