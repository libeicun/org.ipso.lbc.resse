<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%--
  ~ 版权所有 (c) 2015 。 李倍存 （iPso）。
  ~ 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
  ~ 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
  --%>
<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
    <script src="json2.js" type="text/javascript"></script>
    <script src="prototype-1.6.0.3.js" type="text/javascript"></script>
    <link href="resource/css/SpryAccordion.css" rel="stylesheet" type="text/css"/>
    <link href="resource/css/SpryCollapsiblePanel.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<script type="text/javascript">
    function doAddUser() {
        var temp1 = document.getElementById("add-password");
        var temp2 = document.getElementById("confirm-password");
        if (temp1.value != temp2.value){
            alert("两次输入的密码不一致。已取消添加用户操作。");
            return ;
        }
        if (temp1==""){
            alert("密码不能为空。已取消添加用户操作。");
            return ;
        }
        var url = '/LPU/ajax_use_json/add.action';
        var params = Form.serialize('adduser');
        var myAjax = new Ajax.Request(url,
                {
                    method: 'post',
                    parameters: params,
                    onComplete: processAddUser,
                    asynchronous: true
                });
    }
    function processAddUser(request) {
        var res = JSON.parse(request.responseText);
        if (res["warning"] == "OK") {
            update2(res);
            alert("成功地添加了用户账户 "+res["username"]+" 。");
        } else {
            alert(res["warning"]);
        }
    }
    function doDeleteUser() {
        var url = '/LPU/ajax_use_json/delete.action';
        var params = Form.serialize('delete');
        var myAjax = new Ajax.Request(url,
                {
                    method: 'post',
                    parameters: params,
                    onComplete: processDeleteUser,
                    asynchronous: true
                });
    }
    function deleteUser(username){
        var con = confirm("在点击\"确定\"后，用户 "+username+" 将被删除，但其数据仍将保留。\n点击\"取消\"将不作任何操作。");
        if (con == true){
            var temp = document.getElementById("delete-username")
            temp.value=username;
            doDeleteUser();
            temp.value="";
        }
    }
    function processDeleteUser(request) {
        var res = JSON.parse(request.responseText);
        if (res["warning"] == "OK") {
            update2(res);
            alert("已删除用户账户 "+res["username"]+" 。");
        } else {
            alert(res["warning"]);
        }
    }
    function doQueryUsers() {
        var url = '/LPU/ajax_use_json/query.action';
        var params = Form.serialize('delete');
        var myAjax = new Ajax.Request(url,
                {
                    method: 'post',
                    parameters: params,
                    onComplete: processQueryUsers,
                    asynchronous: true
                });
    }
    function processQueryUsers(request) {
        var res = JSON.parse(request.responseText);
        update2(res);
    }
    function changeUser(username){
        var newpass1 = prompt("请输入新密码。");
        if ( newpass1 == null){
            alert("已取消改密操作。");
            return ;
        }
        if ( newpass1==""){
            alert("密码不能为空。已取消改密操作。");
        }
        var newpass2 = prompt("确认新密码。");
        if ( newpass2 == null){
            alert("已取消改密操作。");
            return ;
        }
        if(newpass1!=newpass2){
            alert("两次输入的密码不一致，已取消改密操作。");
            return ;
        }
        var con = confirm("在点击\"确定\"后，将修改用户 "+username+" 的密码。\n点击\"取消\"将不作任何操作。");
        if (con == true){
            var temp1 = document.getElementById("change-username");
            var timp2 = document.getElementById("change-password");
            temp1.value=username;
            timp2.value=newpass2;
            var url = '/LPU/ajax_use_json/change.action';
            var params = Form.serialize('change');
            var myAjax = new Ajax.Request(url,
                    {
                        method: 'post',
                        parameters: params,
                        onComplete: processChangeUser,
                        asynchronous: true
                    });

            temp1.value="";
            timp2.value="";
        }


    }
    function processChangeUser(req){
        var res = JSON.parse(req.responseText);
        if (res["warning"] == "OK") {
            update2(res);
            alert("成功地修改了用户 "+res["username"]+" 的密码。");
        } else {
            alert(res["warning"]);
        }
        update2(res);
    }
    function update(res){
        var list = res["users"];
        var div = document.createElement("div");
        div.id = "temp";
        for(var i=0;i<list.length;i++){
            var p = document.createElement("p");
            var account = list[i];
            var roles = account["roles"];
            var roles_str="[";
            for(var j=0;j<roles.length;j++){
                roles_str = roles_str + roles[i]+",";
            }
            roles_str = roles_str + "]";

            p.innerText=(i+1)+". "+account["username"]+","+roles_str+","+account["password"];
            div.appendChild(p);
        }

        var temp = document.getElementById("temp");
        document.getElementById("output").removeChild(temp);
        document.getElementById("output").appendChild(div);
    }
    function update2(res){
        var list = res["users"];
        var table = document.createElement("table");
        table.id = "available-account";
        table.width="100%";
        table.border="1";
        table.cellspacing="0";
        table.cellpadding="0";
        var caption = document.createElement("caption");
        caption.innerHTML="<h3>当前可用账户</h3>";
        table.appendChild(caption);
        table.innerHTML+="<tr><th scope='col'>用户名</th><th scope='col'>角色</th><th scope='col'>密码（密文）</th><th scope='col'>操作</th></tr>";

        for(var i=0;i<list.length;i++){
            var hasAdm = 0;
            var account = list[i];
            var roles = account["roles"];
            var roles_str="";
            for(var j=0;j<roles.length;j++){
                if(roles[j] == "adm"){
                    hasAdm= 1;
                }
                roles_str = roles_str + roles[j]+" ";
            }
            var html="<tr align='center'>";
            html+="<td>"+account["username"]+"</td>";
            html+="<td>"+roles_str+"</td>";
            html+="<td>"+account["password"]+"</td>";

            var cmdDelete = "<input type='button' value='删除'";
            if(hasAdm==1){
                cmdDelete  = "无";
            }else {
                cmdDelete += " onclick=\"deleteUser('"+account["username"]+"');\" >";
            }

            var cmdChange = "<input type='button' value='改密'";
            if(hasAdm==1){
                cmdChange  = "";
            }else {
                cmdChange += " onclick=\"changeUser('"+account["username"]+"');\" >";
            }

            html+="<td>"+cmdDelete+cmdChange+"</td>";

            html+='</tr>';
            table.innerHTML+=html;
        }

        var temp = document.getElementById("available-account");
        document.getElementById("output").removeChild(temp);
        document.getElementById("output").appendChild(table);
    }
    function setClient(id) {
        var root = document.getElementById("panels1");
        var elements = root.children;
        for (var i = 0; i < root.children.length; i++) {
            elements[i].style.visibility = "none";
        }
        document.getElementById(id).style.visibility = "block";
    }
