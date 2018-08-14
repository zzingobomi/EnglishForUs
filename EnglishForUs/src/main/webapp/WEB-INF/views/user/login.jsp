<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>EnglishForUs | Log in</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="/resources/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />
</head>
<body class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="/resources/index2.html"><b>EnglishForUs</b></a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">로그인 해주세요</p>
        
        <form action="/user/loginPost" method="post">
        	<div class="form-group has-feedback">
        		<input type="text" name="uid" class="form-control" placeholder="USER ID"/>
    			<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        	</div>        
        	<div class="form-group has-feedback">
        		<input type="password" name="upw" class="form-control" placeholder="Password"/>
    			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
        	</div>
        	<div class="row">
			    <div class="col-xs-8">    
			      	<div class="checkbox icheck">
			        	<label>
			          		<input type="checkbox" name="useCookie"> 로그인 상태 유지
			        	</label>
			      	</div>                        
			    </div><!-- /.col -->
			    <div class="col-xs-4">
			      	<button type="submit" class="btn btn-primary btn-block btn-flat">로그인</button>
			    </div><!-- /.col -->
		  	</div>        	
        </form>
          
        <br>
        <p>비밀번호가 기억이 안나신다면<p>
        <p>관리자에게 문의하세요.<p>   
        
      </div><!-- login-box-body -->
    </div><!-- login-box -->
    
    <!-- jQuery 2.1.4 -->
    <script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="/resources/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    
    <script>    	
      	$(function () {
      		$('input').iCheck({
                checkboxClass: 'icheckbox_square-blue',
                radioClass: 'iradio_square-blue',
                increaseArea: '20%' // optional
            });    	  
      	});
    </script>

</body>
</html>