<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>添加教师</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">

			<div class="col-sm-6" style="width:100%;">
                <div class="ibox float-e-margins" style="width:60%;margin:0 auto;"> 
                    <div class="ibox-title">
                        <h5>添加教师</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/teacher_add.action">
                            
							<div class="form-group">
                                <label class="col-sm-3 control-label">用户名：</label>
                                <div class="col-sm-8">
                                    <input name="username" type="text" placeholder="用户名" class="form-control"> 
                                    <span class="help-block m-b-none">用户名由字母数字下划线组成</span>
                                </div>
                            </div>

							<div class="form-group">
                                <label class="col-sm-3 control-label">教师姓名：</label>
                                <div class="col-sm-8">
                                    <input name="name" type="text" placeholder="教师姓名" class="form-control"> 
                                    <span class="help-block m-b-none">请输入教师姓名</span>
                                </div>
                            </div>

							<div class="form-group">
                                <label class="col-sm-3 control-label">手机号：</label>
                                <div class="col-sm-8">
                                    <input name="tel" type="text" placeholder="手机号" class="form-control"> 
                                    <span class="help-block m-b-none">请输入教师手机号</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>
                                <div class="col-sm-8">
                                    <input name="password" type="password" placeholder="密码" class="form-control" value="666666">
									<span class="help-block m-b-none">密码默认为:666666</span>
                                </div>
                            </div>

							<div class="form-group">
                                <label class="col-sm-3 control-label">FMS&nbhsp;URL</label>
                                <div class="col-sm-8">
                                    <input name="fms" type="text" placeholder="请输入FMS URL" class="form-control"> 
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label class="col-sm-3 control-label">串流码</label>
                                <div class="col-sm-8">
                                    <input name="streamid" type="text" placeholder="请输入串流码" class="form-control"> 
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            

                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button class="btn btn-sm btn-info" type="submit">提 交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>




    
    

</body>

</html>
    