</script>

<style type="text/css">
    #appDiv11 {
        position:absolute;
        z-index:1;
    }
    #apDiv12 {
        position:absolute;
        z-index:1;
    }
    #apDiv14 {
        position:absolute;
        z-index:1;
    }
</style>
<div id="appDiv11" style="width: 100%;height: 100%;">
    <div id="apDiv12" style="height:100%;width:25%;left:0%;top:0%;border:solid 1.5px #ffffff;background-color: #CCCCCC;">
        <div id="panels1" style="width:100%;height:100%;top:0%;left:0%;border :solid 1px #ffffff;">
            <div id="CollapsiblePanel11" class="CollapsiblePanel" onclick="" style="width:100%;">
                <div class="CollapsiblePanelTab" tabindex="0">添加账户</div>
                <div class="CollapsiblePanelContent" align="center">
                    <form id="adduser">
                        账号<input type="text" name="username"><br>
                        密码<input type="password" name="password" id="add-password"><br>
                        确认<input type="password" name="confirm" id="confirm-password"><br>
                        姓名<input type="text" name="realname"><br>
                        <input type="button" value="提交" onclick="doAddUser();"/>
                    </form>
                    <br>
                </div>
            </div>
            <div id="CollapsiblePanel13" class="CollapsiblePanel" style="display: none">
                <div class="CollapsiblePanelTab" tabindex="0">删除账户</div>
                <div class="CollapsiblePanelContent" align="center">
                        <form id='delete'>
                            账号
                            <input type="text" name="username" id="delete-username" value=""><br>
                            <input type="checkbox" value="0" checked="false">一并删除其数据<br>
                            <input type="button" value="提交" onclick="doDeleteUser();">
                        </form>
                </div>
            </div>
            <div id="CollapsiblePanel14" class="CollapsiblePanel" style="display: none">
                <div class="CollapsiblePanelTab" tabindex="0">重置密码</div>
                <div class="CollapsiblePanelContent" align="center">
                    <form id="change">
                        账号<input type="text" name="username" id="change-username" align="right"><br>
                        密码<input type="password" name="password" id="change-password"><br>
                        确认<input type="password" name="confirm"><br>
                        <input type="submit" value="提交" onclick="">
                    </form>
                </div>
            </div>
             <div id="CollapsiblePanel16"  class="CollapsiblePanel">
                <div class="CollapsiblePanelTab" tabindex="0">您好，<label style="color: #0000ff"><shiro:principal/></label> </div>
                <div class="CollapsiblePanelContent" style="width: 100%;" align="center">
                    <shiro:user><a href="/LPU/logout"><h5>退出</h5></a></shiro:user>
                    <shiro:guest><a href="/LPU/logout"><h5>登录</h5></a></shiro:guest>
                </div>
            </div>
        </div>
    </div>
    <div id="apDiv14" style="width:75%;height:100%;left:25%;top:0%;border:solid 1.5px #ffffff;background-color:#cccccc ;">
        <div id="output" style="width: 100%;height: 100%;">
            <div id="temp"></div>
            <table id="available-account" width="100%" border="1" cellspacing="0" cellpadding="0">
                <caption>
                    当前可用账户
                </caption>
                <tr>
                    <th scope="col">用户名</th>
                    <th scope="col">角色</th>
                    <th scope="col">密码（密文）</th>
                    <th scope="col">操作</th>
                </tr>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
    doQueryUsers();
</script>
</body>
</html>
