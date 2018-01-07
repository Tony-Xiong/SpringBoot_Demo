<!DOCTYPE html>
<html>
<head>
<#include "common/head.ftl">
    <script src="/static/blog/addArticleView.js"></script>
</head>
<body>
<#include "common/navbar.ftl">
<div class="container">
    <h3>写文章</h3>

    <form id="addArticleForm" class="form-horizontal">
        <div class="form-group">
            <input type="text" name="title" class="form-control" placeholder="文章标题">
        </div>

        <div class="form-group">
            <textarea id="articleContentEditor" type="text" name="content" class="form-control" rows="20"
                      placeholder=""></textarea>
        </div>
        <div class="form-group save-article">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary" id="addArticleBtn">保存并发表</button>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
</div>
</body>
</html>