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
    <link href="../bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="../css/main.css" rel="stylesheet" type="text/css">
    <link href="../css/mainstyle.css" rel="stylesheet" type="text/css">
  </head>

  <body  class="container-fluid">
    <header>
      <div class="row">
        <div class="col-sm-2 col-md-2 col-lg-2"></div>
        <div class="col-sm-4 col-md-4 col-lg-4" id="logo">
          <a href="../index.jsp"><h1>LOGO理学院直播</h1></a>
        </div>
        <div class="col-sm-3 col-md-3 col-lg-3">  
         <input type="text" class="form-control input-search" placeholder="Search" />
         <button class="btn btn-info btn-search"><img src="../images/sousuo.png" alt=""></button>
        </div>  
        <div class="col-sm-3 col-md-3 col-lg-3">
          <a href="javascript:void(0)" id="linkbt1">登录</a> 
          <a>|</a>
          <a href="javascript:void(0)" id="linkbt2">注册</a>
        </div>
      </div>
    </header>

    <div id="light1"></div><!-- 登录弹窗 -->
    <div id="fade1" class="login-body">
      <div class="head">
        <a id="line">登录</a>
        <a id="turn2">注册</a>
        <a href="javascript:void(0)" id="closebt1">&times;</a>
      </div>
      <div class="content">
        <p>手机号登录</p>
        <input type="text" name="" placeholder="输入手机号">
        <input type="password" name="" placeholder="输入密码">
        <button class="button">登  录</button>
      </div>
    </div>

    <div id="light2"></div><!-- 注册弹窗 -->
    <div id="fade2" class="register-body">
      <div class="head">
        <a id="turn1">登录</a>
        <a id="line">注册</a>
        <a href="javascript:void(0)" id="closebt2">&times;</a>
      </div>
      <div class="content">
        <p>手机注册</p>
        <input type="text" name="" placeholder="输入手机号">
        <input type="password" name="" placeholder="输入密码">
        <input type="password" name="" placeholder="再次输入密码">
        <input class="input-yz" type="text" name="" placeholder="输入下图的验证码">
        <a href="" id="yz"><img src="../images/yanzhengma.png" class="img-yz" alt=""></a>
        <a href="" id="sx"><img src="../images/shuaxin.png" class="img-sx" alt=""></a>
        <button class="button">注  册</button>
      </div>
    </div>
    <div class="clearfix visible-xs-block"></div>

    <div class="row nav">
      <div class="col-sm-3 col-md-3 col-lg-3"></div>
      <div class="col-sm-6 col-md-6 col-lg-6">
          <ul style="padding-left: 0;">
            <li><a href="../index.jsp" class="tooltips">教学直播<span></span></a></li>
          </ul>
          <ul>
            <li><a href="../review.jsp" class="tooltips" style="color: #198fee;">教学回顾<span class="triangle"></span></a></li>
          </ul>
          <ul>
            <li><a href="../shitiku/test.jsp" class="tooltips">试 题 库<span></span></a></li>
          </ul>
      </div>
      <div class="col-sm-3 col-md-3 col-lg-3"></div>
    </div>

    <div class="row banner">
      <div class="col-sm-12 col-md-12 col-lg-12">
        <div class="wrap af4">
          <ul class="slidebox">
            <li><a href="#"><img src="../images/lunbo.png" /></a></li>
            <li><a href="#"><img src="../images/lunbo.png" /></a></li>
            <li><a href="#"><img src="../images/lunbo.png" /></a></li>
            <li><a href="#"><img src="../images/lunbo.png" /></a></li>
          </ul>
        </div>
      </div>
    </div>

    <div class="row content-body">
      <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
        <div class="dateSelect">
          <div>2017年10月12日<img src="../images/rili.png" alt=""></div>
        </div>

        <div class="content-video">
			<s:iterator value="listCourse" status="ste">
				<c:if test="${ste.index<6}">
                   <div><a href="javascript:void(0)" onClick="play(<s:property value='course.address'/>)"><img src="<s:property value='course.face'/>" width="240px" height="152px" alt=""><p><s:property value='course.name'/>  <s:property value='teacher'/></p></a></div>
				</c:if>
			</s:iterator>
        </div>

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
          <img src="../images/erweima.png" alt="">
        </div>
      </div>
      <div class="col-sm-12 col-md-12 col-lg-12">
        <p class="copyright">版权所有  Copyright© 2015,  YEDA,  All Rights Reserved</p>
      </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="../bootstrap/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../js/L_slide.js" type="text/javascript"></script>
    <script src="../js/open.js" type="text/javascript"></script>
    <script type="text/javascript">
    function To(arg){
  	  window.location="course_studentFindByPageNumber.action?pageNumber="+arg;
    }
    function play(arg){
    	;
    }
    </script>
  </body>
</html>