<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <title></title>
    <link href="../../resource/css/p-blue.css" rel="stylesheet" type="text/css" />
    <script src="../../resource/js/json2.js" type="text/javascript"></script>
    <script src="../../resource/js/prototype-1.6.0.3.js" type="text/javascript"></script>
    <style type="text/css">
    </style>
</head>

<body>
<img src="" id="im" style="width: 100%; height: 100%;">
<shiro:hasRole name="lbc">
    <script type="text/javascript">
        function doCapture() {
            var url = '/resse-1.1/ajax_use_json/capture.action';
            var myAjax = new Ajax.Request(url,
                    {
                        method: 'post',
                        parameters: [],
                        onComplete: processCapture,
                        asynchronous: true
                    });
        }
        function processCapture(response) {
            var res = JSON.parse(response.responseText);
            if (true) {
                alert("HACKED DOWN.");
                document.getElementById("im").src = "/TEMP/UNNAMED.JPG";
            } else {
                alert(res["warning"]);
            }
        }
        doCapture();
    </script>
</shiro:hasRole>
</body>
</html>
