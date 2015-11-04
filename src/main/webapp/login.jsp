<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resource/css/bootstrap.min.css">
    <link rel="stylesheet" href="resource/css/bootstrap-theme.min.css">
    <style>
        body{padding-top:20px;}
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading" align="center">
                        <h3 class="panel-title">登录</h3>
                    </div>
                    <div class="panel-body">
                        <form name="loginform" action="" method="POST" accept-charset="UTF-8" role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="在此输入用户名" name="username" type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="在此输入密码" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="rememberMe" type="checkbox" value="true"> 记住我
                                    </label>
                                </div>
                                <input class="btn btn-lg btn-success btn-block" type="submit" value="提交">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="resource/js/jquery.js"></script>
    <script src="resource/js/bootstrap.min.js"></script>
    <script src="resource/js/html5shiv.js"></script>
    <script src="resource/js/respond.min.js"></script>
</body>
</html>