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
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-6" style="width:100%;">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>教师信息</h5>
                        <div class="ibox-tools">
							<button type="button" class="btn btn-w-m btn-info" onClick="tijiao('addteacher.jsp')">添加教师</button>
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
                                    <th>FMS&nbsp;URL</th>
									<th>串流码</th>
									<th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                               		<s:iterator value="listteacher" status="ste">
										<c:if test="${ste.index<11}">
										<tr>
											<td>${ste.index+1}</td>
											<td><s:property value="username"/></td>
											<td><s:property value="name"/></td>
											<td><s:property value="tel"/></td>
											<td><s:property value="sex"/></td>
											<td><s:property value="subject"/></td>
											<td><s:property value="school"/></td>
											<td><s:property value="teachtage"/></td>
											<td><s:property value="email"/></td>
											<td><s:property value="fms"/></td>
											<td><s:property value="streamid"/></td>
											<td>
											 <a class="btn btn-primary btn-rounded" href="#">修改</a>
										     <a class="btn btn-success btn-rounded" href="#">删除</a>
											</td>
										</tr>
										</c:if>
									</s:iterator>
                               
                               

								<tr>
									<td colspan="12">
									<div class="btn-group" style="float:right;">
										<c:if test="${pageDirection[0]==1 }">
										  <button type="button" class="btn btn-white" onClick="To('${pageDirectionNumber[0]}')"><i class="fa fa-chevron-left"></i></button>
										</c:if>
												<c:forEach items="${pages}" var="index" begin="0" >
												  <c:if test="${index==enablePageNumber}">
												      <button class="btn btn-white active" onClick="To('${index}')">${index}</button>
												  </c:if>
												  <c:if test="${index!=enablePageNumber}">
												      <button class="btn btn-white" onClick="To('${index}')">${index}</button>
												  </c:if>					  
												</c:forEach>
										<c:if test="${pageDirection[1]==1 }">
										  <button type="button" class="btn btn-white" onClick="To('${pageDirectionNumber[1]}')"><i class="fa fa-chevron-right"></i></button>
										</c:if>
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
<!--

    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>



    <script src="js/plugins/peity/jquery.peity.min.js"></script>


    <script src="js/content.js?v=1.0.0"></script>


 
    <script src="js/plugins/iCheck/icheck.min.js"></script>


    <script src="js/demo/peity-demo.js"></script>

    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

 -->   
    
<script>
function tijiao(url){
window.location=url;
}
function To(arg){
	window.location="teacher_findEnableByPageNumber.action?enablePageNumber="+arg;
	
}
</script>

</body>

</html>
    