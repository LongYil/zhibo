<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>图片上传</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/plugins/dropzone/basic.css" rel="stylesheet">
    <link href="css/plugins/dropzone/dropzone.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeIn">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins" style="width:60%;margin:0 auto;">
                    <div class="ibox-title">
                        <h5>图片上传</h5>
                    </div>
                    
                    <div class="ibox-content">
						  <div class="form-horizontal">
							<form action="carousel_addImg.action" method="post" name="myform" enctype="multipart/form-data">
							    <div class="form-group">
							        <label class="col-sm-3 control-label">选择图片：</label>
							        <div class="col-sm-8">
							            <input type="file" name="imgfile" class="form-control">
							        </div>
							    </div>
							    <div class="form-group">
							        <label class="col-sm-3 control-label">选择图片：</label>
							        <div class="col-sm-8">
							            <input type="file" name="imgfile" class="form-control">
							        </div>
							    </div>
							    <div class="form-group">
							        <label class="col-sm-3 control-label">选择图片：</label>
							        <div class="col-sm-8">
							            <input type="file" name="imgfile" class="form-control">
							        </div>
							    </div>
							    <div class="form-group">
							        <label class="col-sm-3 control-label">选择图片：</label>
							        <div class="col-sm-8">
							            <input type="file" name="imgfile" class="form-control">
							        </div>
							    </div>

                            
	                            <div class="form-group">
	                                <div class="col-sm-offset-3 col-sm-8">
	                                    <button class="btn btn-sm btn-info" onClick="saveImg()">保 存</button>
	                                </div>
	                            </div>
                            </form>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>

    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>
    <!-- DROPZONE -->
	<script type="text/javascript">
	function saveImg(){
		myform.submit();
	}
	
	</script>

</body>
</html>
    