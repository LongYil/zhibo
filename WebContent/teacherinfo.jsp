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

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    
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
                        
                        <div class="fa-hover col-md-3 col-sm-4" style="color:#23b7e5;font-size:20px;width:120px;float:right;margin-right:0px;"><a onClick="Go('teacher_findAll.action')" href="javascript:void(0)"><i class="fa fa-mail-reply"></i> 返回 <span class="text-muted"></span></a></div>                        
                    </div>
                    
                    
                    <div class="ibox-content">
                    
                        <div class="clients-list">
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#tab-1"><i class="fa fa-user"></i>基本信息</a></li>
                                <li class=""><a data-toggle="tab" href="#tab-2"><i class="fa fa-lock"></i>安全设置</a></li>
                                <li class=""><a data-toggle="tab" href="#tab-3"><i class="fa fa-video-camera"></i>直播信息</a></li>
                            </ul>
                            <div class="tab-content">
                                <div id="tab-1" class="tab-pane active">
					                <div class="form-horizontal">	
										<div class="form-group" style="margin-top:30px;">
			                                <label class="col-sm-3 control-label">教师姓名：</label>
			                                <div class="col-sm-8">
			                                    <input name="name" id="info1" type="text" value="<s:property value="teacher.name"/>" placeholder="教师姓名" class="form-control"> 
			                                </div>
			                            </div>

										<div class="form-group">
			                                <label class="col-sm-3 control-label">手机号：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info2" type="text" value="<s:property value="teacher.tel"/>" placeholder="手机号" class="form-control"> 
			                                </div>
			                            </div>
			                            
										<div class="form-group">
			                                <label class="col-sm-3 control-label">性别：</label>
			                                <div class="col-sm-8">
						                        <c:if test="${teacher.sex==0 }">
							                        <input type="radio" id="inlineRadio1" value="0" name="info3" checked="checked">
							                        <label for="inlineRadio1"> 男 </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							                        <input type="radio" id="inlineRadio2" value="1" name="info3">
							                        <label for="inlineRadio2"> 女 </label>
						                        </c:if>
						                        <c:if test="${teacher.sex==1 }">
							                        <input type="radio" id="inlineRadio1" value="0" name="info3" >
							                        <label for="inlineRadio1"> 男 </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							                        <input type="radio" id="inlineRadio2" value="1" name="info3" checked="checked">
							                        <label for="inlineRadio2"> 女 </label>
						                        </c:if>
						                        <c:if test="${teacher.sex!=1&&teacher.sex!=0}">
							                        <input type="radio" id="inlineRadio1" value="0" name="info3" checked="checked">
							                        <label for="inlineRadio1"> 男 </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							                        <input type="radio" id="inlineRadio2" value="1" name="info3">
							                        <label for="inlineRadio2"> 女 </label>
						                        </c:if>       
			                                </div>
			                            </div>
			                            
										<div class="form-group">
			                                <label class="col-sm-3 control-label">毕业院校：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info4" type="text" value="<s:property value="teacher.school"/>" placeholder="毕业院校" class="form-control"> 
			                                </div>
			                            </div>
			                            
										<div class="form-group">
			                                <label class="col-sm-3 control-label">科目：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info5" type="text" value="<s:property value="teacher.subject"/>" placeholder="教学科目" class="form-control"> 
			                                </div>
			                            </div>
			                            
										<div class="form-group">
			                                <label class="col-sm-3 control-label">教龄：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info6" type="text" value="<s:property value="teacher.teacthage"/>" placeholder="教龄" class="form-control"> 
			                                </div>
			                            </div>
			                            
										<div class="form-group">
			                                <label class="col-sm-3 control-label">邮箱：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info7" type="text" value="<s:property value="teacher.email"/>" placeholder="邮箱" class="form-control"> 
			                                </div>
			                            </div>

			                            <div class="form-group">
			                                <div class="col-sm-offset-3 col-sm-8">
			                                    <button class="btn btn-sm btn-info" onClick="updateinfo()">提 交</button>
			                                </div>
			                            </div>  
			                         </div>     
			                    </div>
                                
								<div id="tab-2" class="tab-pane" >
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

								<div id="tab-3" class="tab-pane" >		                            
			                            <div class="form-horizontal">
			                            <div class="form-group" style="margin-top:30px;">
			                                <label class="col-sm-3 control-label">直播码(fms)：</label>
			                                <div class="col-sm-8">
			                                    <input type="text" id="fms" class="form-control" style="width:80%;display:inline-block;" value="<s:property value="teacher.fms"/>">
												<button onClick="copyToBoard('fms')" type="button" class="btn btn-w-m btn-link" style="width:20%;float:right;display:inline-block;text-align:left;">点击复制</button>
			                                </div>
			                            </div>
			                            <div class="form-group">
			                                <label class="col-sm-3 control-label">串流码：</label>
			                                <div class="col-sm-8">
			                                    <input type="text" id="streamid" class="form-control" style="width:80%;display:inline-block;" value="<s:property value="teacher.streamid"/>">
												<button onClick="copyToBoard('streamid')" type="button" class="btn btn-w-m btn-link" style="width:20%;float:right;display:inline-block;text-align:left;">点击复制</button>
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
	var arg = $("#pwd1").val()+"-"+$("#pwd2").val();
	var result = ajaxSubmit("teacher_updatePassword.action",arg);
	if(result=="1"){
		parent.layer.msg('修改成功', {icon: 1});
	}else{
		parent.layer.msg('旧密码错误，修改失败', {icon: 2});
	}
}

function updateinfo(){
	var arg = $("#info1").val()+"-"+$("#info2").val()+"-"+$("input:radio:checked").val()+"-"+$("#info4").val()+"-"+$("#info5").val()+"-"+$("#info6").val()+"-"+$("#info7").val();
	var result = ajaxSubmit("teacher_updateInfo.action",arg);
	if(result=="1"){
		parent.layer.msg('修改成功', {icon: 1});
	}else{
		parent.layer.msg('修改失败', {icon: 2});
	}
}

function copyToBoard(arg){
   var e=document.getElementById(arg);//对象是contents   
   e.select(); //选择对象   
   tag=document.execCommand("Copy"); //执行浏览器复制命令  
   if(tag){  
   parent.layer.msg('文本复制成功', {icon: 1});
   }   
}

</script>

</html>
