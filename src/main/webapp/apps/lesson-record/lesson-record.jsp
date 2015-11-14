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

    <script src="../../resource/js/json2.js" type="text/javascript"></script>
    <script src="../../resource/js/prototype-1.6.0.3.js" type="text/javascript"></script>
    <style type="text/css">
    </style>
    <script type="text/javascript">
        var g_times = 0;
        var g_minutes = 0;
        var codes = [0,0,0,0,0,0,0];
        var weights = [8,4,2,1];

        window.onload = function () {
            g_times = 0;
            g_minutes = 0;
        }

        function doChangeRecord() {

            var url = '/resse-1.1/ajax_use_json/updateLessonRecord.action';

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
        function process(buttonId,minutes,times,dayCode,periodCode){
            if(document.getElementById(buttonId).checked == true) {
                unHighlightAndLoadStatus(buttonId);
                minutesSub(minutes);
                timeSub(times);
                encodeSub(dayCode,periodCode);
            }else {
                highlightAndStoreStatus(buttonId);
                minutesAdd(minutes);
                timesAdd(times);
                encodeAdd(dayCode,periodCode);
            }
            updateCodesToTransfer();
            updateTimesAndMinutesToTransfer();
        }

        function encodeAdd(dayCode,periodCode){
            codes[dayCode] = codes[dayCode] + weights[periodCode];
        }
        function encodeSub(dayCode,periodCode){
            codes[dayCode] = codes[dayCode] - weights[periodCode];
        }
        function minutesAdd(minutes){
            g_minutes = g_minutes + minutes;
        }
        function minutesSub(minutes){
            g_minutes = g_minutes - minutes;
        }
        function timesAdd(times){
            g_times = g_times + times;
        }
        function timeSub(times){
            g_times = g_times - times;
        }
        function highlightAndStoreStatus(buttonId){
            document.getElementById(buttonId).checked = true;
            document.getElementById(buttonId).value = document.getElementById(buttonId).className;
            document.getElementById(buttonId).className = document.getElementById(buttonId).className + " dashborder";
        }
        function unHighlightAndLoadStatus(buttonId){
            document.getElementById(buttonId).checked = false;
            document.getElementById(buttonId).className = document.getElementById(buttonId).value;
        }
        function updateCodesToTransfer(){
            document.getElementById("code0").value = codes[0];
            document.getElementById("code1").value = codes[1];
            document.getElementById("code2").value = codes[2];
            document.getElementById("code3").value = codes[3];
            document.getElementById("code4").value = codes[4];
            document.getElementById("code5").value = codes[5];
            document.getElementById("code6").value = codes[6];
        }
        function updateTimesAndMinutesToTransfer(){
            document.getElementById("showTimes").innerHTML = g_times;
            document.getElementById("showMinutes").innerHTML = g_minutes;
        }



    </script>
</head>

<body>
<h1 style="text-align: center;width: 100%;">在此页面登记每周的课程信息</h1>

<br><p class = "pnote">请在课程表内，选择您本周上过的课程。（若上课时间有更改，请选中实际的上课时间（如本周的电力系统程序设计课应选择周三下午）。）</p>
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
            <div class = "button orange" onclick="process('weekday_0_0',140,1,0,0);" id="weekday_0_0">数值分析</div>
        </td>
        <td>
            <div class = "button green"  onclick="process('weekday_1_0',210,1,1,0);" id="weekday_1_0" >基础英语</div>
        </td>
        <td>
            <div class = "button blue" onclick="process('weekday_2_0',140,1,2,0);" id="weekday_2_0" >电力系统程序设计</div>
        </td>
        <td>
            <div class = "button pink" onclick="process('weekday_3_0',140,1,3,0);" id="weekday_3_0"  >现代电力电子技术</div>
        </td>
        <td>
            <div class = "button green" onclick="process('weekday_4_0',140,1,4,0);" id="weekday_4_0" >电力系统过电压<br>自然辩证法</div>
        </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td style="font-size: smaller;  color: #000000">下午</td>
        <td>
            <div class="button blue" onclick="process('weekday_0_1',140,1,0,2);" id="weekday_0_1">现代电力电子技术<br>中国特色社会主义理论与实践研究</div>
        </td>
        <td>&nbsp;</td>
        <td>
            <div class = "button gray" onclick="process('weekday_2_1',140,1,2,2);" id="weekday_2_1"  >中国特色社会主义理论与实践研究<br>数理统计</div>
        </td>
        <td><div class = "button green" onclick="process('weekday_3_1',140,1,3,2);" id="weekday_3_1"  >电力系统分析</div></td>
        <td>
            <div class = "button orange" onclick="process('weekday_4_1',140,1,4,2);" id="weekday_4_1"  >数值分析<br>电网络理论</div>
        </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td style="font-size: smaller;  color: #000000">晚间</td>
        <td>
            <div class = "button gray" onclick="process('weekday_0_2',140,0,0,3);" id="weekday_0_2"  >中国特色社会主义理论与实践研究<br>数理统计</div>
        </td>
        <td>
            <div class = "button blue" onclick="process('weekday_1_2',140,0,1,3);" id="weekday_1_2"  >电力系统过电压<br>自然辩证法</div>
        </td>
        <td>
            <div class = "button orange" onclick="process('weekday_2_2',140,0,2,3);" id="weekday_2_2"  >电力系统分析<br>线性系统理论<br>中国特色社会主义理论与实践研究</div>

        </td>
        <td><div class = "button gray" onclick="process('weekday_3_2',140,0,3,3);" id="weekday_3_2"  >线性系统理论</div></td>
        <td><div class = "button green" onclick="process('weekday_4_2',140,0,4,3);" id="weekday_4_2"  >科技英语</div></td>
        <td>&nbsp;</td>
        <td><div class = "button pink" onclick="process('weekday_6_2',140,0,6,3);" id="weekday_6_2"  >电网络理论</div></td>
    </tr>
</table>
<form id="change">

    <shiro:guest>
        <br><p class="pnote">请键入您的姓名。</p>
        <input type="text" name="name" id="name"><br>
    </shiro:guest>

    <br><p class = "pnote">请键入您需要告知的更多信息。</p><input type="text"  name="info" placeholder="如：19-22日请假。或留空。"/><br>
    <input type="text" name="minutes" id="minutes" style="display: none"><br>
    <input type="text" name="times" id="times" style="display: none"><br>
    <input type="text" name="code0" id="code0" style="display: none"><br>
    <input type="text" name="code1" id="code1" style="display: none"><br>
    <input type="text" name="code2" id="code2" style="display: none"><br>
    <input type="text" name="code3" id="code3" style="display: none"><br>
    <input type="text" name="code4" id="code4" style="display: none"><br>
    <input type="text" name="code5" id="code5" style="display: none"><br>
    <input type="text" name="code6" id="code6" style="display: none"><br>
    <p class = "pnote">将为您的考勤记录：增加 <a style="color:#FF0000;" id = "showMinutes">0</a> 分钟上课时间，减少 <a style="color:#FF0000;" id = "showTimes">0</a> 次迟到记录。</p>
    <p>若您发现计算得出的应减少的迟到次数与实际不符（由于采用了非常规的考勤方式，如：中午12点考勤离开后，12点半又回实验室考勤），可以提供一个您认为正确的数值：<input type="text" name="timesCorrection" id="timesCorrection" placeholder="若计算值无误，请留空。"> 次。<br></p> 
    
    <input type="button" style="font-size: medium;font-style: oblique;background-color: #005695;color: #ffffff;" value="提交您的更改" onclick="doChangeRecord();"/>

</form>

</body>
</html>
