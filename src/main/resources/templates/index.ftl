<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!doctype html>
<html lang="en">
<head>
 <#include "blog/common/head.ftl">
    <link rel="stylesheet" href="/static/css/jquery.dataTables.min.css">
    <script src="/static/js/dataTables/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="/static/blog/blog.css">
    <script src="/static/blog/blog.js"></script>
    <title>首页</title>
</head>
<body>
<#include "blog/common/navbar.ftl">
<div class="container">
    <div>用户列表</div>
    <div>博客统计</div>
    <div>Markdown 介绍</div>
</div>
<@security.authorize access="hasRole('ROLE_ADMIN')">
   管理员的功能
</@security.authorize>


</body>
</html>

