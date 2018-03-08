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
    <script src="http://imgcache.qq.com/open/qcloud/video/vcplayer/TcPlayer-2.2.0.js" charset="utf-8"></script>;
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="images/logo.jpg">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/cyberplayer.js"></script>
  </head>
  
  <body class="live" style="background:#303030;margin-top:-10px;">
    <header class="live">
      <span><a href="index.jsp"><&nbsp;&nbsp;<s:property value='courseVo.course.name'/>&nbsp;&nbsp;<s:property value='courseVo.teacher.name'/></a></span>
      <span class="person">
        <img src="${tempPicPath}" alt="" width="28px" height="28px" class="img-circle">
        <div class="btn-group">
            <button type="button" class="btn  dropdown-toggle btn-sm" data-toggle="dropdown" id="person-btn">${userName}
              <img src="images/xialakuang.png" alt="">
            </button>
            <ul class="dropdown-menu" role="menu">
                <li>
                    <a href="javascript:void(0)" onClick="personalCenter()" style="color:black;">个人中心</a>
                </li>
                <li>
                    <a href="javascript:void(0)" onClick="logout()" style="color:black;">退出登录</a>
                </li>
            </ul>
        </div>
      </span>
    </header>
    <div class="row" style="padding:0px;">
      <div class="live-video" style="float:left;" id="parentdiv">
        <div id="playercontainer" style="padding:0px;">
        <input type="hidden" id="liveaddress" value="${liveAddress}" >
        <input type="hidden" id="faceaddress" value="${tempPicPath}"> 
        <input type="hidden" id="studentname" value="${userName}"> 
        <input type="hidden" id="studenthead" value="${liveAddress}"> 
        <input type="hidden" id="studentid" value="${Student.id}"> 
        <input type="hidden" id="courseid" value="${courseVo.course.id}"> 
        <input type="hidden" id="ip" value="${ip}"> 
        <div class="video" id="video" style="padding-top:20px;">
        </div>
        </div>
      </div>
      <div class="live-itr" id="d1">
        <div class="live-itr-leftside">
          <h4>【公开课】<s:property value='courseVo.course.name'/></h4>
          <p>课程简介：</p>
          <p>&nbsp;&nbsp;<s:property value='courseVo.course.summary'/></p>
        </div>

        <div id="box1">
          <div id="arrow1"><img src="images/right_zishiqi.png" style="padding-bottom: 2em;"></div>
          <div style="clear: both;"></div>
          <div id="col_box1" class="live-rigthside">
            <button onClick="f2(1);" style="background-color: #303030;margin-top: 48px;">
              <img src="images/yonghu_jianjie.png" alt=""><br/>简介
            </button>
            <button onClick="f2(2);">
              <img src="images/yonghu_small_biji.png" alt=""><br/>笔记
            </button>
            <button onClick="f2(3);">
              <img src="images/yonghu_taolun.png" alt=""><br/>讨论
            </button>
          </div>
        </div>
      </div>

      <div class="live-nts" id="d2" style="display:none">
         <div class="live-nts-leftside">
          
          <c:if test="${noteSize>0}">
	          <div class="note_new">
	            <h4>课程笔记</h4>
	            <div class="clearfloat"></div>
					<s:iterator value="listNote" status="ste">
	                   <li>
	                       <s:property value="time"/>：&nbsp;<s:property value="content"/>.
	                   </li> 
					</s:iterator>
	          </div>
          </c:if>
          
          <c:if test="${noteSize<1}">
	          <div class="note_new">
	            <h4>课程笔记</h4>
	            <img src="images/yonghu_big_biji.png" class="bigimg">
	            <p class="emptyNote">还没有任何笔记哦</p >
	          </div>
          </c:if>
          <div>
            <textarea maxlength="2000" style="width:100%;" placeholder="输入笔记" id="notearea"></textarea>
          </div>
          <button onClick="saveNote()" style="float:left;margin-left:20px;">确定</button>
        </div>

        <div id="box2">
          <div id="arrow2"><img src="images/right_zishiqi.png" style="padding-bottom: 2em;"></div>
          <div style="clear: both;"></div>
          <div id="col_box2" class="live-rigthside">
            <button onClick="f2(1);" style="margin-top: 48px;">
              <img src="images/yonghu_jianjie.png" alt=""><br/>简介
            </button>
            <button onClick="f2(2);" style="background-color: #303030;">
              <img src="images/yonghu_small_biji.png" alt=""><br/>笔记
            </button>
            <button onClick="f2(3);">
              <img src="images/yonghu_taolun.png" alt=""><br/>讨论
            </button>
          </div>
        </div>
      </div>


      <div class="live-dic" id="d3" style="display:none;padding:0px;">
        <div class="live-dic-leftside" style="padding-right:60px;margin:0;width:100%;">
          <div class="discuss" id="discussArea" >
            <s:iterator value="listDiscuss" status="ste">
	            <c:if test="${student.id==StudentId}">
		            <div class="discuss-right">
		              <a href="javascript:void(0)"><s:property value="student.name"/>&nbsp;&nbsp;</a>
		              <img src="<s:property value="student.head"/>" class="img-circle" width="28px" height="28px">
		              <div>
		                <a class="discuss-left-a"><s:property value="time"/>：<s:property value="content"/></a>
		              </div>
		            </div>
	            </c:if>
	            <c:if test="${student.id!=StudentId}">
		            <div class="discuss-left">
		              <img src="<s:property value="student.head"/>" class="img-circle" width="28px" height="28px">
		              <a href="javascript:void(0)"><s:property value="student.name"/>&nbsp;&nbsp;</a>
		              <div>
		                <a class="discuss-left-a"><s:property value="time"/>：<s:property value="content"/></a>
		              </div>
		            </div>
	            </c:if>
            </s:iterator>
          </div>
          <img src="images/yonghu_biaoqing.png" alt="" class="biaoqing">
          <div style="width:100%;">
            <textarea maxlength="2000" style="width:100%;" placeholder="立即参与讨论" id="discussContent"></textarea>
          </div>
          <button onClick="saveDiscuss()" style="float:left;margin-left:20px;">发送</button>
        </div>

        <div id="box3">
          <div id="arrow3"><img src="images/right_zishiqi.png" style="padding-bottom: 2em;"></div>
          <div style="clear: both;"></div>
          <div id="col_box3" class="live-rigthside">
            <button onClick="f2(1);" style="margin-top: 48px;">
              <img src="images/yonghu_jianjie.png" alt=""><br/>简介
            </button>
            <button onClick="f2(2);">
              <img src="images/yonghu_small_biji.png" alt=""><br/>笔记
            </button>
            <button onClick="f2(3);" style="background-color: #303030;">
              <img src="images/yonghu_taolun.png" alt=""><br/>讨论
            </button>
          </div>
          
        </div>
      </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="bootstrap/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/Change.js" type="text/javascript"></script>
    <script src="js/ajaxcommunicate.js"></script>
    
    <script type="text/javascript">
    
  	var face = $("#faceaddress").val();
  	var username = $("#studentname").val();
  	var discuss1 = $("#courseid").val() + "-" + $("#studentid").val() + "-";
  	var discuss2 = "-" + $("#studentname").val() + "-" + $("#studenthead").val();
  	var courseid = $("#courseid").val();
  	var userid = $("#studentid").val();
    function logout(){
    	  window.location="login_logout.action";
      }
      function personalCenter(){
    	  window.location="login_personalCenter.action";
      }
      var address = $("#liveaddress").val();
      
      $(function(){
      	$("#notearea").keydown(function(event){
      		if(event.keyCode == 13){
      			saveNote();
      		}
      	})
      })    
      $(function(){
      	$("#discussContent").keydown(function(event){
      		if(event.keyCode == 13){
      			saveDiscuss();
      		}
      	})
      })

      var player = cyberplayer("playercontainer").setup({
              width: $('#parentdiv').width(), // 宽度，也可以支持百分比(不过父元素宽度要有)
              height: $('#d1').height(), // 高度，也可以支持百分比
              isLive: true, // 标明是否是直播
              file: address+".flv", // flv直播地址（×一定要支持跨域访问，否则要设置primary参数）
              autostart: true,
              stretching: "uniform",
              volume: 100,
              controls: true,
              ak: "c8731d89f53149f1b4f22a29e25146f9" // 公有云平台注册即可获得accessKey
      });
      function saveNote(){
      	$(".bigimg").remove();
      	$(".emptyNote").remove();
      	var info = $("#notearea").val();
      	if(info==""){
      		;
      	}else{
          	$("#notearea").val("");
          	ajaxSubmit("note_save.action",info);
          	var myDate = new Date();
          	var h = myDate.getHours();       //获取当前小时数(0-23)
          	var m = myDate.getMinutes();     //获取当前分钟数(0-59)
          	var s = myDate.getSeconds();
          	var time = h + ":" + m + ":" + s + "：";
          	$(".note_new").append("<li id='hz'>" + time + "" + info + "</li>");    		
      	}
      }
      function saveDiscuss(){
      	var info = $("#discussContent").val();

      	if(info==""){
      		;
      	}else{
          	$("#discussContent").val("");
          	var myDate = new Date();
          	var h = myDate.getHours();       //获取当前小时数(0-23)
          	var m = myDate.getMinutes();     //获取当前分钟数(0-59)
          	var s = myDate.getSeconds();
          	var time = h + ":" + m + ":" + s + "：";
          	var div = document.getElementById("discussArea");
          	$(".discuss").append("<div class='discuss-right'><a href='javascript:void(0)''>"+username+" </a><img width='28px' height='28px' src='"+face+"' class='img-circle'><div><a class='discuss-right-a'>"+time+":"+info+"</a></div></div>");
          	info = discuss1 + info + discuss2;
          	Chat.sendMessage(info);
          	div.scrollTop = div.scrollHeight;
      	}
      }
      var Console = {};
      Console.callBack = (function(message) {
    	  alert(message);
      	var results = message.split("-");
      	var studentid = results[4];
      	var course = results[5];
      	if(userid != studentid && course == courseid){
      		var div = document.getElementById("discussArea");
          	$(".discuss").append("<div class='discuss-left'><img width='28px' height='28px' src='" + results[1] + "' class='img-circle'><a href='javascript:void(0)''>  "+ results[0] + " </a><div><a class='discuss-left-a'>" + results[2] + ":" + results[3] + "</a></div></div>");
          	div.scrollTop = div.scrollHeight;
      	}else{
    		    ;
      	}
      });
      var Chat = {};
      Chat.socket = null;
      Chat.connect = (function(host) {
          if ('WebSocket' in window) {
              Chat.socket = new WebSocket(host);
          } else if ('MozWebSocket' in window) {
              Chat.socket = new MozWebSocket(host);
          } else {
              return;
          }

          Chat.socket.onopen = function() {

          };
          
          Chat.socket.onclose = function() {

          };

          Chat.socket.onmessage = function(message) {
              Console.callBack(message.data);
          };
      });

      Chat.initialize = function(arg) {
      	var ip = $("#ip").val();
          Chat.connect('ws://'+ip+'/CollegeLive/discuss/'+arg);
//           Chat.connect('ws://localhost:8080/CollegeLive/discuss/'+arg);
      };

      Chat.sendMessage = (function(arg) {
          if (arg != '') {
              Chat.socket.send(arg);
          }
      });
      Chat.initialize($("#studentid").val());
    </script>
  </body>
</html>