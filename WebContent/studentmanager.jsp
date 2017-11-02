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

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-6" style="width:100%;">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>学生信息</h5>
                        <div class="ibox-tools">

                        </div>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-bordered table-hover" width="800px" style="text-align:center;">
							<thead align="center">
                                <tr>
                                    <th>序号</th>
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
										<tr>
											<td>${ste.index+1}</td>
											<td><s:property value="username"/></td>
											<td><s:property value="name"/></td>
											<td><s:property value="sex"/></td>
											<td><s:property value="tel"/></td>
											<td><s:property value="school"/></td>
											<td><s:property value="department"/></td>
											<td><s:property value="classandgrade"/></td>
											<td>
											 <a class="btn btn-primary btn-rounded" href="#">禁用</a>
											</td>
										</tr>
									</s:iterator>
								<tr>
									<td colspan="12">
									<div class="btn-group" style="float:right;">
										<button type="button" class="btn btn-white"><i class="fa fa-chevron-left"></i>
										</button>
										<button class="btn btn-white">1</button>
										<button class="btn btn-white  active">2</button>
										<button class="btn btn-white">3</button>
										<button class="btn btn-white">4</button>
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
    

</body>

</html>
    