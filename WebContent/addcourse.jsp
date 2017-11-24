<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加课程</title>

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
                        <div class="fa-hover col-md-3 col-sm-4" style="font-size:20px;width:120px;float:right;margin-right:0px;"><a class="back" onClick="Go('exam_findAll.action')" href="javascript:void(0)">返回 </a></div>                        
                    </div>
                    <div class="ibox-content">
                        <div class="form-horizontal">
							<form action="exam_save.action" method="post" name="myform()" enctype="multipart/form-data">
							<div class="form-group">
                                <label class="col-sm-3 control-label">课程名称：</label>
                                <div class="col-sm-8">
                                    <input type="text" name="name" placeholder="课程名称" class="form-control"> 
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label class="col-sm-3 control-label">课程科目：</label>
                                <div class="col-sm-8">
                                    <input type="text" name="describes" placeholder="课程科目" class="form-control"> 
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label class="col-sm-3 control-label">课程简介：</label>
                                <div class="col-sm-8">
								    <textarea class="form-control" rows="3" placeholder="课程简介..."></textarea>
                                </div>
                            </div>
                            
							<div class="form-group">
                                <label class="col-sm-3 control-label">开始时间：</label>
                                <div class="col-sm-8">
                                   <input readonly class="form-control layer-date" placeholder="YYYY-MM-DD hh:mm:ss" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">

                                </div>
                            </div>

                          
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程封面封面：</label>
                                <div class="col-sm-8">
				                    <div class="col-md-12 col-sm-12 col-xs-12" style="padding:0;">
							        	<div class="ycupload-mainbox">
							        		<div class="ycupload-main1" style="overflow:hidden;padding-left:25px;">
							        			<span style="float:left;color:#ff5a5a;font-size:24px;line-height:60px;font-weight:bold;margin-right:7px;">
							        				&middot;
							        			</span>
							        			<span style="float:left;color:#333;font-size:16px;line-height:60px;margin-right:28px;">
							        				上传封面
							        			</span>
							        		</div>
							        		<div class="ycupload-line"></div>
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
												        				    <span>滚动鼠标滑轮可改变大小</span>
												        				</div>
												        			</div>
												        		</div>
												        		<div id="view" style="width:214px;height:160.5px;" title="请上传 428*321 的封面图片"></div>
													        	<div style="height:10px;"></div>
													        	<div class="" style="width:140px;height:32px;border-radius: 4px;background-color:#ff8a00;color: #FFFFFF;font-size: 14px;text-align:center;line-height:32px;outline:none;margin-left:37px;position:relative;">
													        		点击上传封面图
													        		<input type="file" name="examfile" id="file" style="cursor:pointer;opacity:0;filter:alpha(opacity=0);width:100%;height:100%;position:absolute;top:0;left:0;">
													        	    <input type="hidden" name="examPic" id="picFile">
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
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-8">
                                    <button class="btn btn-sm btn-info" onClick="saveExam()">保 存</button>
                                </div>
                            </div>
                            </form>
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
	 myform.submit();
 }

</script>
</html>
