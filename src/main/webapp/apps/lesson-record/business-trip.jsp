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
        var codes = [0,0,0,0,0,0,0];
        var weights = [8,4,2,1];


        function doChangeRecord() {

            var url = '/resse-1.1/ajax_use_json/registerBusinessTrip.action';

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
                alert("成功地更新了您的出差记录。");
            } else {
                alert(res["warning"]);
            }
        }
        function process(buttonId,dayCode,periodCode){
            if(document.getElementById(buttonId).checked == true) {
                unHighlightAndLoadStatus(buttonId);
                encodeSub(dayCode,periodCode);
            }else {
                highlightAndStoreStatus(buttonId);
                encodeAdd(dayCode,periodCode);
            }
            updateCodesToTransfer();
        }

        function encodeAdd(dayCode,periodCode){
            codes[dayCode] = codes[dayCode] + weights[periodCode];
        }
        function encodeSub(dayCode,periodCode){
            codes[dayCode] = codes[dayCode] - weights[periodCode];
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


    </script>
</head>

<body>
<br><br><p class = "pnote">请在下表内，点击选择您本周出差的时间段。</p>
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
        <td style="font-size: smaller;color: #000000">上午1大节</td>
        <td>
            <div class = "button orange" onclick="process('weekday_0_0_0',0,0);" id="weekday_0_0_0"><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green"  onclick="process('weekday_1_0_0',1,0);" id="weekday_1_0_0" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button blue" onclick="process('weekday_2_0_0',2,0);" id="weekday_2_0_0" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button pink" onclick="process('weekday_3_0_0',3,0);" id="weekday_3_0_0"  ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green" onclick="process('weekday_4_0_0',4,0);" id="weekday_4_0_0" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green" onclick="process('weekday_5_0_0',5,0);" id="weekday_5_0_0" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green" onclick="process('weekday_6_0_0',6,0);" id="weekday_6_0_0" ><h5>    </h5></div>
    </tr>
    <tr>
        <td style="font-size: smaller;color: #000000">上午2大节</td>
        <td>
            <div class = "button orange" onclick="process('weekday_0_0_1',0,1);" id="weekday_0_0_1"><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green"  onclick="process('weekday_1_0_1',1,1);" id="weekday_1_0_1" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button blue" onclick="process('weekday_2_0_1',2,1);" id="weekday_2_0_1" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button pink" onclick="process('weekday_3_0_1',3,1);" id="weekday_3_0_1"  ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green" onclick="process('weekday_4_0_1',4,1);" id="weekday_4_0_1" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green" onclick="process('weekday_5_0_1',5,1);" id="weekday_5_0_1" ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button green" onclick="process('weekday_6_0_1',6,1);" id="weekday_6_0_1" ><h5>    </h5></div>
    </tr>
    <tr>
        <td style="font-size: smaller;  color: #000000">下午</td>
        <td>
            <div class="button blue" onclick="process('weekday_0_1',0,2);" id="weekday_0_1"><h5>    </h5></div>
        </td>
        <td>
            <div class = "button orange" onclick="process('weekday_1_1',1,2);" id="weekday_1_1"  ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button gray" onclick="process('weekday_2_1',2,2);" id="weekday_2_1"  ><h5>    </h5></div>
        </td>
        <td><div class = "button green" onclick="process('weekday_3_1',3,2);" id="weekday_3_1"  ><h5>    </h5></div></td>
        <td>
            <div class = "button orange" onclick="process('weekday_4_1',4,2);" id="weekday_4_1"  ><h5>    </h5></div>
        </td>
        <td>
            <div class="button blue" onclick="process('weekday_5_1',5,2);" id="weekday_5_1"><h5>    </h5></div>
        </td>
        <td><div class = "button green" onclick="process('weekday_6_1',6,2);" id="weekday_6_1"  ><h5>    </h5></div></td>
    </tr>
    <tr>
        <td style="font-size: smaller;  color: #000000">晚间</td>
        <td>
            <div class = "button gray" onclick="process('weekday_0_2',0,3);" id="weekday_0_2"  ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button blue" onclick="process('weekday_1_2',1,3);" id="weekday_1_2"  ><h5>    </h5></div>
        </td>
        <td>
            <div class = "button orange" onclick="process('weekday_2_2',2,3);" id="weekday_2_2"  ><h5>    </h5></div>

        </td>
        <td><div class = "button gray" onclick="process('weekday_3_2',3,3);" id="weekday_3_2"  ><h5>    </h5></div></td>
        <td><div class = "button green" onclick="process('weekday_4_2',4,3);" id="weekday_4_2"  ><h5>    </h5></div></td>
        <td>
        <div class = "button green" onclick="process('weekday_5_2',5,3);" id="weekday_5_2"  ><h5>    </h5></div>
        </td>
        <td><div class = "button pink" onclick="process('weekday_6_2',6,3);" id="weekday_6_2"  ><h5>    </h5></div></td>
    </tr>
</table>
<form id="change">
    <shiro:guest>
        <br><p class="pnote">请键入您的姓名。</p>
        <input type="text" name="name" id="name"><br>
    </shiro:guest>
    <input type="text" name="code0" id="code0" style="display: none"><br>
    <input type="text" name="code1" id="code1" style="display: none"><br>
    <input type="text" name="code2" id="code2" style="display: none"><br>
    <input type="text" name="code3" id="code3" style="display: none"><br>
    <input type="text" name="code4" id="code4" style="display: none"><br>
    <input type="text" name="code5" id="code5" style="display: none"><br>
    <input type="text" name="code6" id="code6" style="display: none"><br>
    <input type="button" style="font-size: medium;font-style: oblique;background-color: #005695;color: #ffffff;" value="提交您的更改" onclick="doChangeRecord();"/>

</form>

</body>
</html>
