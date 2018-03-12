<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %><!-- 引入标签库  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>理学院教学直播平台</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="images/logo.jpg">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0)" onClick="backindex()">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">CollegeLive</strong>
                                    </span>
                                </span>
                            </a>
                        </div>
                        <div class="logo-element">hAdmin
                        </div>
                    </li>
                    <li class="line dk"></li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">用户中心</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="manager_queryInfo.action">
                            <i class="fa fa-user"></i>
                            <span class="nav-label">个人中心</span>
                        </a>
                    </li>

                    <li class="line dk"></li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">用户管理</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="teacher_findAll.action">
                            <i class="fa fa-user"></i>
                            <span class="nav-label">教师管理</span>
                        </a>
                    </li>
                    <li>
                        <a class="J_menuItem" href="student_findAllEnable.action">
                            <i class="fa fa-user"></i>
                            <span class="nav-label">学生管理</span>
                        </a>
                    </li>

                    <li class="line dk"></li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">试题管理</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="exam_findAll.action">
                            <i class="fa fa-book"></i>
                            <span class="nav-label">所有试题</span>
                        </a>
                    </li>
                    <li>
                        <a class="J_menuItem" href="file/exammodel.xls">
                            <i class="fa fa-book"></i>
                            <span class="nav-label">试题模板</span>
                        </a>
                    </li>
                    <li class="line dk"></li>

                    <li class="line dk"></li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">课程管理</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="course_findAll.action">
                            <i class="fa fa-video-camera"></i>
                            <span class="nav-label">所有课程</span>
                        </a>
                    </li>
                    <li class="line dk"></li>

                    <li class="line dk"></li>
                    <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                        <span class="ng-scope">系统管理</span>
                    </li>
                    <li>
                        <a class="J_menuItem" href="carousel_findAll.action">
                            <i class="fa fa-picture-o"></i>
                            <span class="nav-label">轮播管理</span>
                        </a>
                    </li>
                    <li>
                        <a class="J_menuItem" href="javascript:void(0)" onClick="exit()">
                            <i class="fa fa-power-off"></i>
                            <span class="nav-label">退出系统</span>
                        </a>
                    </li>
					<li class="line dk"></li>

                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>
                    </div>
                </nav>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe id="J_iframe" width="100%" height="100%" src="teacher_findAll.action" frameborder="0" data-id="index_v1.html" seamless></iframe>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="js/hAdmin.js?v=4.1.0"></script>
    <script type="text/javascript" src="js/index.js"></script>

    <!-- 第三方插件 -->
    <script src="js/plugins/pace/pace.min.js"></script>
	<script type="text/javascript">
	function exit(){
		$(window).attr('location','login_logout.action');
	}
	function backindex(){
		$(window).attr('location','course_findRecentCource.action');
	}
	</script>
</body>

</html>
