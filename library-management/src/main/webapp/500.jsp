<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    //形式：http://localhost:8080/book
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <title>MYLIBRARY-500</title>
    <link rel="shortcut icon" href="<%=basePath%>/static/favicon.ico"/>
    <style>
        html, body {
            height: 100%;
            width: 100%;
        }

        .error-500 {
            background-image: url("/static/image/500.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            height: auto;
            overflow: hidden;
        }
    </style>
</head>
<body class="error-500">

</body>
</html>
