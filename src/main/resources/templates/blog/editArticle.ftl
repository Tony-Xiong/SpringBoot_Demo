<!DOCTYPE html>
<html>
<head>
<#include "common/head.ftl">
    <script src="/static/blog/editArticle.js"></script>
</head>
<body>
<#include "common/navbar.ftl">
<div class="container">
    <h3>修改文章</h3>

    <form id="addArticleForm" class="form-horizontal">
        <div class="form-group">
            <input type="text" name="title" class="form-control" placeholder="文章标题" value="${article.title}">
        </div>
        <input name="id" value="${article.id}" type="hidden">
        <input name="version" value="${article.version}" type="hidden">
        <input name="gmtCreated" value="${article.gmtCreated}" type="hidden">
        <div class="form-group">
            <#--<textarea id="articleContentEditor" type="text" name="content" class="form-control" rows="20"-->
                      <#--placeholder="">${article.content}</textarea>-->
            <textarea id="articleContentEditor" type="text" name="content" class="form-control" rows="20" placeholder="">${article.content}</textarea>
        </div>
        <div class="form-group save-article">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary" id="addArticleBtn">修改并发表</button>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</div>
</body>
</html>