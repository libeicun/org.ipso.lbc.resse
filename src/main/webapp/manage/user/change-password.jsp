<%--
  ~ 版权所有 (c) 2015 。 李倍存 （iPso）。
  ~ 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
  ~ 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
  --%>

<%--
  Created by IntelliJ IDEA.
  User: lbc
  Date: 2015/11/2
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="../../resource/js/json2.js" type="text/javascript"></script>
    <script src="../../resource/js/prototype-1.6.0.3.js" type="text/javascript"></script>
    <script type="text/javascript">
        function doChangePassword() {

            var url = '/resse-1.0/ajax_use_json/changePassword.action';

            var newPassword = document.getElementById("newPassword").value;
            var confirm = document.getElementById("confirm").value;
            if(newPassword != confirm){
                alert("输入的密码不一致。");
                return ;
            }

            var params = Form.serialize('change-password');
            var myAjax = new Ajax.Request(url,
                    {
                        method: 'post',
                        parameters: params,
                        onComplete: processChangePassword,
                        asynchronous: true
                    });
        }
        function processChangePassword(response) {
            var res = JSON.parse(response.responseText);
            if (res["warning"] == "OK") {
                alert("成功地修改了您的密码。");
            } else {
                alert(res["warning"]);
            }
        }
    </script>
</head>
<body>
修改密码
    <form id="change-password">
        <label>输入新密码</label><input id="newPassword" name="newPassword" type="password">
        <label>确认新密码</label><input id="confirm" type="password" value="">
        <input type="button" value="提交" onclick="doChangePassword();">
    </form>
</body>
</html>
