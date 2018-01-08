<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!doctype html>
<html lang="en">
<head>
 <#include "blog/common/head.ftl">
    <link rel="stylesheet" href="/static/css/jquery.dataTables.min.css">
    <script src="/static/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="/static/blog/blog.css">
    <script src="/static/blog/blog.js"></script>
    <title>首页</title>
</head>
<body>
<#include "blog/common/navbar.ftl">
<div class="container">
    <div class="col-12 col-md-9">
        <div class="jumbotron">
            <h4>Hello,Markdown Blog!</h4>
            <p>This is a Blog website with Markdown!<br>You can write your blog with Markdown.</p>
        </div>
        <div class="boarder-bottom">
        <h3>Markdown 介绍</h3>
        </div>
        <#include "common/MDBasics.ftl">
    </div>


    <div class="col-6 col-md-3">
        <div>
            <table class="table table-hover">
                <thead>
                <th>用户列表</th>
                </thead>
                <tbody>
                <#if users??>
                <#list users as user>
                    <tr>
                        <td>${user.username}</td>
                    </tr>
                </#list>
                </#if>
                </tbody>
            </table>
        </div>
        <div>
            <table class="table">
                <thead>
                <th>
                    统计信息
                </th>
                </thead>
                <tbody>
                <tr>
                    <td colspan="2"><label>博客总数:${sum}</label></td>
                </tr>
                </tbody>
            </table>
        </div>
    <@security.authorize access="hasRole('ROLE_ADMIN')">
    <div>管理员的功能</div>
    </@security.authorize>
    </div>
</div>

<#include "blog/common/footer.ftl">
</body>
</html>

