<html>
<head>
    <#include "common/head.ftl">
    <link rel="stylesheet" href="/static/css/jquery.dataTables.min.css">
    <script src="/static/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="/static/blog/blog.css">
    <script src="/static/blog/blog.js"></script>
</head>
<body>
<#include "common/navbar.ftl">
<script type="application/javascript">
    $("#myblogs").addClass("active");
</script>
<div class="container">
    <h1>${author}的博客</h1>
    <table id="articlesDataTable" class="table table-responsive table-bordered">
        <thead>
        <th>序号</th>
        <th>标题</th>
        <th>作者</th>
        <th>发表时间</th>
        <th>操作</th>
        </thead>
        <tbody>
        <#-- 使用FTL指令 -->
        <#list articles as article>
        <tr>
            <td>${article.id}</td>
            <td><a target="_blank" href="detailArticleView?id=${article.id}">${article.title}</a></td>
            <td>${article.author}</td>
            <td>${article.gmtModified}</td>
            <td><a href="editArticle?id=${article.id}" target="_blank">编辑</a></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>