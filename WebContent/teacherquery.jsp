<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>教师管理</title>

    <link rel="shortcut icon" href="images/logo.jpg">
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
                        <div class="ibox-tools"  style="margin-bottom:5px;"> 
                        <span style="float:left;">教师管理</span> 
                            <button type="button" class="btn btn-w-m btn-info" style="float:right;margin-left:10px;" onClick="addTeacher('teacher_addTeacher.action')">添加教师&nbsp;&nbsp;<i class="fa fa-plus-circle"></i></button>	                        
	                        <div class="input-group" style="width:20%;float:right;">
	                            <input type="text" id="searchInfo" placeholder="请输入教师姓名" class="input-sm form-control"> <span class="input-group-btn">
	                                <button type="button" class="btn btn-w-m btn-info" onClick="findTeacher()"> 搜索</button> </span>
	                        </div>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-bordered table-hover" width="800px" style="text-align:center;">
							<thead align="center">
                                <tr>
                                    <th>序号</th>
                                    <th>用户名</th>
                                    <th>姓名</th>
									<th>手机号</th>
                                    <th>性别</th>
									<th>科目名称</th>
                                    <th>毕业院校</th>
                                    <th>教龄</th>
                                    <th>邮箱</th>
                                    <th>房间号</th>
									<th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                               		<s:iterator value="listteacher" status="ste">
										<tr>
											<td>${ste.index+1}</td>
											<td><s:property value="username"/></td>
											<td><s:property value="name"/></td>
											<td><s:property value="tel"/></td>
											<c:if test="${listteacher[ste.index].sex==0 }">
											<td>男</td>
											</c:if>
											<c:if test="${listteacher[ste.index].sex==1 }">
											<td>女</td>
											</c:if>
											<c:if test="${listteacher[ste.index].sex!=1&&listteacher[ste.index].sex!=0}">
											<td></td>
											</c:if>
											<td><s:property value="subject"/></td>
											<td><s:property value="school"/></td>
											<td><s:property value="teachtage"/></td>
											<td><s:property value="email"/></td>
											<td><s:property value="roomid"/></td>
											<td>
											 <a class="btn btn-primary btn-rounded" onClick="updateTeacher('<s:property value="id"/>','<s:property value="username"/>')" href="javascript:void(0)">修改</a>
										     <a class="btn btn-success btn-rounded" onClick="deleteTeacher('<s:property value="id"/>','<s:property value="username"/>')" href="javascript:void(0)">删除</a>
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
<script src="js/jquery.min.js?v=2.1.4"></script>   
<script src="layui.all.js"></script>    
<script src="js/ajaxcommunicate.js"></script>  
<script>
	function deleteTeacher(arg1,arg2){
		parent.layer.confirm('确定删除教师:'+arg2+'？', {
		    btn: ['确定','取消'], //按钮
		    shade: false //不显示遮罩
		}, function(){
			var text = ajaxSubmit("teacher_delete.action",arg1);
			if(text=="1"){
				parent.layer.msg('已删除', {icon: 1});
				window.location="teacher_requery.action";
			}else{
				parent.layer.msg('删除失败', {icon: 2});
			}	    
		}, function(){
		    parent.layer.msg('已取消', {shift: 6});
		});
	}
	
	function updateTeacher(arg1){
		window.location="teacher_preUpdate.action?teacherTempId="+arg1;
	}
	
	function addTeacher(url){
		window.location=url;
	}
	
	function findTeacher(){
	      var value = $("#searchInfo").val();
		  window.location="teacher_findByName.action?teacherName="+value; 	    
	}
</script>
</body>
</html>