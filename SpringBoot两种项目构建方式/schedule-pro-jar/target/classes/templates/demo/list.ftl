<html>
<head>
    <meta charset="utf-8">
    <title>freemarker+bootstrap学习</title>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="table-responsive">
        <table id="dataGrid" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th width="50"><input type="checkbox" class="checkall"></th>
                <th>标题</th>
                <th>姓名</th>
                <th>微信</th>
                <th width="50">操作</th>
            </tr>
            </thead>
            <tbody>
			<#list demoList as row>
            <tr>
                <td>
                    <input type="checkbox" name="id" value="${row.id}">
                </td>
                <td>${row.title}</td>
                <td>${row.name}</td>
                <td>${row.weChat}</td>
                <td>
                    <button class="btn btn-xs btn-primary"
                            onclick="deleteRow(${row.id})">删除
                    </button>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    function deleteRow(rowId) {
        console.log("点击了删除", rowId);
    }
</script>
</body>
</html>
