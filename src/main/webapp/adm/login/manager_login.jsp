<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  ~ 版权所有 (c) 2015 。 李倍存 （iPso）。
  ~ 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
  ~ 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
  --%>

<%--
  Created by IntelliJ IDEA.
  User: LBC
  Date: 2015/1/16
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
  <div class="headers-region">
    <div class="header_link">
      <a href="http://w.mail.qq.com/cgi-bin/loginpage?f=xhtml">基本版</a>&nbsp;|&nbsp;<a href="http://en.mail.qq.com">English</a>&nbsp;|&nbsp;<a href="http://app.mail.qq.com/" target="_blank">手机版</a>&nbsp;|&nbsp;<a href="http://exmail.qq.com?referrer=index_top" target="_blank">企业邮箱</a>
    </div>
  </div>
  <div  class="content">
    <s:form action="admLogin" namespace="/login" theme="xhtml">
      <s:textfield name="adm.username" label="用户名"></s:textfield>
      <s:textfield name="adm.password" label="密码"></s:textfield>
      <s:submit label="登录"></s:submit>
    </s:form>
  </div>
</div>

</body>
</html>
