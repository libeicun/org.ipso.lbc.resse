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
    <style type="text/css">@import url(../../resource/jscalendar-1.0/calendar-system.css);</style>
    <script type="text/javascript" src="../../resource/jscalendar-1.0/calendar.js"></script>
    <script type="text/javascript" src="../../resource/jscalendar-1.0/lang/calendar-en.js"></script>
    <script type="text/javascript" src="../../resource/jscalendar-1.0/calendar-setup.js"></script>

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
    <input type="text" id="startDate" name="startDate">
    <div id="start"></div>
    <p class = "pnote">请选择结束时间。</p>
    <input type="text" id="endDate" name="endDate">
    <div id="end"></div>


    <input type="button" style="font-size: medium;font-style: oblique;background-color: #005695;color: #ffffff;" value="提交您的信息" onclick="doChangeRecord();"/>


</form>

<script type="text/javascript">
    function installFlatCalendar() {
        var parentStart = document.getElementById("start");
        var parentEnd   = document.getElementById("end");
        // hide week numbers
        calStart.weekNumbers = false;
        calStart.setDateFormat("%Y-%m-%d");
        calStart.create(parentStart);
        calStart.show();
        calEnd.weekNumbers = false;
        calEnd.setDateFormat("%Y-%m-%d");
        calEnd.create(parentEnd);
        calEnd.show();
    }
    function flatSelected(cal, date){
        if(cal == calStart ){
            document.getElementById("startDate").value = date;
        }
        if(cal == calEnd){
            document.getElementById("endDate").value = date;
        }
    }
    var calStart = new Calendar(0, null, flatSelected);
    var calEnd   = new Calendar(0, null, flatSelected);
    installFlatCalendar();
</script>
</body>
</html>
