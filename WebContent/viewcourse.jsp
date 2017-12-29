<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>课程信息</title>

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
    text-align: center;
    }
    </style>	
</head>

<body class="gray-bg">
			<div class="col-sm-6" style="width:100%;">
                <div class="ibox float-e-margins" style="width:60%;height:80%;margin:0 auto;"> 
                    <div class="ibox-title" >
                        <h5 style="font-size:20px;color:#23b7e5;">课程信息</h5>
                        <div class="fa-hover col-md-3 col-sm-4" style="font-size:20px;width:120px;float:right;margin-right:0px;"><a class="back" style="color:#23B7E5" onClick="Go('course_findByTeacherId.action')" style="color:#23B7E5" href="javascript:void(0)">返回 </a></div>                        
                    </div>
                    <div class="ibox-content">
                        <div class="form-horizontal">
							<div class="form-group">
                                <label class="col-sm-3 control-label">课程名称：</label>
                                <div class="col-sm-8">
                                    <input type="text" style="width:80%;" value="<s:property value="courseVo.course.name"/>" name="name" placeholder="课程名称" class="form-control"> 
                                </div>
                            </div>

                            
							<div class="form-group">
                                <label class="col-sm-3 control-label">课程科目：</label>
                                <div class="col-sm-8">
                                    <input type="text" style="width:80%;" value="<s:property value="courseVo.course.subject"/>" name="subject" placeholder="课程科目" class="form-control"> 
                                </div>
                            </div>
							<div class="form-group">
                                <label class="col-sm-3 control-label">课程简介：</label>
                                <div class="col-sm-8">
								    <textarea style="width:80%;" class="form-control" rows="3" placeholder="课程简介..."><s:property value="courseVo.course.summary"/></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">课程封面封面：</label>
                                <div class="col-sm-8">
				                    <div class="col-md-12 col-sm-12 col-xs-12" style="padding:0;">
							        	<div class="ycupload-mainbox">
							        		<div class="ycupload-main1" style="overflow:hidden;padding-left:25px;">
							        			<span style="float:left;color:#ff5a5a;font-size:24px;line-height:60px;font-weight:bold;margin-right:7px;">
							        			</span>
							        			<span style="float:left;color:#333;font-size:16px;line-height:60px;margin-right:28px;">
							        			</span>
							        		</div>
							        		<div class="ycupload-line"></div>
							        		<div  style="min-height:1px;">
							        			<div class="container">
										        	<div class="row">
												        <div class="col-md-12 col-sm-12 col-xs-12" style="padding-right:0;padding-left:36px;">
												        	<div style="min-height:1px;line-height:160px;text-align:center;position:relative;">
												        		<div class="cover-wrap" style="display:none;position:fixed;left:0;top:0;width:100%;height:100%;background: rgba(0, 0, 0, 0.4);z-index: 10000000;text-align:center;">	
												        			<div class="" style="width:900px;height:600px;margin:0px auto;background-color:#FFFFFF;overflow: hidden;border-radius:4px;">
												        				<div id="clipArea" style="margin:10px;height: 520px;"></div>
												        				<div class="" style="height:56px;line-height:36px;text-align: center;padding-top:8px;">
												        					<button id="clipBtn" style="width:120px;height: 36px;border-radius: 4px;background-color:#ff8a00;color: #FFFFFF;font-size: 14px;text-align: center;line-height: 36px;outline: none;">保存封面</button>
												        				</div>
												        			</div>
												        		</div>
												        		<img style="margin-left:-35px;width:214px;height:160.5px;float:left;" src="<s:property value='courseVo.course.face'/>">
													        	<div style="height:10px;"></div>
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
                                <label class="col-sm-3 control-label">开始时间：</label>
                                <div class="col-sm-8">
                                   <input value="<s:property value="courseVo.course.time"/>" style="width:80%;" class="form-control" >
                                </div>
                            </div>
                            
                            <div class="form-group" style="margin-top:30px;">
                                <label class="col-sm-3 control-label">直播码(fms)：</label>
                                <div class="col-sm-8">
                                    <input type="text" id="fms" class="form-control" style="width:80%;display:inline-block;" value="<s:property value='courseVo.liveId'/>">
									<button onClick="copyToBoard('fms')" type="button" class="btn btn-w-m btn-link" style="width:20%;float:right;display:inline-block;text-align:left;">点击复制</button>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label">串流码：</label>
                                <div class="col-sm-8">
                                    <input type="text" id="streamid" class="form-control" style="width:80%;display:inline-block;" value="<s:property value='courseVo.streamId'/>">
									<button onClick="copyToBoard('streamid')" type="button" class="btn btn-w-m btn-link" style="width:20%;float:right;display:inline-block;text-align:left;">点击复制</button>
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

function copyToBoard(arg){
	   var e=document.getElementById(arg);//对象是contents   
	   e.select(); //选择对象   
	   tag=document.execCommand("Copy"); //执行浏览器复制命令  
	   if(tag){  
	   parent.layer.msg('文本复制成功', {icon: 1});
	   }   
	}
 //阻止表单提交
 var submitBtn = document.getElementById("clipBtn");
 submitBtn.onclick = function (event) {
  return false;
 };

</script>
</html>
