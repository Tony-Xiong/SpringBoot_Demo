<#import "/spring.ftl" as spring />
<script type="application/javascript">
    function logout() {
        $("#logout").submit();
    }
</script>
<form id="logout" action="<@spring.url '/logout' />" method="POST" >
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a id="index" class="navbar-brand" href="<@spring.url '/'/>">首页</a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <li id="blogs" class=""><a href="<@spring.url '/listAllArticleView'/>">全部博客</a></li>
                <li id="myblogs" class=""><a href="<@spring.url '/listMyArticleView'/>">我的博客</a></li>
                <li id="write" class=""><a href="<@spring.url '/addArticleView'/>">写文章</a></li>
                <li id="about"><a href="#">关于</a></li>
                <#if Session.SPRING_SECURITY_CONTEXT??>
                <li class="dropdown">
                    <a href="http://www.jianshu.com/nb/12976878" class="dropdown-toggle" data-toggle="dropdown">
                        ${Session.SPRING_SECURITY_CONTEXT.authentication.principal.username} <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#" target="_blank">我的信息</a></li>
                        <li class="divider"></li>
                        <li><a href="#">修改用户信息</a></li>
                        <li><a href="#">个人博客</a></li>
                        <li><a href="#">个人信息</a></li>
                        <li class="divider"></li>
                        <li><a href="javascript:logout()">注销</a></li>
                        <li></li>
                    </ul>
                </li>
                <#else>
                <li><a href="/login">Login</a></li>
                </#if>
            </ul>
        </div>
    </div>
</nav>
