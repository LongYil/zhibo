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
    <header style="overflow:visible;">
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
	         <img src="${tempPicPath}" alt="" width="28px" height="28px" class="img-circle">
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

    <div class="row content-body">
      <div class="col-sm-8 col-md-8 col-lg-8 col-sm-offset-2 col-md-offset-2 col-lg-offset-2">
        <div class="content-leftside">
          <div class="btn-group-vertical col-md-12" role="group" aria-label="...">
            <button type="button" class="btn btn-default tooltips-right" onClick="f1(1);" style="background-image: url('images/black_gerenziliao.png');background-repeat: no-repeat;background-position: 30% 50%;" onMouseOver="this.style.backgroundImage='url(images/white_gerenziliao.png)'" onMouseOut="this.style.backgroundImage='url(images/black_gerenziliao.png)'">个人资料
              <span class="triangle-right"></span>
            </button>
            <button type="button" class="btn btn-default tooltips-right" onClick="f1(2);" style="background-image: url('images/black_anquanshezhi.png');background-repeat: no-repeat;background-position: 30% 50%;" onMouseOver="this.style.backgroundImage='url(images/white_anquanshezhi.png)'" onMouseOut="this.style.backgroundImage='url(images/black_anquanshezhi.png)'">安全设置
              <span class="triangle-right"></span>
            </button>
            <button type="button" class="btn btn-default tooltips-right" onClick="f1(3);" style="background-image: url('images/black_xiugaitouxiang.png');background-repeat: no-repeat;background-position: 30% 50%;" onMouseOver="this.style.backgroundImage='url(images/white_xiugaitouxiang.png)'" onMouseOut="this.style.backgroundImage='url(images/black_xiugaitouxiang.png)'">修改头像
              <span class="triangle-right"></span>
            </button>
            <button type="button" class="btn btn-default" onClick="logout()" style="background-image: url('images/black_anquantuichu.png');background-repeat: no-repeat;background-position: 30% 50%;" onMouseOver="this.style.backgroundImage='url(images/white_anquantuichu.png)'" onMouseOut="this.style.backgroundImage='url(images/black_anquantuichu.png)'">安全退出
            </button>
          </div>
        </div>

        <div class="content-pcenter" id="d1" style="${tab1}">
          <form action="student_updateBasicInfo.action" method="post" name="form1">
          <div>
            <a>昵称：</a>
            <input type="text" name="username"  value="${Student.username}" maxlength="20">
          </div>
          <div>
            <a>姓名：</a>
            <input type="text" name="name" value="${Student.name}" maxlength="20">
          </div>
          <div>
            <a>学院：</a>
            <input type="text" name="department" value="${Student.department}" maxlength="20">
          </div>
          <div>
            <a>班级：</a>
            <input type="text" name="classandgrade" value="${Student.classandgrade}" maxlength="20">
          </div>
          <div>
            <a>出生日期：</a>
            <input type="hidden" id="syear" value="${birth[0]}">
            <input type="hidden" id="smonth" value="${birth[1]}">
            <input type="hidden" id="sday" value="${birth[2]}">
            <select id="selYear" name="selYear"></select><p style="display:inline-block;">年</p>
            <select id="selMonth" name="selMonth"></select><p style="display:inline-block;">月</p>
            <select id="selDay" name="selDay"></select><p style="display:inline-block;">日</p>
          </div>
          <div>
            <a>一句话介绍：</a>
            <textarea class="introduce" name="selfintroduce" maxlength="20" placeholder="20字以内">${Student.selfintroduce}</textarea>
          </div>
          <button onClick="saveBasicInfo()">保&nbsp;&nbsp;存</button>
          </form>
        </div>

        <div class="content-pcenter" id="d2" style="display:none">
          <h4>修改密码</h4>
          <div>
            <a>输入旧密码：</a>
            <input type="password" name="oldpassword" class="ps1" maxlength="20">
          </div>
          <div>
            <a>输入新密码：</a>
            <input type="password" name="newpassword" class="ps2" maxlength="20">
          </div>
          <div>
            <a>确认新密码：</a>
            <input type="password" class="ps3" maxlength="20">
          </div>
          <button style="margin-top: 28px;" onClick="updatePassword()">保&nbsp;&nbsp;存</button>
        </div>

        <div class="content-pcenter" id="d3" style="${tab3}">
          <div id="touxiang">
          <form action="student_previewStudentIcon.action" method="post" name="myform" enctype="multipart/form-data">  
            <img src="${tempPicPath}" width="240px" height="240px">
            <input type="file" onchange="preview()" name="picfile" accept="image/gif, image/jpeg, image/png" placeholder="请上传图片(仅支持gif,jpeg,png图片格式)" />
          </form>
          </div>
          <button onClick="save()">保&nbsp;&nbsp;存</button>
        </div>
      </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="bootstrap/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/Date.js" type="text/javascript"></script>
    <script src="js/Change.js" type="text/javascript"></script>
    <script src="js/open.js" type="text/javascript"></script>
    <script src="js/ajaxcommunicate.js"></script>
    <script type="text/javascript">
    function registe(){
  	  registeform.submit();
    }
    function logout(){
  	  window.location="login_logout.action";
    }
    function personalCenter(){
  	  window.location="login_personalCenter.action";
    }
    function saveBasicInfo(){
    	form1.submit();
    }
    function updatePassword(){
    	var old = $(".ps1").val();
    	var new1 = $(".ps2").val();
    	var new2 = $(".ps3").val();
    	var tempInfo = old + "-" + new1 + "-" + new2;
    	if(new1==new2&&new1!=""&&new2!=""){
    		var temp = ajaxSubmit("student_updatePassword.action",tempInfo);
    		if(temp == "1"){
    			alert("密码修改成功,请牢记。");
    		}else{
    			alert("旧密码输入错误!");
    		}
    	}
    }
    
    function preview(){
    	myform.submit();    	
    }
    function save(){
    	window.location = "student_saveStudentIcon.action";
    }
    
    </script>
  </body>
</html>
