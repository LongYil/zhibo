<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>填写教师信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
			<div class="col-sm-6" style="width:100%;">
                <div class="ibox float-e-margins" style="width:60%;margin:0 auto;"> 
                    <div class="ibox-title" >
                        <h5 style="font-size:20px;color:#23b7e5;">填写教师信息</h5>
                        
                        <div class="fa-hover col-md-3 col-sm-4" style="color:#23b7e5;font-size:20px;width:120px;float:right;margin-right:0px;"><a onClick="Go('teacher_backAndQuery.action')" href="javascript:void(0)"><i class="fa fa-mail-reply"></i> 返回 <span class="text-muted"></span></a></div>                        
                    </div>
                    <div class="ibox-content">
                        <div class="form-horizontal">

							<div class="form-group">
                                <label class="col-sm-3 control-label">用户名：</label>
                                <div class="col-sm-8">
                                    <input name="username" id="username" type="text" value="<s:property value="teacher.username"/>" placeholder="用户名" class="form-control"> 
                                    <span class="help-block m-b-none">用户名由字母数字下划线组成</span>
                                </div>
                            </div>

							<div class="form-group">
                                <label class="col-sm-3 control-label">教师姓名：</label>
                                <div class="col-sm-8">
                                    <input name="name" id="name" type="text" value="<s:property value="teacher.name"/>" placeholder="教师姓名" class="form-control"> 
                                    <span class="help-block m-b-none">请输入教师姓名</span>
                                </div>
                            </div>

							<div class="form-group">
                                <label class="col-sm-3 control-label">手机号：</label>
                                <div class="col-sm-8">
                                    <input name="tel" id="tel" type="text" value="<s:property value="teacher.tel"/>" placeholder="手机号" class="form-control"> 
                                    <span class="help-block m-b-none">请输入教师手机号</span>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>
                                <div class="col-sm-8">
                                    <input name="password" id="password" type="password" value="<s:property value="teacher.password"/>" placeholder="密码" class="form-control" value="666666">
									<span class="help-block m-b-none">密码默认为:666666</span>
                                </div>
                            </div>

							<div class="form-group">
                                <label class="col-sm-3 control-label">FMS  URL</label>
                                <div class="col-sm-8">
                                    <input name="fms" id="fms" type="text" value="<s:property value="teacher.fms"/>" placeholder="请输入FMS URL" class="form-control"> 
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <input type="hidden" name="id" class="userid" value="<s:property value="teacher.id"/>">
							<div class="form-group">
                                <label class="col-sm-3 control-label">串流码</label>
                                <div class="col-sm-8">
                                    <input name="streamid" id="streamid" type="text" value="<s:property value="teacher.streamid"/>" placeholder="请输入串流码" class="form-control"> 
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button class="btn btn-sm btn-info" onClick="saveTeacherInfo()">保 存</button>
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

function Go(url){
	window.location=url;
}
function saveTeacherInfo(){
	var arg = $(".userid").val()+"-"+$("#username").val()+"-"+$("#name").val()+"-"+$("#tel").val()+"-"+$("#password").val()+"-"+$("#fms").val()+"-"+$("#streamid").val();
	var result = ajaxSubmit("teacher_saveInfo.action",arg);
	if(result=="1"){
		parent.layer.msg('保存成功', {icon: 1});
	}else{
		parent.layer.msg('修改失败', {icon: 2});
	}
}
</script>

</html>
