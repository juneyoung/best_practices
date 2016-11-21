<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	  <meta charset="utf-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <title>AdminLTE 2 | Log in</title>
	  <!-- Tell the browser to be responsive to screen width -->
	  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	  <!-- Bootstrap 3.3.6 -->
	  <link rel="stylesheet" href="/resource/AdminLTE/bootstrap/css/bootstrap.min.css">
	  <!-- Font Awesome -->
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	  <!-- Ionicons -->
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	  <!-- Theme style -->
	  <link rel="stylesheet" href="/resource/AdminLTE/dist/css/AdminLTE.min.css">
	  <!-- iCheck -->
	  <link rel="stylesheet" href="/resource/AdminLTE/plugins/iCheck/square/blue.css">
	  <script src="/resource/js/custom/tfarm_common.js"></script>
	  <script>
	  	function login(){
	  		var loginForm = document.loginForm;
	  		// loginForm.submit() 시에 API 의 결과를 받아처리할 수 없다.
	  		// form data 로 API 를 호출하고 리턴 결과에 따라 리디렉션을 변경하는 방식으로 처리 
	  		
	  		var params = {};
	  		var inputs = loginForm.querySelector('fieldset').querySelectorAll('input');
	  		for(var i = 0; i < inputs.length; i++) {
	  			var singleInput = inputs[i];
	  			if(!!inputs[i].name) params[inputs[i].name] = inputs[i].value;
	  		}
	  		
	  		console.log('parameters >>> ', params);
	  		
	  		ajax("/member/login", params, function(result){
	  			//result JSON Object
	  			console.log('로그인 결과 >>> ', result);
	  			if(result.result == 'S') {
	  				location.href = '/admin/dashboard';
	  				return;
	  			} else {
	  				alert('로그인에 실패하였습니다');
	  				console.error(result.message);
	  				return;
	  			}
	  		});
	  		
	  	}
	  </script>
	</head>
	<body class="hold-transition login-page">
	<div class="login-box">
	  <div class="login-logo">
	    <a href="/resource/AdminLTE/index2.html"><b>Admin</b>LTE</a>
	  </div>
	  <!-- /.login-logo -->
	  <div class="login-box-body">
	    <p class="login-box-msg">Sign in to start your session</p>
	
<!-- 		action="member/login" -->
	    <form  name='loginForm' method="post">
	      
	      <fieldset>
		      <div class="form-group has-feedback">
		        <input type="text" class="form-control" name="id" placeholder="ID">
		        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		      </div>
		      <div class="form-group has-feedback">
		        <input type="password" class="form-control" name="password" placeholder="Password">
		        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
		      </div>
	      </fieldset>
	      
	      <div class="row">
	        <div class="col-xs-8">
	          <div class="checkbox icheck">
	            <label>
	              <input type="checkbox"> Remember Me
	            </label>
	          </div>
	        </div>
	        <!-- /.col -->
	        <div class="col-xs-4">
<!-- 	          <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button> -->
	          <button type="button" onclick="javascript:login();" class="btn btn-primary btn-block btn-flat">Sign In</button>
	        </div>
	        <!-- /.col -->
	      </div>
	    </form>
	
<!-- 	    <div class="social-auth-links text-center"> -->
<!-- 	      <p>- OR -</p> -->
<!-- 	      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using -->
<!-- 	        Facebook</a> -->
<!-- 	      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using -->
<!-- 	        Google+</a> -->
<!-- 	    </div> -->
	
	    <a href="member/password">I forgot my password</a><br>
	    <a href="member/register" class="text-center">Register a new membership</a>
	
	  </div>
	  <!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->
	
	<!-- jQuery 2.2.3 -->
	<script src="/resource/AdminLTE/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="/resource/AdminLTE/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="/resource/AdminLTE/plugins/iCheck/icheck.min.js"></script>
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