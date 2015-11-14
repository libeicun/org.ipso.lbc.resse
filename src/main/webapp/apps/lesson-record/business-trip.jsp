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
    <title>出差登记</title>
    <style type="text/css">

    </style>

    <script src="../../resource/js/json2.js" type="text/javascript"></script>
    <script src="../../resource/js/prototype-1.6.0.3.js" type="text/javascript"></script>
    <script type="text/javascript">
    </script>
</head>

<body>
<br><br><p class = "pnote">请在下表内，点击选择您本周出差或请假的时间段。</p>
<table  border="1" cellspacing="1" cellpadding="0" style="width: 100%">
    <tr >
        <td style="text-align: center;font-size: smaller;  color: #000000" rowspan="1">星期</td>
        <td style="text-align: center;font-size: smaller;  color: #000000">一</td>
        <td style="text-align: center;font-size: smaller;  color: #000000">二</td>
        <td style="text-align: center;font-size: smaller;  color: #000000">三</td>
        <td style="text-align: center;font-size: smaller;  color: #000000">四</td>
        <td style="text-align: center;font-size: smaller;  color: #000000">五</td>
        <td style="text-align: center;font-size: smaller;  color: #000000">六</td>
        <td style="text-align: center;font-size: smaller;  color: #000000">七</td>
    </tr>
    <tr>
        <td style="font-size: smaller;color: #000000">上午</td>
        <td>
            <div class = "button orange" onclick="reverseVisible('weekday_0_0',140,1);" id="weekday_0_0"><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green"  onclick="reverseVisible('weekday_1_0',210,1);" id="weekday_1_0" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button blue" onclick="reverseVisible('weekday_2_0',140,1);" id="weekday_2_0" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button pink" onclick="reverseVisible('weekday_3_0',140,1);" id="weekday_3_0"  ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green" onclick="reverseVisible('weekday_4_0',140,1);" id="weekday_4_0" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green" onclick="reverseVisible('weekday_5_0',140,1);" id="weekday_5_0" ><h5>    </h5></div>
        </td>
        <td>
        <div class = "button green" onclick="reverseVisible('weekday_6_0',140,1);" id="weekday_6_0" ><h5>    </h5></div>
    </tr>
    <tr>
        <td style="font-size: smaller;  color: #000000">下午</td>
        <td>
            <div class="button blue" onclick="reverseVisible('weekday_0_1',140,1);" id="weekday_0_1"><h5>    </h5></div>
        </td>
        <td>
            <div class = "button orange" onclick="reverseVisible('weekday_1_1',140,1);" id="weekday_1_1"  ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button gray" onclick="reverseVisible('weekday_2_1',140,1);" id="weekday_2_1"  ><h5>    </h5></div>
        </td>
        <td><div class = "button green" onclick="reverseVisible('weekday_3_1',140,1);" id="weekday_3_1"  ><h5>    </h5></div></td>
        <td>
            <div class = "button orange" onclick="reverseVisible('weekday_4_1',140,1);" id="weekday_4_1"  ><h5>    </h5></div>
        </td>
        <td>
            <div class="button blue" onclick="reverseVisible('weekday_5_1',140,1);" id="weekday_5_1"><h5>    </h5></div>
        </td>
        <td><div class = "button green" onclick="reverseVisible('weekday_6_1',140,1);" id="weekday_6_1"  ><h5>    </h5></div></td>
    </tr>
    <tr>
        <td style="font-size: smaller;  color: #000000">晚间</td>
        <td>
            <div class = "button gray" onclick="reverseVisible('weekday_0_2',140,0);" id="weekday_0_2"  ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button blue" onclick="reverseVisible('weekday_1_2',140,0);" id="weekday_1_2"  ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button orange" onclick="reverseVisible('weekday_2_2',140,0);" id="weekday_2_2"  ><h5>    </h5></div>

        </td>
        <td><div class = "button gray" onclick="reverseVisible('weekday_3_2',140,0);" id="weekday_3_2"  ><h5>    </h5></div></td>
        <td><div class = "button green" onclick="reverseVisible('weekday_4_2',140,0);" id="weekday_4_2"  ><h5>    </h5></div></td>
        <td>
        <div class = "button green" onclick="reverseVisible('weekday_5_2',140,1);" id="weekday_5_2"  ><h5>    </h5></div>
        </td>
        <td><div class = "button pink" onclick="reverseVisible('weekday_6_2',140,0);" id="weekday_6_2"  ><h5>    </h5></div></td>
    </tr>
</table>
<form id="change">
    <br><p class = "pnote">请键入您需要告知的更多信息。</p><input type="text"  name="info" placeholder="如：19-22日请假。或留空。"/><br>
    <input type="text" name="minutes" id="minutes" style="display: none"><br>
    <input type="text" name="times" id="times" style="display: none"><br>
    
    <p class = "pnote">将为您的考勤记录：增加 <a style="color:#FF0000;" id = "showMinutes">0</a> 分钟上课时间，减少 <a style="color:#FF0000;" id = "showTimes">0</a> 次迟到记录。</p>

    <input type="button" style="font-size: medium;font-style: oblique;background-color: #005695;color: #ffffff;" value="提交您的更改" onclick="doChangeRecord();"/>

</form>

</body>
</html>
