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
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <link href="css/mainstyle.css" rel="stylesheet" type="text/css">
  </head>

  <body  class="container-fluid">
    <header style="overflow: visible;">
      <div class="row">
        <div class="col-sm-2 col-md-2 col-lg-2"></div>
        <div class="col-sm-4 col-md-4 col-lg-4" id="logo">
          <a href="index.jsp"><h1>LOGO理学院直播</h1></a>
        </div>
        <div class="col-sm-3 col-md-3 col-lg-3">  
         <input type="text" class="form-control input-search" placeholder="Search" />
         <button class="btn btn-info btn-search"><img src="images/sousuo.png" alt=""></button>
        </div>  

        <c:if test="${studentUserStatus==1}">
	        <div class="col-sm-3 col-md-3 col-lg-3">
	         <span class="q-person">
	          <img src="images/touxiang1.png" alt="" class="img-circle">
	            <div class="btn-group">
	                <button type="button" class="btn  dropdown-toggle btn-sm" data-toggle="dropdown" id="q-person-btn">${Student.name}
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
        <a href="" id="yz"><img src="images/yanzhengma.png" class="img-yz" alt=""></a>
        <a href="" id="sx"><img src="images/shuaxin.png" class="img-sx" alt=""></a>
        <button class="button">注  册</button>
      </div>
    </div>
    <div class="clearfix visible-xs-block"></div>

     <div class="row nav">
      <div class="col-sm-3 col-md-3 col-lg-3"></div>
      <div class="col-sm-6 col-md-6 col-lg-6">
          <ul style="padding-left: 0;">
            <li><a href="index.jsp" class="tooltips">教学直播<span></span></a></li>
          </ul>
          <ul>
            <li><a href="review.jsp" class="tooltips">教学回顾<span></span></a></li>
          </ul>
          <ul>
            <li><a href="test.jsp" class="tooltips" style="color: #198fee;">试 题 库<span class="triangle"></span></a></li>
          </ul>
      </div>
      <div class="col-sm-3 col-md-3 col-lg-3"></div>
    </div>

    <div class="row content-body">
      <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
        <div class="content-questions">
          <div><h1><s:property value="examName"/>(共<s:property value="examNumber"/>题)</h1></div>
          <input type="hidden" value="<s:property value="examNumber"/>" id="examNumber">
            <s:iterator value="listAnalysedExam" status="ste">
	            <div class="questions-body" id="question<s:property value="id"/>">
	            <div><p><s:property value="id"/>、<s:property value="question"/></p></div>
	            <div class="checkbox">
	                <label>
	                    <input type="radio" name="optionsRadios<s:property value="id"/>" value="A" >A.<s:property value="optionA"/></label>
	            </div>
	            <div class="checkbox">
	                <label>
	                    <input type="radio" name="optionsRadios<s:property value="id"/>" value="B" >B.<s:property value="optionB"/></label>
	            </div>
	            <div class="checkbox">
	                <label>
	                    <input type="radio" name="optionsRadios<s:property value="id"/>" value="C" >C.<s:property value="optionC"/></label>
	            </div>
	            <div class="checkbox">
	                <label>
	                    <input type="radio" name="optionsRadios<s:property value="id"/>" value="D" >D.<s:property value="optionD"/></label>
	            </div>
	            <p class="result<s:property value="id"/>" style="color:#dea050;"></p>
                </div>
			</s:iterator>
			<p class="anwser"></p>
        </div>
        <div class="questions-footer">
          <button onClick="submitMyAnswer()">提&nbsp;&nbsp;交</button>
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

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="bootstrap/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/open.js" type="text/javascript"></script>
    <script src="js/ajaxcommunicate.js"></script>
    
    <script type="text/javascript">
    function submitMyAnswer(){
    	var temp="E";
    	var examNumber = $("#examNumber").val();
    	for(var i=1;i<examNumber;i++){
    		var question = "input[name='optionsRadios"+i+"']:checked";
    		var answer = $(question).val();
    		if(answer==undefined){
    			answer="E";
    		}
    		temp = temp + "-" + answer;
    	}
    	var tempresult = ajaxSubmit("exam_calculateResult.action",temp);
		var temp1 = JSON.parse(tempresult);
		temp1 = eval(temp1.info);
	    for(var i=0;i<(temp1.length-1);i++){  
	       var resultinfo = temp1[i].result;
	       var pname = ".result"+(i+1);
	       $(pname).html(resultinfo);
	    }
    	$(".anwser").html(temp1[temp1.length-1].result);
    }
    function registe(){
  	  registeform.submit();
    }
    function logout(){
  	  window.location="login_logout.action";
    }
    function personalCenter(){
  	  window.location="login_personalCenter.action";
    }    
    </script>
  </body>
</html>
