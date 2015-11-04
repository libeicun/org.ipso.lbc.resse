<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  ~ 版权所有 (c) 2015 。 李倍存 （iPso）。
  ~ 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
  ~ 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
  --%>

<%--<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>--%>

<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>

<html>
<head>



    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>
        欢迎<shiro:hasRole name="adm">, 管理员</shiro:hasRole>
    </title>

        <script src="resource/js/SpryMenuBar.js" type="text/javascript"></script>
        <link href="resource/css/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
        <link href="resource/css/menu-button.css" rel="stylesheet" type="text/css" />
        <link href="resource/css/menu-a.css" rel="stylesheet" type="text/css" />
</head>

<body>

<ul id="main-menu" class="MenuBarHorizontal">
    <li><a class="MenuBarItemSubmenu" href="#"><shiro:user><shiro:principal/></shiro:user><shiro:guest>欢迎，游客</shiro:guest></a>
        <ul>
            <shiro:user>
                <li class="menu-a"><a  onclick="go('manage/user/change-password.jsp');">修改密码</a></li>
                <li class="menu-a"><a  href="logout">退出登录</a></li>
            </shiro:user>
            <shiro:guest>
                <li class="menu-a"><a   href="login.jsp">登录</a></li>
            </shiro:guest>

        </ul>
    </li>

    <li><a class="MenuBarItemSubmenu" href="#">日常</a>
        <ul>
            <shiro:user>
                <li class="menu-a"><a   onclick="go('apps/lesson-record/lesson-record.jsp');">课程登记</a></li>
            </shiro:user>
            <li class="menu-a"><a   onclick="go('apps/general-register/general-register.jsp');">通用汇总</a></li>
        </ul>
    </li>

    <li><a class="MenuBarItemSubmenu" href="#">前往</a>
        <ul>
            <li class="menu-a"><a onclick="go('http://1.185.17.100/face/query.aspx');">刷脸统计</a></li>
        </ul>
    </li>

    <shiro:hasRole name="adm">
        <li><a class="MenuBarItemSubmenu" href="#">管理员</a>
            <ul class="menu-a">
                <li><a onclick="go('manage/admin/user-manage.jsp');">用户管理</a></li>
            </ul>
        </li>
    </shiro:hasRole>
</ul>


<div id="loading" style="display: none;position: absolute;width: 100%;text-align: center;font-size: medium;color: blue;font-weight: bold">正在加载...</div>
<iframe id="main-frame" src="start.jsp" style="width: 100%;height: 100%;"></iframe>

<script type="text/javascript">
    var mainFrameLoaded = true;
    mainFrame = document.getElementById('main-frame');
    if (mainFrame.attachEvent){
        mainFrame.attachEvent("onload", function(){
            mainFrameLoaded = true;
        });

    } else {
        mainFrame.onload = function(){
            mainFrameLoaded = true;
        };

    }
    setInterval(
            function(){
                var loading =  document.getElementById("loading");
                if(mainFrameLoaded == false){
                    loading.style.display = "block";
                }
                else{
                    loading.style.display = "none";
                }
            }
            ,
            500);
    var mainMenu = new Spry.Widget.MenuBar("main-menu", {imgDown:"resource/icon/SpryMenuBarDownHover.gif", imgRight:"resource/icon/SpryMenuBarRightHover.gif"});
    function go(href){
        mainFrameLoaded = false;
        document.getElementById("main-frame").src = href;
    }

</script>
</body>
</html>
