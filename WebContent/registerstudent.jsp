<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>  注册</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="images/logo.jpg">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">CL</h1>

            </div>
            <h3>欢迎注册 CollegeLive</h3>
            <p>创建一个&nbsp;学生&nbsp;新用户</p>
            <form class="m-t" role="form" action="${pageContext.request.contextPath}/student_add.action">
                <div class="form-group">
                    <input name="username" type="text" class="form-control" placeholder="请输入用户名" required="true">
                </div>
                <div class="form-group">
                    <input name="name" type="text" class="form-control" placeholder="请输入姓名" required="true">
                </div>                
                <div class="form-group">
                    <input name="tel" type="text" class="form-control" placeholder="请输入手机号" required="true">
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" placeholder="请输入密码" required="true">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="请再次输入密码" required="true">
                </div>
                <div class="form-group text-left">
                    <div class="checkbox i-checks">
                        <label class="no-padding">
                            <input type="checkbox"><i></i> 我同意注册协议</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>

                <p class="text-muted text-center"><small>已经有账户了？</small><a href="loginCollegeLive.html">点此登录</a>
                </p>

            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

</body>
</html>
    