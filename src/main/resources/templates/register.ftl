<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#include "blog/common/head.ftl">
    <title>login</title>
    <style type="text/css">
        input{
            width:100%;
        }
        textarea{
            width: 100%;
        }
    </style>
</head>
<body>
<#include "common/navbar.ftl">
<div class="container">
    <div class="starter-template">
        <form id="login" name="user" action="./reg" method="post">
            <div class="col-md-8 table-responsive text-right">
                <table class="table table-striped">
                    <tr>
                        <td class="col-md-2">用户名：</td><td class="col-md-5"><input id="name" name="loginName"></td>
                    </tr>
                    <tr>
                        <td>密 码：</td><td><input id="passwd" name="passwd"></td>
                    </tr>
                    <tr>
                        <td>中文名：</td><td><input id="cname" name="cname"></td>
                    </tr>
                    <tr>
                        <td>英文名：</td><td><input id="ename" name="ename"></td>
                    </tr>
                    <tr>
                        <td>住 址：</td><td><input id="address" name="address"></td>
                    </tr>
                    <tr>
                        <td>博 客：</td><td><input id="blog" name="blog"></td>
                    </tr>
                    <tr>
                        <td>Email：</td><td><input id="email" name="email"></td>
                    </tr>
                    <tr>
                        <td>爱 好：</td><td><input id="hobby" name="hobby"></td>
                    </tr>
                    <tr>
                        <td>手 机：</td><td><input id="mobile" name="mobile"></td>
                    </tr>
                    <tr>
                        <td>个人首页：</td><td><input id="webPage" name="webPage"></td>
                    </tr>
                    <tr>
                        <td>facebook：</td><td><input id="facebook" name="facebook"></td>
                    </tr>
                    <tr>
                        <td>github：</td><td><input id="github" name="github"></td>
                    </tr>
                    <tr>
                        <td>自我介绍：</td><td><textarea id="introduce" name="introduce" placeholder="自我介绍"></textarea></td>
                    </tr>
                    <input name="roleId" value="2" type="hidden">
                    <input name="role" value="ROLE_USER" type="hidden">
                    <tr>            <td colspan="2"><input type="submit" value="注册" ></td>

                    </tr>
                </table>
            </div>
            <div class="col-md-4">
                <img src="/static/images/img1.jpg">
            </div>
        </form>
    </div>
</div>
</body>
</html>