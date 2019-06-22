<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>导航菜单</title>
</head>
<body>
<!-- Sidebar Menu -->
<ul class="sidebar-menu" data-widget="tree">
    <li class="header">导航菜单</li>
    <!-- Optionally, you can add icons to the links -->
    <c:forEach items="${rootPermission.children}" var="permission">

        <c:if test="${empty permission.children}">
            <li>
                <a href="javascript:void(0);" class="mainMenu" data-src="<%=basePath%>${permission.permissionUrl}">
                    <i class="${permission.icon}"></i>
                    <span>${permission.permissionName}</span>
                </a>
            </li>
        </c:if>
        <c:if test="${not empty permission.children }">
            <li class="treeview">
                <a href="javascript:void(0);"><i class="${permission.icon}"></i>
                    <span>${permission.permissionName}</span>
                    <span class="pull-right-container">
                                 <i class="fa fa-angle-left pull-right"></i>
                                </span>
                </a>
                <ul class="treeview-menu">
                    <c:forEach items="${permission.children}" var="child">
                        <li>
                            <a href="javascript:void(0);" class="mainMenu"
                               data-src="<%=basePath%>${child.permissionUrl}">
                                <i class="${child.icon}"></i>
                                    ${child.permissionName}
                            </a>
                        </li>
                    </c:forEach>

                </ul>
            </li>
        </c:if>
    </c:forEach>
</ul>
</body>
</html>
