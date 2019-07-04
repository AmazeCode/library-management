<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/loading.jsp" %>
<html>
<head>
    <title>MYLIBRARY-应用管理</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="<%=basePath%>/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/static/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>/static/dist/css/AdminLTE.min.css">
    <link rel="shortcut icon" href="<%=basePath%>/static/favicon.ico"/>
    <link rel="stylesheet" href="<%=basePath%>/static/bower_components/jquery-easyui/themes/metro/easyui.css">
    <link rel="stylesheet" href="<%=basePath%>/static/bower_components/jquery-easyui/themes/icon.css">
    <link rel="stylesheet" href="<%=basePath%>/static/bower_components/jquery-easyui/themes/color.css">
    <style>
        .datagrid-header-row, .datagrid-row {
            height: 45px;
        }
        body {
            font-family: verdana, helvetica, arial, sans-serif;
        }
    </style>
</head>
<body>

<section class="content-header">
    <h1>
        应用管理
        <small>应用管理</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i>系统管理</a></li>
        <li class="active">应用管理</li>
    </ol>
</section>

<section class="content container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="box box-info" style="margin-bottom: 2px">
                <%--idField：关键字段标识数节点不能重复；treeField：数节点名称;fitColumns:;collapsible:true,//收起表格的内容--%>
                <table id="permissionList" class="easyui-treegrid" width="100%"
                       data-options="url:'<%=basePath%>/permission/list',idField:'id',
                       treeField:'permissionName',fitColumns:true,singleSelect:false,
                       rownumbers:true,collapsible:true,showGroup:true">
                    <thead>
                    <%-- 复选框 --%>
                    <th field="ck" checkbox="true"></th>
                    <th field="permissionName" width="250" align="center">应用名称</th>
                    <th field="permissionUrl" width="250" align="center">应用URL</th>
                    <th field="icon" width="250" align="center" formatter="formatPermissionIcon">应用图标</th>
                    <th field="createTime" width="250" align="center">创建时间</th>
                    <th field="updateTime" width="250" align="center">更新时间</th>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</section>

<!-- jQuery 3 -->
<script src="<%=basePath%>/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<%=basePath%>/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=basePath%>/static/dist/js/adminlte.min.js"></script>
<!-- jquery easyui -->
<script src="<%=basePath%>/static/bower_components/jquery-easyui/jquery.easyui.min.js"></script>
<script src="<%=basePath%>/static/bower_components/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>

<script src="<%=basePath%>/static/js/loading.js"></script>

<script>
    function formatPermissionIcon(value, row) {
        return "<i class='" + row.icon + "'></i>"
    }
</script>
</body>
</html>
