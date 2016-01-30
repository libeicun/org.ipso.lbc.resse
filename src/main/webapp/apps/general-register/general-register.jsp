<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <title>通用汇总</title>

    <link href="../../resource/css/p-blue.css" rel="stylesheet" type="text/css" />
    <script src="../../resource/js/json2.js" type="text/javascript"></script>
    <script src="../../resource/js/prototype-1.6.0.3.js" type="text/javascript"></script>
    <style type="text/css">
    </style>
    <script type="text/javascript">
        function doRegister() {

            var url = '/resse-1.1/ajax_use_json/registerGeneralInfo.action';

            var params = Form.serialize('register');
            var myAjax = new Ajax.Request(url,
                    {
                        method: 'post',
                        parameters: params,
                        onComplete: processRegister,
                        asynchronous: true
                    });
        }
        function processRegister(response) {
            var res = JSON.parse(response.responseText);
            if (res["warning"] == "OK") {
                alert("如果您看到了这条提示信息，说明数据已经到数据库了，请不必再点提交了，上次有同学提交了几十次。。。");
            } else {
                alert(res["warning"]);
            }
        }

    </script>
</head>

<body>
<h1 style="text-align: center;width:100%;">此页面用于通用的信息汇总</h1>
<form id="register">
    <p style="color: red;">请在此页面提供如下信息，用于统计电车相关信息。</p>
    <p class="pnote">请键入您的研究生学号。</p>
    <input type="text" name="id"/><br>
    <p class="pnote">姓名</p>
    <input type="text" name="name"/><br>

    <p class="pnote">若您本科在广西大学就读，请提供本科学号</p>
    <input value="" type="text" name="p0"/><br>
    <p class="pnote">电动车型号及颜色</p>
    <input value=""  type="text" name="p1"/><br>
    <p class="pnote">车牌号</p>
    <input value=""  type="text" name="p2"/><br>
    <%--<p class="pnote">宿舍</p>--%>
    <%--<input value=""  type="text" name="p3"/><br>--%>
    <%--<p class="pnote">信息字段4。</p>--%>
    <%--<input value="TEST4"  type="text" name="p4"/><br>--%>
    <%--<p class="pnote">信息字段5。</p>--%>
    <%--<input value="TEST5"  type="text" name="p5"/><br>--%>
    <%--<p class="pnote">信息字段6。</p>--%>
    <%--<input value="TEST6"  type="text" name="p6"/><br>--%>
    <%--<p class="pnote">信息字段7。</p>--%>
    <%--<input value="TEST7"  type="text" name="p7"/><br>--%>
    <%--<p class="pnote">信息字段8。</p>--%>
    <%--<input value="TEST8"  type="text" name="p8"/><br>--%>
    <%--<p class="pnote">信息字段9。</p>--%>
    <%--<input  value="TEST9" type="text" name="p9"/><br>--%>
    <%--<p class="pnote">信息字段10。</p>--%>
    <%--<input  value="TEST10" type="text" name="p10"/><br>--%>
    <%--<p class="pnote">信息字段11。</p>--%>
    <%--<input value="TEST11"  type="text" name="p11"/><br>--%>
    <%--<p class="pnote">信息字段12。</p>--%>
    <%--<input value="TEST12"  type="text" name="p12"/><br>--%>
    <%--<p class="pnote">信息字段13。</p>--%>
    <%--<input  value="TEST13" type="text" name="p13"/><br>--%>
    <%--<p class="pnote">信息字段14。</p>--%>
    <%--<input value="TEST14"  type="text" name="p14"/><br>--%>

    <br>
    <input type="button" style="font-size: medium;font-style: oblique;background-color: #005695;color: #ffffff;" value="提交您的信息" onclick="doRegister();"/>

</form>

</body>
</html>
