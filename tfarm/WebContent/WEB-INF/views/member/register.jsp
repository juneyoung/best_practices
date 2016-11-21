<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Registration Page</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="/resource/AdminLTE/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <link rel="stylesheet" href="/resource/AdminLTE/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/resource/AdminLTE/plugins/iCheck/square/blue.css">
  <script src="/resource/js/custom/tfarm_common.js"></script>
  
  <script>
  	function register(registerValues){
  		ajax("/member/register", registerValues, function(result){
  			//result JSON Object
  			if(result.result != 'S'){
  				alert('ERROR >>> ' + result.result_msg);
  				return;
  			} else {
  				alert(result.result_msg);
  				location.href = '/';
  			}
  		});
  	}
  	
  	function before(){
  		var form = document.registerForm;
  		var agreeBox = document.querySelector('[agreebox]');
  		if(!agreeBox.checked){
  			alert('Please, check Agree with terms');
  			return;
  		}
  		
  		//checking required fields
  		var valueMap = formValueAsObject (form, true, true);
  		if(valueMap) {
  			//password compare
  	  		var pw = document.querySelector('[name="password"]').value;
  	  		var r_pw = document.querySelector('[name="retype-password"]').value;
  	  		if(pw != r_pw){
  	  			alert('Password and confirm mismatch!');
  	  			return;
  	  		}
  			register(valueMap)	;
  		}
  	}
  </script>
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="/resource/AdminLTE/index2.html"><b>Admin</b>LTE</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">Register a new membership</p>

    <form name="registerForm" method="post">
		<fieldset>
			<div class="form-group has-feedback">
				<input type="text" name="name" display-name="이름" class="form-control" placeholder="Full name">
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="email" name="email" display-name="이메일" required class="form-control" placeholder="Email">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="text" name="id" display-name="아이디" required class="form-control" placeholder="ID">
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" name="password" display-name="비밀번호" required class="form-control" placeholder="Password">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" name="retype-password" display-name="비밀번호 재입력" required class="form-control" placeholder="Retype password">
				<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
			</div>
		</fieldset>
    	<div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input agreebox type="checkbox"> I agree to the <a href="#">terms</a>
            </label>
          </div>
       	</div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" onclick="javascript:before()" class="btn btn-primary btn-block btn-flat">Register</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

    <a href="/" class="text-center">I already have a membership</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

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
