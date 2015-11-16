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
    <link href="../../resource/css/p-blue.css" rel="stylesheet" type="text/css" />
    <link href="../../resource/css/week-table.css" rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>每周上课时间登记</title>
    <style type="text/css">

    </style>

    <script src="../../resource/js/json2.js" type="text/javascript"></script>
    <script src="../../resource/js/prototype-1.6.0.3.js" type="text/javascript"></script>
    <script src="../../resource/js/jtimer.js" type="text/javascript"></script>
    <script type="text/javascript">
         function doChangeRecord() {
            var url = '/resse-1.1/ajax_use_json/registerDayOff.action';


            var params = Form.serialize('register');
            var myAjax = new Ajax.Request(url,
                    {
                        method: 'post',
                        parameters: params,
                        onComplete: processChange,
                        asynchronous: true
                    });
        }
        function processChange(response) {
            var res = JSON.parse(response.responseText);
            if (res["warning"] == "OK") {
                alert("成功地更新了您的请假记录。");
            } else {
                alert(res["warning"]);
            }
        }
    </script>
</head>

<body>
<form id="register">
    <shiro:guest>
        <p class="pnote">请键入您的姓名。</p>
        <input type="text" name="name"><br><br>
    </shiro:guest>
    <p class = "pnote">请键入请假理由。</p>
    <s:textarea name="reason"/><br><br>
    <p class = "pnote">请选择开始时间。</p>
    日期：<input type="text" name="startDate" placeholder="格式：2015-01-01">， 时间：<input type="text" name="startTime" placeholder="格式：08:00"><br><br>
    <p class = "pnote">请选择结束时间。</p>
    日期：<input type="text" name="endDate" placeholder="格式：2015-01-01">， 时间：<input type="text" name="endTime" placeholder="格式：22:00"><br><br>


    <input type="button" style="font-size: medium;font-style: oblique;background-color: #005695;color: #ffffff;" value="提交您的信息" onclick="doChangeRecord();"/>

</form>

</body>
</html>
