<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>hello</title>
</head>
<body>
<h1>Hello World!</h1>
<div><p>This is the first page!</p></div>
<a href="./login">login page</a>
<#if Session.SPRING_SECURITY_CONTEXT?exists>
<div>user:${Session.SPRING_SECURITY_CONTEXT.authentication.principal.username!"null"}</div>
</#if>


<@security.authorize access="hasRole('ROLE_ADMIN')">
   admin will see
</@security.authorize>
</body>
</html>