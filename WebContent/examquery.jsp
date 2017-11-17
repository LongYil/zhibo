<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>试题管理</title>

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <link href="css/layui.css" rel="stylesheet">
    
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
                        <span style="float:left;">我的试题</span>
                        <div class="ibox-tools">
							<button type="button" class="btn btn-w-m btn-info" onClick="findExam()">查找试题&nbsp;&nbsp;<i class="fa fa-search"></i></button>
                            <span style="margin-right:10px;">&nbsp;</span>                        
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-bordered table-hover" width="800px" style="text-align:center;">
							<thead align="center">
                                <tr>
                                    <th style="width:10%;">编号</th>
                                    <th style="width:10%;">所属教师</th>
                                    <th style="width:35%;">试题名称</th>
									<th style="width:35%;">试题描述</th>    
									<th style="width:10%;">操作</th>
                                </tr>
                            </thead>
                            <tbody>
									<s:iterator value="listExamVo" status="ste">
											<tr>
												<td><s:property value="exam.id"/></td>
												<td><s:property value="teacherName"/></td>
												<td><s:property value="exam.name"/></td>
												<td><s:property value="exam.describes"/></td>
												<td>
												 <a class="btn btn-info btn-rounded" href="javascript:void(0)" onClick="delete('<s:property value="exam.fileaddress"/>')">下载</a>
												 <a class="btn btn-danger btn-rounded" href="javascript:void(0)" onClick="delete('<s:property value="exam.id"/>')">删除</a>
												</td>
											</tr>
									</s:iterator>
                            </tbody>
                        </table> 
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


<script src="js/ajaxcommunicate.js"></script>

<script type="text/javascript">
function forbidden(arg1,arg2){
	parent.layer.confirm('确定禁用学生:'+arg2+'？', {
	    btn: ['确定','取消'], //按钮
	    shade: false //不显示遮罩
	}, function(){
		var text = ajaxSubmit("student_forbidden.action",arg1); 
		if(text=="1"){
			parent.layer.msg('已禁用', {icon: 1});
			window.location="student_findAllEnable.action";
		}else{
			parent.layer.msg('禁用失败', {icon: 2});
		}	    
	}, function(){
	    parent.layer.msg('已取消', {shift: 6});
	});
}


function To(arg){
	window.location="exam_findByPageNumber.action?pageNumber="+arg;
}

function findExam(){
	  layer.prompt({title: '请输入试题名称、描述:', formType: 0},function(value, index, elem){
	  layer.close(index);
	  window.location="exam_findByName.action?queryInfo="+value; 
	});
}
</script>

</html>
    