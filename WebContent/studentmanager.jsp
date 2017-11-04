<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>学生管理</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <style type="text/css">
    body{
    font-size: 16px;
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
                        <h5>学生信息</h5>
                        <div class="ibox-tools">                            
                            <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">
                                <h3 style="display:inline-block;">切换:</h3>
                                <i class="fa fa-chevron-down"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="student_findAllEnable.action">未禁用</a>
                                </li>
                                <li><a href="student_findAllDisabled.action">已禁用</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-bordered table-hover" width="800px" style="text-align:center;">
							<thead align="center">
                                <tr>
                                    <th>编号</th>
                                    <th>用户名</th>
                                    <th>姓名</th>
									<th>性别</th>
									<th>手机号</th>     
									<th>学校</th>
                                    <th>学院</th>
                                    <th>班别</th>
									<th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
									
									<s:iterator value="liststudent" status="ste">
										<c:if test="${ste.index<11}">
											<tr>
												<td><s:property value="id"/></td>
												<td><s:property value="username"/></td>
												<td><s:property value="name"/></td>
												<td><s:property value="sex"/></td>
												<td><s:property value="tel"/></td>
												<td><s:property value="school"/></td>
												<td><s:property value="department"/></td>
												<td><s:property value="classandgrade"/></td>
												<c:if test="${userstatus=='1'}">
													<td>
													 <a class="btn btn-primary btn-rounded" href="javascript:void(0)" onClick="forbidden('<s:property value="id"/>','<s:property value="name"/>')">禁用</a>
													</td>											
												</c:if>
												<c:if test="${userstatus=='0'}">
													<td>
													 <a class="btn btn-success btn-rounded" href="javascript:void(0)" onClick="start('<s:property value="id"/>','<s:property value="name"/>')">取消禁用</a>
													</td>										
												</c:if>
											</tr>
										</c:if>									
									</s:iterator>
									
								<tr>
									<td colspan="12">
									<div class="btn-group" style="float:right;">
										<button type="button" class="btn btn-white"><i class="fa fa-chevron-left"></i>
										</button>
												<c:forEach items="${pages}" var="index" begin="0" >
												  <c:if test="${index==enablePageNumber}">
												      <button class="btn btn-white active" onClick="To('${index}')">${index}</button>
												  </c:if>
												  <c:if test="${index!=enablePageNumber}">
												      <button class="btn btn-white" onClick="To('${index}')">${index}</button>
												  </c:if>												  
												</c:forEach>
										<button type="button" class="btn btn-white"><i class="fa fa-chevron-right"></i>
										</button>
									</div>
									</td>
								</tr>
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
function start(arg1,arg2){
	parent.layer.confirm('确定取消禁用学生:'+arg2+'？', {
	    btn: ['确定','取消'], //按钮
	    shade: false //不显示遮罩
	}, function(){
		var text = ajaxSubmit("student_start.action",arg1); 
		if(text=="1"){
			parent.layer.msg('已取消禁用', {icon: 1});
			window.location="student_findAllDisabled.action";
		}else{
			parent.layer.msg('取消失败', {icon: 2});
		}	    
	}, function(){
	    parent.layer.msg('已取消', {shift: 6});
	});
}


function To(arg){
	window.location="student_findEnableByPageNumber.action?enablePageNumber="+arg;
	
}

</script>

</html>
    