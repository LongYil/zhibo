<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>轮播图片管理</title>

    <link rel="shortcut icon" href="images/logo.jpg">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <link href="css/layui.css" rel="stylesheet">

    <script src="js/base-loading.js"></script>
       
    <style type="text/css">
    body{
    font-size: 14px;
    text-align: center;
    }    
    </style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-6" style="width:100%;">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <span style="float:left;">轮播图片</span>
                        <div class="ibox-tools"  style="margin-bottom:5px;">  
                            <button type="button" class="btn btn-w-m btn-info" onClick="uploadImg()">添加图片&nbsp;&nbsp;<i class="fa fa-upload"></i></button>
                            <span style="margin-right:10px;">&nbsp;</span>                                                                           
                        </div>
                    </div>
	                    <div class="ibox-content">
							<s:iterator value="listImg" status="ste">
		                        <a class="fancybox" href="javascript:void(0)" onClick="deleteImg('<s:property value="id"/>')">
		                            <img alt="image" src="<s:property value="face"/>" id="<s:property value="id"/>"/>
		                        </a>
	                        </s:iterator>							
	                    </div>                   
                </div>
            </div>
        </div>

    </div>

</body>
    <!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/plugins/layer/layer.min.js"></script>
<script src="js/content.js?v=1.0.0"></script>
<script src="js/ajaxcommunicate.js"></script>
<script src="layui.all.js"></script>


<script type="text/javascript">

	function uploadImg(){
		window.location="carousel_uploadImg.action";
	}
	
	function deleteImg(arg1){
		const OUT_OPACITY = 0.7;
		const OVER_OPACITY = 1.0;  
		$("#"+arg1).css("opacity", OUT_OPACITY);
		parent.layer.confirm('确定删除这张图片吗?', {
		    btn: ['确定','取消'], //按钮
		    shade: false //不显示遮罩
		}, function(){
			var tempInfo = ajaxSubmit("carousel_deleteImg.action",arg1);
			if(tempInfo == "1"){
				parent.layer.msg('删除成功', {icon: 1});
				window.location="carousel_findAll.action";
			}else{
				parent.layer.msg('删除失败', {icon: 2});
			}
		}, function(){
		    parent.layer.msg('已取消', {shift: 6});
		    $("#"+arg1).css("opacity", OVER_OPACITY);
		});
	}
</script>
</html>