<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改课程</title>

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
                        <h5 style="font-size:20px;color:#23b7e5;">填写课程信息</h5>
                        <div class="fa-hover col-md-3 col-sm-4" style="font-size:20px;width:120px;float:right;margin-right:0px;"><a class="back" onClick="Go('course_findByTeacherId.action')" style="color:#23B7E5" href="javascript:void(0)">返回 </a></div>                        
                    </div>
                    <div class="ibox-content">
                        <div class="form-horizontal">
							<form action="course_update.action" method="post" name="myform" enctype="multipart/form-data">
							<div class="form-group">
                                <label class="col-sm-3 control-label">课程名称：</label>
                                <div class="col-sm-8">
                                    <input type="text" id="info1" value="<s:property value="courseVo.course.name"/>" name="name" placeholder="课程名称" class="form-control"> 
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label class="col-sm-3 control-label">课程科目：</label>
                                <div class="col-sm-8">
                                    <input type="text" id="info2" value="<s:property value="courseVo.course.subject"/>" name="subject" placeholder="课程科目" class="form-control"> 
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label class="col-sm-3 control-label">课程简介：</label>
                                <div class="col-sm-8">
								    <textarea name="summary" id="info3" class="form-control" rows="3" placeholder="课程简介..."><s:property value="courseVo.course.summary"/></textarea>
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label class="col-sm-3 control-label">开始时间：</label>
                                <div class="col-sm-8">
                                   <input readonly name="time" id="info4" value="<s:property value="courseVo.time"/>" class="form-control layer-date" placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
                                </div>
                            </div>
                            </form>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button class="btn btn-sm btn-info" onClick="saveExam()">保 存</button>
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

<script src="js/plugins/layer/laydate/laydate.js"></script>
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

var picFile = $("#picFile");
var clipArea = new bjj.PhotoClip("#clipArea", {
	size: [428, 321],// 截取框的宽和高组成的数组。默认值为[260,260]
	outputSize: [428, 321], // 输出图像的宽和高组成的数组。默认值为[0,0]，表示输出图像原始大小
	outputType: "jpg", // 指定输出图片的类型，可选 "jpg" 和 "png" 两种种类型，默认为 "jpg"
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
		picFile.val(dataURL);
	}
 });
 //阻止表单提交
 var submitBtn = document.getElementById("clipBtn");
 submitBtn.onclick = function (event) {
  return false;
 };
 //提交表单
 function saveExam(){
	 var info1 = $("#info1").val();
	 var info2 = $("#info2").val();
	 var info3 = $("#info3").val();
	 var info4 = $("#info4").val();
	 if(info1 == "" || info2 == "" || info3 == "" || info4 == ""){
		 parent.layer.msg('信息填写不完整!', {icon: 2});
		 return ;
	 }else{
		 myform.submit();
	 }
 }

</script>
</html>
