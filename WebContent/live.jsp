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
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet" type="text/css">
  </head>
  
  <body class="live">
    <header class="live">
      <span><a href="index.jsp"><&nbsp;&nbsp;<s:property value='courseVo.course.name'/>&nbsp;&nbsp;<s:property value='courseVo.teacher.name'/></a></span>
      <span class="person">
        <img src="${tempPicPath}" alt="" width="28px" height="28px" class="img-circle">
        <div class="btn-group">
            <button type="button" class="btn  dropdown-toggle btn-sm" data-toggle="dropdown" id="person-btn">${Student.name}
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
    <div class="row">
      <div class="live-video">
        <input type="hidden" id="liveaddress" value="<s:property value='course.address'/>" >
        <div class="video" id="video" style="padding-top:20px;">
        </div>
        <div class="jindutiao">
            <div class="jindu">
                  <ul id="jdskill">
                  <li><span class="expand jdhtml5"></span></li>
                  </ul>
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
	            <img src="images/yonghu_big_biji.png" alt="" class="bigimg">
	            <p class="emptyNote">还没有任何笔记哦</p >
	          </div>
          </c:if>



          <div>
            <textarea maxlength="2000" placeholder="输入笔记" id="notearea"></textarea>
          </div>
          <button onClick="saveNote()">确定</button>
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


      <div class="live-dic" id="d3" style="display:none">
        <div class="live-dic-leftside">
          <div class="discuss">
            
            <div class="discuss-left">
              <img src="images/touxiang1.png" alt="" class="img-circle">
              <a href="">李丽丽</a>
              <div>
                <a class="discuss-left-a">这堂课学到很多东西</a>
              </div>
            </div>
            
            <div class="discuss-left">
              <img src="images/touxiang1.png" alt="" class="img-circle">
              <a href="">李四</a>
              <div>
                <a class="discuss-left-a">这堂课学到</a>
              </div>
            </div>

            <div class="discuss-right">
              <a href="">张三</a>
              <img src="images/touxiang1.png" alt="" class="img-circle">
              <div>
                <a class="discuss-right-a">这堂课学到很多东西</a>
              </div>
            </div>
            
          </div>
          <img src="images/yonghu_biaoqing.png" alt="" class="biaoqing">
          <div>
            <textarea maxlength="2000" placeholder="立即参与讨论"></textarea>
          </div>
          <button>发送</button>
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
    <script src="js/open.js" type="text/javascript"></script>
    <script src="js/chouti.js" type="text/javascript"></script>
    <script src="js/ajaxcommunicate.js"></script>
    <script type="text/javascript">
    function logout(){
  	  window.location="login_logout.action";
    }
    function personalCenter(){
  	  window.location="login_personalCenter.action";
    }
    var address = $("#liveaddress").val();
    var player =  new TcPlayer('video', {
   	 "m3u8": address + ".m3u8",
   	 "flv": address + ".flv", //增加了一个flv的播放地址，用于PC平台的播放 请替换成实际可用的播放地址
   	 "autoplay" : true,      //iOS下safari浏览器，以及大部分移动端浏览器是不开放视频自动播放这个能力的
   	 "coverpic" : "img/a1.jpg",
   	 "width" :  '100%',//视频的显示宽度，请尽量使用视频分辨率宽度
   	 "height" : '100%'//视频的显示高度，请尽量使用视频分辨率高度
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
    </script>
  </body>
</html>