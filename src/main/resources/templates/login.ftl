<#import "/spring.ftl" as spring />
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>login</title>
    <link rel="stylesheet" href="<@spring.url '/css/bootstrap.css' />">
    <link rel="stylesheet" href="<@spring.url '/css/signin.css' />">
    <style type="text/css">
        body {
            padding-top: 50px;
        }

        .starter-template {
            padding: 40px 15px;
            text-align: center;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Spring Security演示</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">首页</a></li>
                <li><a href="/register/new">注册</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="starter-template">
 <#--       <#assign logout ></#assign>
        <#if logout= 0><p  class="bg-warning">已注销</p>
        <#elseif error != 0><p  class="bg-danger">有错误，请重试</p>
        </#if>-->
        <h2>使用账号密码登录</h2>
        <form class="form-signin" role="form" name="form" action="<@spring.url '/login' />" method="POST">
            <div class="form-group">
                <label for="username">账号</label>
                <input type="text" class="form-control" name="username" value="" placeholder="账号"/>
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" name="password" placeholder="密码"/>
            </div>
            <input type="submit" id="login" name="submit" class="btn btn-primary"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
        </form>
    </div>
</div>
</body>
</html>