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
    <script type="text/javascript">
        var g_times = 0;
        var g_minutes = 0;
        window.onload = function () {
            g_times = 0;
            g_minutes = 0;
        }

        function doChangeRecord() {

            var url = '/resse-1.0/ajax_use_json/updateLessonRecord.action';

            document.getElementById("minutes").value = g_minutes;

            correction = document.getElementById("timesCorrection").value;
            if(correction!=''){
                document.getElementById("times").value = correction;
            } else {
                document.getElementById("times").value = g_times;
            }
            

            var params = Form.serialize('change');
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
                alert("成功地更新了您的考勤记录。");
            } else {
                alert(res["warning"]);
            }
        }
        function reverseVisible(buttonId,minutes,times){
            if(document.getElementById(buttonId).checked == true) {
                document.getElementById(buttonId).checked = false;
                document.getElementById(buttonId).className = document.getElementById(buttonId).value;
                g_minutes = g_minutes - minutes;
                g_times = g_times - times;
            }else {
                document.getElementById(buttonId).checked = true;
                document.getElementById(buttonId).value = document.getElementById(buttonId).className;
                document.getElementById(buttonId).className = document.getElementById(buttonId).className + " dashborder";
                g_minutes = g_minutes + minutes;
                g_times = g_times + times;
            }
            document.getElementById("showTimes").innerHTML = g_times;
            document.getElementById("showMinutes").innerHTML = g_minutes;

        }
    </script>
</head>

<body>
<form id="change">

    <br><p class = "pnote">请键入请假理由。</p><input type="text"  name="info" placeholder="或留空。"/><br>

    <label>开始时间</label><input type="datetime"><br>
    <label>结束时间</label><input type="datetime"><br>
    <input type="button" style="font-size: medium;font-style: oblique;background-color: #005695;color: #ffffff;" value="提交您的更改" onclick="doChangeRecord();"/>

</form>

</body>
</html>
