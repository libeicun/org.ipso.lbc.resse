<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  ~ 版权所有 (c) 2015 。 李倍存 （iPso）。
  ~ 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
  ~ 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
  --%>

<%--
  Created by IntelliJ IDEA.
  User: LBC
  Date: 2015/1/15
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
<shiro:hasRole name="user">
    <jsp:forward page="index.jsp"/>
</shiro:hasRole>
<shiro:hasRole name="adm">
    <jsp:forward page="adm/adm_home.jsp"/>
</shiro:hasRole>
</body>
</html>
