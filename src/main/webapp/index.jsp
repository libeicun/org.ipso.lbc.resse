<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  ~ 版权所有 (c) 2015 。 李倍存 （iPso）。
  ~ 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
  ~ 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
  --%>
<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>每周上课时间登记</title>
    <style type="text/css">
        body {
            background: #ededed;
            width: 900px;
            margin: 30px auto;
            color: #999;
        }
        p {
            margin: 0 0 2em;
        }
        h1 {
            margin: 0;
        }
        a {
            color: #339;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        /*div {*/
            /*padding: 20px 0;*/
            /*border-bottom: solid 1px #ccc;*/
        /*}*/

        /* button
        ---------------------------------------------- */
        .button {
            display: inline-block;
            font-size: smaller;
            font-style: normal;
            zoom: 1;
            *display: inline;
            vertical-align:baseline;
            outline: none;
            cursor:pointer;
            text-align: left;
            text-shadow: 0 1px 1px rgba(0,0,0,.3);
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.2);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,.2);
            width: 100%;
            height: 100%;
        }
        .button:hover {
            text-decoration: none;
        }
        .button:active {
            position: relative;
            top: 1px;
        }

        .dashborder{
            border:2px solid #000000;
        }

        .bigrounded {
            -webkit-border-radius: 2em;
            -moz-border-radius: 2em;
            border-radius: 2em;
        }
        .medium {
            font-size: 12px;
            padding: .4em 1.5em .42em;
        }
        .small {
            font-size: 11px;
            padding: .2em 1em .275em;
        }

        /* color styles
        ---------------------------------------------- */

        /* black */
        .black {
            color: #d7d7d7;
            background: #333;
            background: -webkit-gradient(linear, left top, left bottom, from(#666), to(#000));
            background: -moz-linear-gradient(top,  #666,  #000);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#666666', endColorstr='#000000');
        }
        .black:hover {
            background: #000;
            background: -webkit-gradient(linear, left top, left bottom, from(#444), to(#000));
            background: -moz-linear-gradient(top,  #444,  #000);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#444444', endColorstr='#000000');
        }
        .black:active {
            color: #666;
            background: -webkit-gradient(linear, left top, left bottom, from(#000), to(#444));
            background: -moz-linear-gradient(top,  #000,  #444);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#000000', endColorstr='#666666');
        }

        /* gray */
        .gray {
            color: #e9e9e9;
            background: #6e6e6e;
            background: -webkit-gradient(linear, left top, left bottom, from(#888), to(#575757));
            background: -moz-linear-gradient(top,  #888,  #575757);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#888888', endColorstr='#575757');
        }
        .gray:hover {
            background: #616161;
            background: -webkit-gradient(linear, left top, left bottom, from(#757575), to(#4b4b4b));
            background: -moz-linear-gradient(top,  #757575,  #4b4b4b);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#757575', endColorstr='#4b4b4b');
        }
        .gray:active {
            color: #afafaf;
            background: -webkit-gradient(linear, left top, left bottom, from(#575757), to(#888));
            background: -moz-linear-gradient(top,  #575757,  #888);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#575757', endColorstr='#888888');
        }

        /* white */
        .white {
            color: #606060;
            background: #fff;
            background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#ededed));
            background: -moz-linear-gradient(top,  #fff,  #ededed);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#ededed');
        }
        .white:hover {
            background: #ededed;
            background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#dcdcdc));
            background: -moz-linear-gradient(top,  #fff,  #dcdcdc);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#dcdcdc');
        }
        .white:active {
            color: #999;
            background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#fff));
            background: -moz-linear-gradient(top,  #ededed,  #fff);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#ffffff');
        }

        /* orange */
        .orange {
            color: #fef4e9;
            background: #f78d1d;
            background: -webkit-gradient(linear, left top, left bottom, from(#faa51a), to(#f47a20));
            background: -moz-linear-gradient(top,  #faa51a,  #f47a20);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#faa51a', endColorstr='#f47a20');
        }
        .orange:hover {
            background: #f47c20;
            background: -webkit-gradient(linear, left top, left bottom, from(#f88e11), to(#f06015));
            background: -moz-linear-gradient(top,  #f88e11,  #f06015);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#f88e11', endColorstr='#f06015');
        }
        .orange:active {
            color: #fcd3a5;
            background: -webkit-gradient(linear, left top, left bottom, from(#f47a20), to(#faa51a));
            background: -moz-linear-gradient(top,  #f47a20,  #faa51a);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#f47a20', endColorstr='#faa51a');
        }

        /* red */
        .red {
            color: #faddde;
            background: #d81b21;
            background: -webkit-gradient(linear, left top, left bottom, from(#ed1c24), to(#aa1317));
            background: -moz-linear-gradient(top,  #ed1c24,  #aa1317);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#ed1c24', endColorstr='#aa1317');
        }
        .red:hover {
            background: #b61318;
            background: -webkit-gradient(linear, left top, left bottom, from(#c9151b), to(#a11115));
            background: -moz-linear-gradient(top,  #c9151b,  #a11115);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#c9151b', endColorstr='#a11115');
        }
        .red:active {
            color: #de898c;
            background: -webkit-gradient(linear, left top, left bottom, from(#aa1317), to(#ed1c24));
            background: -moz-linear-gradient(top,  #aa1317,  #ed1c24);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#aa1317', endColorstr='#ed1c24');
        }

        /* blue */
        .blue {
            color: #d9eef7;
            background: #0095cd;
            background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
            background: -moz-linear-gradient(top,  #00adee,  #0078a5);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#00adee', endColorstr='#0078a5');
        }
        .blue:hover {
            background: #007ead;
            background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
            background: -moz-linear-gradient(top,  #0095cc,  #00678e);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#0095cc', endColorstr='#00678e');
        }
        .blue:active {
            color: #80bed6;
            background: -webkit-gradient(linear, left top, left bottom, from(#0078a5), to(#00adee));
            background: -moz-linear-gradient(top,  #0078a5,  #00adee);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#0078a5', endColorstr='#00adee');
        }

        /* rosy */
        .rosy {
            color: #fae7e9;
            background: #da5867;
            background: -webkit-gradient(linear, left top, left bottom, from(#f16c7c), to(#bf404f));
            background: -moz-linear-gradient(top,  #f16c7c,  #bf404f);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#f16c7c', endColorstr='#bf404f');
        }
        .rosy:hover {
            background: #ba4b58;
            background: -webkit-gradient(linear, left top, left bottom, from(#cf5d6a), to(#a53845));
            background: -moz-linear-gradient(top,  #cf5d6a,  #a53845);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#cf5d6a', endColorstr='#a53845');
        }
        .rosy:active {
            color: #dca4ab;
            background: -webkit-gradient(linear, left top, left bottom, from(#bf404f), to(#f16c7c));
            background: -moz-linear-gradient(top,  #bf404f,  #f16c7c);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#bf404f', endColorstr='#f16c7c');
        }

        /* green */
        .green {
            color: #e8f0de;
            background: #64991e;
            background: -webkit-gradient(linear, left top, left bottom, from(#7db72f), to(#4e7d0e));
            background: -moz-linear-gradient(top,  #7db72f,  #4e7d0e);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#7db72f', endColorstr='#4e7d0e');
        }
        .green:hover {
            background: #538018;
            background: -webkit-gradient(linear, left top, left bottom, from(#6b9d28), to(#436b0c));
            background: -moz-linear-gradient(top,  #6b9d28,  #436b0c);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#6b9d28', endColorstr='#436b0c');
        }
        .green:active {
            color: #a9c08c;
            background: -webkit-gradient(linear, left top, left bottom, from(#4e7d0e), to(#7db72f));
            background: -moz-linear-gradient(top,  #4e7d0e,  #7db72f);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#4e7d0e', endColorstr='#7db72f');
        }

        /* pink */
        .pink {
            color: #feeef5;
            background: #f895c2;
            background: -webkit-gradient(linear, left top, left bottom, from(#feb1d3), to(#f171ab));
            background: -moz-linear-gradient(top,  #feb1d3,  #f171ab);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#feb1d3', endColorstr='#f171ab');
        }
        .pink:hover {
            background: #d57ea5;
            background: -webkit-gradient(linear, left top, left bottom, from(#f4aacb), to(#e86ca4));
            background: -moz-linear-gradient(top,  #f4aacb,  #e86ca4);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#f4aacb', endColorstr='#e86ca4');
        }
        .pink:active {
            color: #f3c3d9;
            background: -webkit-gradient(linear, left top, left bottom, from(#f171ab), to(#feb1d3));
            background: -moz-linear-gradient(top,  #f171ab,  #feb1d3);
            filter:  progid:DXImageTransform.Microsoft.gradient(startColorstr='#f171ab', endColorstr='#feb1d3');
        }
    </style>

    <script src="SpryAccordion.js" type="text/javascript"></script>
    <script src="SpryCollapsiblePanel.js" type="text/javascript"></script>
    <script src="json2.js" type="text/javascript"></script>
    <script src="prototype-1.6.0.3.js" type="text/javascript"></script>
    <link href="SpryAccordion.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
    </style>
    <link href="SpryCollapsiblePanel.css" rel="stylesheet" type="text/css"/>
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
<h1 style="text-align: center;width: 100%;">在此页面登记每周的课程信息</h1>

<br><p style="color: #005695;">请在课程表内，选择您本周上过的课程。</p>
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
            <div class = "button orange" onclick="reverseVisible('weekday_0_0',140,1);" id="weekday_0_0">数值分析</div>
        </td>
        <td>
            <div class = "button green"  onclick="reverseVisible('weekday_1_0',210,1);" id="weekday_1_0" >基础英语</div>
        </td>
        <td>
            <div class = "button blue" onclick="reverseVisible('weekday_2_0',140,1);" id="weekday_2_0" >电力系统程序设计</div>
        </td>
        <td>
            <div class = "button pink" onclick="reverseVisible('weekday_3_0',140,1);" id="weekday_3_0"  >现代电力电子技术</div>
        </td>
        <td>
            <div class = "button green" onclick="reverseVisible('weekday_4_0',140,1);" id="weekday_4_0" >电力系统过电压<br>自然辩证法</div>
        </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td style="font-size: smaller;  color: #000000">下午</td>
        <td>
            <div class="button blue" onclick="reverseVisible('weekday_0_1',140,1);" id="weekday_0_1">现代电力电子技术<br>中国特色社会主义理论与实践研究</div>
        </td>
        <td>&nbsp;</td>
        <td>
            <div class = "button gray" onclick="reverseVisible('weekday_2_1',140,1);" id="weekday_2_1"  >中国特色社会主义理论与实践研究<br>数理统计</div>
        </td>
        <td><div class = "button green" onclick="reverseVisible('weekday_3_1',140,1);" id="weekday_3_1"  >电力系统分析</div></td>
        <td>
            <div class = "button orange" onclick="reverseVisible('weekday_4_1',140,1);" id="weekday_4_1"  >数值分析<br>电网络理论</div>
        </td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td style="font-size: smaller;  color: #000000">晚间</td>
        <td>
            <div class = "button gray" onclick="reverseVisible('weekday_0_2',140,0);" id="weekday_0_2"  >中国特色社会主义理论与实践研究<br>数理统计</div>
        </td>
        <td>
            <div class = "button blue" onclick="reverseVisible('weekday_1_2',140,0);" id="weekday_1_2"  >电力系统过电压<br>自然辩证法</div>
        </td>
        <td>
            <div class = "button orange" onclick="reverseVisible('weekday_2_2',140,0);" id="weekday_2_2"  >电力系统分析<br>线性系统理论<br>中国特色社会主义理论与实践研究</div>

        </td>
        <td><div class = "button gray" onclick="reverseVisible('weekday_3_2',140,0);" id="weekday_3_2"  >线性系统理论</div></td>
        <td><div class = "button green" onclick="reverseVisible('weekday_4_2',140,0);" id="weekday_4_2"  >科技英语</div></td>
        <td>&nbsp;</td>
        <td><div class = "button pink" onclick="reverseVisible('weekday_6_2',140,0);" id="weekday_6_2"  >电网络理论</div></td>
    </tr>
</table>
<form id="change">
    <br><p style="color: #005695;">请键入您需要告知的更多信息。</p><input type="text"  name="info" placeholder="如：19-22日请假。或留空。"/><br>
    <br><p style="color: #005695;">请键入您的姓名。</p><input type="text" name="name"><br>
    <input type="text" name="minutes" id="minutes" style="display: none"><br>
    <input type="text" name="times" id="times" style="display: none"><br>
    
    <p style="color: #005695;">将为您的考勤记录：增加 <a style="color:#FF0000;" id = "showMinutes">0</a> 分钟上课时间，减少 <a style="color:#FF0000;" id = "showTimes">0</a> 次迟到记录。</p>  
    <p>若您发现计算得出的应减少的迟到次数与实际不符（由于采用了非常规的考勤方式，如：中午12点考勤离开后，12点半又回实验室考勤），可以提供一个您认为正确的数值：<input type="text" name="timesCorrection" id="timesCorrection" placeholder="若计算值无误，请留空。"> 次。<br></p> 
    
    <input type="button" style="font-size: medium;font-style: oblique;background-color: #005695;color: #ffffff;" value="提交您的更改" onclick="doChangeRecord();"/>

</form>

</body>
</html>
