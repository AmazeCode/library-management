<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    //形式：http://localhost:8080/book
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <title>MYLIBRARY-403</title>
    <link rel="shortcut icon" href="<%=basePath%>/static/favicon.ico"/>
    <style>
        html, body {
            height: 100%;
            width: 100%;
        }

        .error403 {
            background-image: url("/static/image/403.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            height: auto;
            overflow: hidden;
        }
    </style>
</head>
<body class="error403">

</body>
</html>
