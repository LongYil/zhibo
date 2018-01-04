<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>理学院教学直播</title>
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="css/layui.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <link href="css/mainstyle.css" rel="stylesheet" type="text/css">
  </head>

  <body  class="container-fluid">
    <header style="overflow:visible;">
      <div class="row">
        <div class="col-sm-2 col-md-2 col-lg-2"></div>
        <div class="col-sm-4 col-md-4 col-lg-4" id="logo">
          <a href="index.jsp"><h1>LOGO理学院直播</h1></a>
        </div>
        <div class="col-sm-3 col-md-3 col-lg-3">  
         <input type="text" class="form-control input-search" placeholder="请输入教师姓名、课程名称" id="searchbox"/>
         <button class="btn btn-info btn-search" onClick="query()"><img src="images/sousuo.png" alt=""></button>
        </div>
        
        <c:if test="${userStaticStatus==1}">
	        <div class="col-sm-3 col-md-3 col-lg-3">
	         <span class="q-person">
	          <img src="${tempPicPath}" alt="" width="28px" height="28px" class="img-circle">
	            <div class="btn-group">
	                <button type="button" class="btn  dropdown-toggle btn-sm" data-toggle="dropdown" id="q-person-btn">${userName}
	                  <img src="images/xialakuang_black.png" alt="" style="padding-bottom: 3px;">
	                </button>
	                <ul class="dropdown-menu" role="menu">
	                    <li>
	                        <a href="javascript:void(0)" onClick="personalCenter()">个人中心</a>
	                    </li>
	                    <li>
	                        <a href="javascript:void(0)" onClick="logout()">退出登录</a>
	                    </li>
	                </ul>
	            </div>
	          </span>
	        </div>
        </c:if>
        
        <c:if test="${userStaticStatus!=1}">
	        <div class="col-sm-3 col-md-3 col-lg-3">
	          <a href="javascript:void(0)" id="linkbt1">登录</a>
	          <a>|</a>
	          <a href="javascript:void(0)" id="linkbt2">注册</a>
	        </div>        
        </c:if>

      </div>
    </header>
    
	
    <div id="light1"></div><!-- 登录弹窗 -->
    <div id="fade1" class="login-body">
      <div class="head">
        <a id="line">登录</a>
        <a id="turn2">注册</a>
      </div>

      <a href="javascript:void(0)" id="closebt1" style="float:right; font-size:30px;margin-top: -55px;margin-right:0;padding:0;color: #dbdbdb;">&times;</a>
      <div class="content">
        <p class="loginInfo">手机号登录</p>
        <form action="login_login.action" name="myRegistForm" method="post">
        <input type="text" name="username" id="username" placeholder="输入手机号">
        <input type="password" name="password" id="password" placeholder="输入密码">
                 学生<input type="radio" style="height:13px;width:30px;display:inline-block;" checked name="usertype" value="0">
                 教师<input type="radio" style="height:13px;width:30px;display:inline-block;" name="usertype" value="1">
                 管理员<input type="radio" style="height:13px;width:30px;display:inline-block;" name="usertype" value="2">
        </form>
        <button class="button" onClick="submit()">登  录</button>
      </div>

    </div>
	
    <div id="light2"></div><!-- 注册弹窗 -->
    <div id="fade2" class="register-body">
      <div class="head">
        <a id="turn1" href="javascript:void(0)">登录</a>
        <a id="line" href="javascript:void(0)">注册</a>
        <a href="javascript:void(0)" id="closebt2" style="float:right; font-size:30px;margin-top: -18px;margin-right: -65px;padding:0;color: #dbdbdb;">&times;</a>
      </div>
      <div class="content">
        <p>手机注册</p>
        <form action="student_add.action" method="post" name="registeform">
        <input type="text" name="tel" id="usertel" class="info1" placeholder="输入手机号" onblur="checkAccount()">
        <input type="password" name="password" class="info2" placeholder="输入密码">
        <input type="password" name="" class="info3" placeholder="再次输入密码">
        <input class="input-yz" type="text" id="vc" name="" placeholder="输入验证码">
        <a id="yz"><span id="v_container" class="img-yz" style="width:131px;height:51px;"></span></a>
        </form>
        <button class="button" onClick="registe()">注  册</button>
      </div>
    </div>
    <div class="clearfix visible-xs-block"></div>
    
    <div class="row nav">
      <div class="col-sm-3 col-md-3 col-lg-3"></div>
      <div class="col-sm-6 col-md-6 col-lg-6">
          <ul style="padding-left: 0;">
            <li><a href="index.jsp" class="tooltips" style="color: #198fee;">教学直播<span class="triangle"></span></a></li>
          </ul>
          <ul>
            <li><a href="review.jsp" class="tooltips">教学回顾<span></span></a></li>
          </ul>
          <ul>
            <li><a href="test.jsp" class="tooltips">试 题 库<span></span></a></li>
          </ul>
      </div>
      <div class="col-sm-3 col-md-3 col-lg-3"></div>
    </div>
    <div class="row banner">
      <div class="col-sm-12 col-md-12 col-lg-12">
        <div class="wrap af4">
          <ul class="slidebox">
	          <c:forEach items="${arrayCarousel}" var="item">
	              <li><a href="javascript:void(0)"><img  src="${item}"></a></li>
	          </c:forEach>
          </ul>
        </div>
      </div>
    </div>

    <div class="row content-body">
      <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
        <div class="data-body">
	          <div class="data">
	               <a href="course_findByDate.action?sdate=<s:property value="rencentweek2[0]"/>"><p><s:property value="rencentweek1[0]"/><br/>星期日</p></a>
	          </div>
	          <div class="data">
	               <a href="course_findByDate.action?sdate=<s:property value="rencentweek2[1]"/>"><p><s:property value="rencentweek1[1]"/><br/>星期一</p></a>
	          </div>
	          <div class="data">
	               <a href="course_findByDate.action?sdate=<s:property value="rencentweek2[2]"/>"><p><s:property value="rencentweek1[2]"/><br/>星期二</p></a>
	          </div>
	          <div class="data">
	               <a href="course_findByDate.action?sdate=<s:property value="rencentweek2[3]"/>"><p><s:property value="rencentweek1[3]"/><br/>星期三</p></a>
	          </div>
	          <div class="data">
	               <a href="course_findByDate.action?sdate=<s:property value="rencentweek2[4]"/>"><p><s:property value="rencentweek1[4]"/><br/>星期四</p></a>
	          </div>		        
	          <div class="data">
	               <a href="course_findByDate.action?sdate=<s:property value="rencentweek2[5]"/>"><p><s:property value="rencentweek1[5]"/><br/>星期五</p></a>          
	          </div>		        
	          <div class="data">
	               <a href="course_findByDate.action?sdate=<s:property value="rencentweek2[6]"/>" ><p><s:property value="rencentweek1[6]"/><br/>星期六</p></a>
	          </div>
        </div>

        <ul id='timeline'>
            
			<s:iterator value="listCourse" status="ste">
				<c:if test="${ste.index<6}">
			          <li class='work'>
			            <input class='radio' id='work6' name='works' type='radio' checked>
			            <div class="relative content1">
			              <label for='work6'>
			                <span><p><s:property value="time"/></p></span>
			                <span><img src="<s:property value='course.face'/>" style="width:74px;height:55px;" alt=""></span>
			                <span><p><s:property value="course.name"/></p></span>
			                <span><p><s:property value="teacher"/></p></span>
			                <c:if test="${course.coursetype==0}">
			                    <span><button class="btn button" onClick="watch('<s:property value='course.id'/>')" style="background-image:url('images/blue_bofang.png');background-repeat: no-repeat;background-position: 10% 50%;" onMouseOver="this.style.backgroundImage='url(images/orange_bofang.png)'" onMouseOut="this.style.backgroundImage='url(images/blue_bofang.png)'">观看直播</button></span>
			                </c:if>
			                <c:if test="${course.coursetype==1}">
			                    <span><button class="btn button" onClick="watch('<s:property value='course.id'/>')" style="background-image:url('images/blue_bofang.png');background-repeat: no-repeat;background-position: 10% 50%;" onMouseOver="this.style.backgroundImage='url(images/orange_bofang.png)'" onMouseOut="this.style.backgroundImage='url(images/blue_bofang.png)'">观看录播</button></span>
			                </c:if>
			              </label>
			              <span class="border"><span class='circle'></span></span>
			            </div>
			          </li>
				</c:if>
			</s:iterator>
        </ul>
        <div class="page">
			<c:if test="${pageDirectioni[0]==1 }">
			  <a href="javascript:void(0)" onClick="To('${pageDirectionNumberi[0]}')">&lt;</a>
			</c:if>
					<c:forEach items="${pages}" var="index" begin="0" >
					  <c:if test="${index==pageNumber}">
					      <a href="javascript:void(0)" style="color:blue;font-size:bold;"  onClick="To('${index}')">${index}</a>
					  </c:if>
					  <c:if test="${index!=pageNumber}">
					      <a href="javascript:void(0)" onClick="To('${index}')">${index}</a>
					  </c:if>
					</c:forEach>
			<c:if test="${pageDirectioni[1]==1 }">
			  <a href="javascript:void(0)" onClick="To('${pageDirectionNumberi[1]}')">&gt;</a>
			</c:if>
        </div>
      </div>
    </div>

    <div class="row footer">
      <div class="col-sm-12 col-md-12 col-lg-12">
        <div class="col-sm-4 col-md-4 col-lg-4 footer-border footer-right">
          <h3>联系我们</h3>
          <p>电话：12345678900</p>
          <p>邮箱：525000</p>
          <p>地址：广东石油化工学院（官渡校区）</p>
        </div>
        <div class="col-sm-2 col-md-2 col-lg-2 footer-border">
          <h3>课程教材</h3>
          <p><a href="">论文</a></p>
          <p><a href="">考研</a></p>
          <p><a href="">论文</a></p>
          <p><a href="">考研</a></p>
        </div>
        <div class="col-sm-2 col-md-2 col-lg-2 footer-border">
          <h3>友情链接</h3>
          <p><a href="">云课直播</a></p>
          <p><a href="">YY直播</a></p>
          <p><a href="">虎牙直播</a></p>
          <p><a href="">斗鱼直播</a></p>
        </div>
        <div class="col-sm-4 col-md-4 col-lg-4">
          <h3>关注我们</h3>
          <img src="images/erweima.png" alt="">
        </div>
      </div>
      <div class="col-sm-12 col-md-12 col-lg-12">
        <p class="copyright">版权所有  Copyright© 2015,  YEDA,  All Rights Reserved</p>
      </div>
    </div>

  </body>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="bootstrap/js/jquery-3.2.1.min.js" type="text/javascript"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="js/L_slide.js" type="text/javascript"></script>
  <script src="js/ajaxcommunicate.js"></script>
  <script src="js/gVerify.js"></script>
  <script src="js/open.js" type="text/javascript"></script>
  <script src="layui.all.js"></script>
  <script type="text/javascript">
  var verifyCode = new GVerify("v_container");
  function To(arg){
	  window.location="course_findRecentByPage.action?pageNumber="+arg;
  }
  
  function hqyzm(){
	  var tel = $("#usertel").val();
	  ajaxSubmit("exam_delete.action",tel); 
  }
  function query(){
	  var info = $("#searchbox").val();
	  window.location="course_studentFindByInfo.action?queryInfo="+info;
  }
  function checkAccount(){
	  var tel = $("#usertel").val();
	  var result = ajaxSubmit("student_checkAccount.action",tel);
	  if(result=="0"){
		  parent.layer.msg('该手机号注册!', {icon: 2});
	  }else{
		  ;
	  }
  }


  function registe(){
	  var info1 = $(".info1").val();
	  var info2 = $(".info2").val();
	  var info3 = $(".info3").val();
	  var info5 = checkPhone(info1);
	  var vc = $("#vc").val();
	  if(info1 == "" || info2 == "" || info3 == "" || vc == ""){
		  parent.layer.msg('信息填写不完整!', {icon: 2});
	  }else{
		  if(info5){
			  if(info2 == info3){
				  if(info2.length >8){
					  var info4 = ajaxSubmit("student_checkVerificationCode.action",vc); 
					  if(info4 == "0"){
						  parent.layer.msg('验证码输入错误!', {icon: 2});
						  verifyCode.refresh();
					  }else{
						  registeform.submit();
					  }					  
				  }else{
					  parent.layer.msg('密码至少为9位!', {icon: 2});
				  }				  
			  }else{
				  parent.layer.msg('两次密码不一致!', {icon: 2});
			  }
		  }else{
			  parent.layer.msg('手机号码格式错误!', {icon: 2}); 
		  }
	  }
  }
  function logout(){
	  window.location="login_logout.action";
  }
  function personalCenter(){
	  window.location="login_personalCenter.action";
  }
  function watch(arg){
	  window.location = "course_watch.action?courseId="+arg;
  }
  function openlogin(){
		var fade1=document.getElementById('fade1');
		var fade2=document.getElementById('fade2');
		var light1=document.getElementById('light1'); 
		light1.style.display='block';
		fade1.style.display='block';
		fade2.style.display='none';
  }
  
  function submit(){
	  var username = $("#username").val().toString();
	  var password = $("#password").val().toString();
	  if(username == "" || password == ""){
		  parent.layer.msg('登录信息不完整!', {icon: 2}); 
		  return ;
	  }	  
	  var usertype = $("input[name='usertype']:checked").val().toString();
	  var tempinfo = (usertype+"-"+username+"-"+password).toString();
	  var resultinfo = ajaxSubmit("login_preLogin.action",tempinfo);
	  if(resultinfo == 1){
		  myRegistForm.submit();  
	  }else{
		  $(".loginInfo").html("用户名和密码不匹配").css("color","#e9686b");
		  $("#username").val("");
		  $("#password").val("");
		  setTimeout(function(){
			  $(".loginInfo").html("手机号登录").css("color","#000000");
			  }, 2500);
	  }
  }
  </script>
  <c:if test="${loginstatus == 0}">
	  <script type="text/javascript">
          openlogin();
	  </script>
  </c:if>
</html>