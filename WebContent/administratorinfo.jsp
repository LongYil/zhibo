<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息</title>

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="plugins/cover_js/iscroll-zoom.js" type="text/javascript" charset="utf-8"></script>
	<script src="plugins/cover_js/hammer.js" type="text/javascript" charset="utf-8"></script>
	<script src="plugins/cover_js/lrz.all.bundle.js" type="text/javascript" charset="utf-8"></script>
	<script src="plugins/cover_js/jquery.photoClip.min.js" type="text/javascript" charset="utf-8"></script>
	   
    <style type="text/css">
    body{
    font-size: 14px;
    }
    </style>
</head>
<body class="gray-bg">

			<div class="col-sm-6" style="width:100%;">
                <div class="ibox float-e-margins" style="width:60%;margin:0 auto;"> 
                    <div class="ibox-title" >
                        <h5 style="font-size:20px;color:#23b7e5;">修改个人信息</h5>
                    </div>
                    
                    
                    <div class="ibox-content">
                    
                        <div class="clients-list">
                            <ul class="nav nav-tabs">
<!--                                 <li class=""><a data-toggle="tab" href="#tab-4"><i class="fa fa-file-image-o"></i>我的头像</a></li> -->
                                <li class="active"><a data-toggle="tab" href="#tab-1" id="tab1"><i class="fa fa-user"></i>基本信息</a></li>
                                <li class=""><a data-toggle="tab" href="#tab-2"><i class="fa fa-lock"></i>安全设置</a></li>
                            </ul>
                            <div class="tab-content">
                                <div id="tab-1" class="tab-pane active">
					                <div class="form-horizontal">	
										<div class="form-group" style="margin-top:30px;">
			                                <label class="col-sm-3 control-label">用户名：</label>
			                                <div class="col-sm-8">
			                                    <input name="name" id="info1" type="text" value="<s:property value="manager.username"/>" placeholder="用户名" class="form-control"> 
			                                </div>
			                            </div>

										<div class="form-group">
			                                <label class="col-sm-3 control-label">用户姓名：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info2" type="text" value="<s:property value="manager.name"/>" placeholder="用户姓名" class="form-control"> 
			                                </div>
			                            </div>

			                            <div class="form-group">
			                                <div class="col-sm-offset-3 col-sm-8">
			                                    <button class="btn btn-sm btn-info" onClick="updateinfo()">提 交</button>
			                                </div>
			                            </div> 
			                         </div>     
			                    </div>
                                
								<div id="tab-2" class="tab-pane">
					                <div class="form-horizontal">				                            
			                            <div class="form-group" style="margin-top:30px;">
			                                <label class="col-sm-3 control-label">输入旧密码：</label>
			                                <div class="col-sm-8">
			                                    <input name="password" type="password" id="pwd1"  placeholder="旧密码" class="form-control">
												<span class="help-block m-b-none"></span>
			                                </div>
			                            </div>
			                            <div class="form-group">
			                                <label class="col-sm-3 control-label">新密码：</label>
			                                <div class="col-sm-8">
			                                    <input name="password" type="password" id="pwd2" placeholder="新密码" class="form-control">
												<span class="help-block m-b-none"></span>
			                                </div>
			                            </div>
			                            <div class="form-group">
			                                <label class="col-sm-3 control-label">确认新密码：</label>
			                                <div class="col-sm-8">
			                                    <input name="password" type="password" id="pwd3" placeholder="确认新密码" class="form-control">
												<span class="help-block m-b-none"></span>
			                                </div>
			                            </div>
			                            <div class="form-group">
			                                <div class="col-sm-offset-3 col-sm-8">
			                                    <button class="btn btn-sm btn-info" onClick="updatepassword()">提 交</button>
			                                </div>
			                            </div>
									 </div>
                                </div>

	                                </div>
                                    </div>
			                        </div>
                                </div>
                                
                            </div>
                        </div>  
                    </div>
                </div>
            </div>
</body>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/ajaxcommunicate.js"></script>
    
<script type="text/javascript">

function updatepassword(){
	var info1 = $("#pwd1").val();
	var info2 = $("#pwd2").val();
	var info3 = $("#pwd3").val();
	if(info1 == "" || info2 == "" || info3 == ""){
		parent.layer.msg('信息填写不完整!', {icon: 2});
	}else{
		if(info2 == info3){
			var arg = info1 + "-" + info2;
			var result = ajaxSubmit("manager_updatePassword.action",arg);
			if(result=="1"){
				parent.layer.msg('修改成功', {icon: 1});
			}else{
				parent.layer.msg('旧密码错误，修改失败', {icon: 2});
			}			
		}else{
			parent.layer.msg('两次密码不一致!', {icon: 2});
		}		
	}
}

function updateinfo(){
	var info1 = $("#info1").val();
	var info2 = $("#info2").val();
	if(info1 == "" || info2 == ""){
		parent.layer.msg('信息填写不完整!', {icon: 2});
	}else{
		var arg = info1 + "-" + info2;
		var result = ajaxSubmit("manager_updateInfo.action",arg);
		if(result=="1"){
			parent.layer.msg('修改成功', {icon: 1});
		}else{
			parent.layer.msg('修改失败', {icon: 2});
		}		
	}

}

</script>
</html>