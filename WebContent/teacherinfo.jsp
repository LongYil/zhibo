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

	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="plugins/cover_js/iscroll-zoom.js" type="text/javascript" charset="utf-8"></script>
	<script src="plugins/cover_js/hammer.js" type="text/javascript" charset="utf-8"></script>
	<script src="plugins/cover_js/lrz.all.bundle.js" type="text/javascript" charset="utf-8"></script>
	<script src="plugins/cover_js/jquery.photoClip.min.js" type="text/javascript" charset="utf-8"></script>
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
                                <li class=""><a data-toggle="tab" href="#basicinfo"><i class="fa fa-user"></i>基本信息</a></li>
                                <li class="active"><a data-toggle="tab" href="#usericon"><i class="fa fa-file-picture-o"></i>用户头像</a></li>
                                <li class=""><a data-toggle="tab" href="#tab-3"><i class="fa fa-lock"></i>安全设置</a></li>
                            </ul>
                            <div class="tab-content">
                                <div id="basicinfo" class="tab-pane">
			                   		<div class="ibox-content">
						
										<div class="form-group" style="margin-top:10px;">
			                                <label class="col-sm-3 control-label">教师姓名：</label>
			                                <div class="col-sm-8">
			                                    <input name="name" id="info1" type="text" value="<s:property value="teacher.name"/>" placeholder="教师姓名" class="form-control"> 
			                                    <span class="help-block m-b-none">请输入教师姓名</span>
			                                </div>
			                            </div>

										<div class="form-group">
			                                <label class="col-sm-3 control-label">手机号：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info2" type="text" value="<s:property value="teacher.tel"/>" placeholder="手机号" class="form-control"> 
			                                    <span class="help-block m-b-none">请输入教师手机号</span>
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
			                                </div>
			                            </div>
			                            
										<div class="form-group">
			                                <label class="col-sm-3 control-label">毕业院校：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info4" type="text" value="<s:property value="teacher.school"/>" placeholder="毕业院校" class="form-control"> 
			                                    <span class="help-block m-b-none">请输入您的毕业院校</span>
			                                </div>
			                            </div>
			                            
										<div class="form-group">
			                                <label class="col-sm-3 control-label">科目：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info5" type="text" value="<s:property value="teacher.subject"/>" placeholder="教学科目" class="form-control"> 
			                                    <span class="help-block m-b-none">请输入您的教学科目</span>
			                                </div>
			                            </div>
			                            
										<div class="form-group">
			                                <label class="col-sm-3 control-label">教龄：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info6" type="text" value="<s:property value="teacher.teacthage"/>" placeholder="教龄" class="form-control"> 
			                                    <span class="help-block m-b-none">请输入您的教龄</span>
			                                </div>
			                            </div>
			                            
										<div class="form-group">
			                                <label class="col-sm-3 control-label">邮箱：</label>
			                                <div class="col-sm-8">
			                                    <input name="tel" id="info7" type="text" value="<s:property value="teacher.email"/>" placeholder="邮箱" class="form-control"> 
			                                    <span class="help-block m-b-none">请输入您的邮箱</span>
			                                </div>
			                            </div>

			                            <div class="form-group">
			                                <div class="col-sm-offset-3 col-sm-8">
			                                    <button class="btn btn-sm btn-info" onClick="updateinfo()">提 交</button>
			                                </div>
			                            </div>
			                        
			                        </div>

                                </div>		
								<div id="usericon" class="tab-pane active">
                                    <div class="ibox-content">
                                    <h5 style="font-size:20px;color:#ffa81e;margin-bottom:30px;">自定义头像</h5>
						        		
						        		<div  style="min-height:1px;">
						        			<div class="container">
									        	<div class="row">
											        <div class="col-md-12 col-sm-12 col-xs-12" style="padding-right:0;padding-left:36px;">
											        	<div style="min-height:1px;line-height:160px;text-align:center;position:relative;" ontouchstart="">
											        		<div class="cover-wrap" style="display:none;position:fixed;left:0;top:0;width:100%;height:100%;background: rgba(0, 0, 0, 0.4);z-index: 10000000;text-align:center;">	
											        			<div class="" style="width:900px;height:600px;margin:100px auto;background-color:#FFFFFF;overflow: hidden;border-radius:4px;">
											        				<div id="clipArea" style="margin:10px;height: 520px;"></div>
											        				<div class="" style="height:56px;line-height:36px;text-align: center;padding-top:8px;">
											        					<button id="clipBtn" style="width:120px;height: 36px;border-radius: 4px;background-color:#ff8a00;color: #FFFFFF;font-size: 14px;text-align: center;line-height: 36px;outline: none;">保存封面</button>
											        				</div>
											        			</div>
											        		</div>
											        		<div id="view" style="background-image:url('img/a1.jpg');width:300px;height:300px;" title="请上传 430*430的封面图片"></div>
												        	
												        	<div style="height:10px;"></div>
												        	<div class="" style="width:140px;height:32px;border-radius: 4px;background-color:#ff8a00;color: #FFFFFF;font-size: 14px;text-align:center;line-height:32px;outline:none;margin-left:37px;position:relative;">
												        		点击上传头像
												        		<input type="file" id="file" style="cursor:pointer;opacity:0;filter:alpha(opacity=0);width:100%;height:100%;position:absolute;top:0;left:0;">
												        	</div>
											        	</div>
										        	</div>
									        	</div>
								        	</div>
						        		</div>
                                    </div> 
                                </div>
                                
								<div id="tab-3" class="tab-pane" >

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
</body>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/ajaxcommunicate.js"></script>
    
<script type="text/javascript">
var clipArea = new bjj.PhotoClip("#clipArea", {
	size: [480, 480],// 截取框的宽和高组成的数组。默认值为[260,260]
	outputSize: [480, 480], // 输出图像的宽和高组成的数组。默认值为[0,0]，表示输出图像原始大小
	//outputType: "jpg", // 指定输出图片的类型，可选 "jpg" 和 "png" 两种种类型，默认为 "jpg"
	file: "#file", // 上传图片的<input type="file">控件的选择器或者DOM对象
	view: "#view", // 显示截取后图像的容器的选择器或者DOM对象
	ok: "#clipBtn", // 确认截图按钮的选择器或者DOM对象
	loadStart: function() {
		// 开始加载的回调函数。this指向 fileReader 对象，并将正在加载的 file 对象作为参数传入
		$('.cover-wrap').fadeIn();
		console.log("照片读取中");
	},
	loadComplete: function() {
		 // 加载完成的回调函数。this指向图片对象，并将图片地址作为参数传入
		console.log("照片读取完成");
	},
	//loadError: function(event) {}, // 加载失败的回调函数。this指向 fileReader 对象，并将错误事件的 event 对象作为参数传入
	clipFinish: function(dataURL) {
		 // 裁剪完成的回调函数。this指向图片对象，会将裁剪出的图像数据DataURL作为参数传入
		$('.cover-wrap').fadeOut();
		$('#view').css('background-size','100% 100%');
		console.log(dataURL);
	}
});

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


</script>

</html>
    