<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/jsp/templates/header.jsp" />
<html>
<head>
</head>
<body>
<h1>Login</h1>
<form action="/user/sign-in.do" method="post">
    <div>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" autocomplete="off" required />
    </div>
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" autocomplete="off" required />
    </div>
    <div>
        <button type="submit">Login</button>
    </div>
</form>
</body>
</html>