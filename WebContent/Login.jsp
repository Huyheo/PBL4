<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Login page</title>

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--external css-->
<link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet">
</head>

<body>
	<div id="login-page">
		<div class="container">
			<form name="formLogin" class="form-login" action="Authenticate">
				<h2 class="form-login-heading">sign in now</h2>
				<div class="login-wrap">
					<input type="text" class="form-control" placeholder="User Name"
						name="UserName" autofocus required> <br> <input
						type="password" class="form-control" placeholder="Password"
						name="PassWord" required> <label class="checkbox">
						<a data-toggle="modal" href="Login.jsp#myModal"> Forgot
							Password?</a>
					</label>
					<button class="btn btn-theme btn-block" type="submit">
						<i class="fa fa-lock"></i> SIGN IN
					</button>
					<hr>
					<div class="registration">
						Don't have an account yet?<br /> <a class=""
							href="RegisterForm.jsp"> Create an account </a>
					</div>
				</div>
			</form>
			<!-- Modal -->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
				tabindex="-1" id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Forgot Password ?</h4>
						</div>
						<form name="formforget" action="ForgetPassword" method="post"
							onsubmit="return check()">
							<div class="modal-body">
								<p>Enter your e-mail address below to reset your password.</p>
								<input type="text" name="email" placeholder="Email"
									autocomplete="off" class="form-control placeholder-no-fix"
									required> <br> <input type="password"
									name="password" placeholder="Type new nassword"
									autocomplete="off" class="form-control placeholder-no-fix"
									required> <br> <input type="password"
									name="confimpass" placeholder="Retype password"
									autocomplete="off" class="form-control placeholder-no-fix"
									required>
							</div>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default"
									type="button">Cancel</button>
								<button class="btn btn-theme" type="submit">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- modal -->
		</div>
	</div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<!--BACKSTRETCH-->
	<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	<script type="text/javascript" src="lib/jquery.backstretch.min.js"></script>
	<script>
    $.backstretch("img/login-bg.jpg", {
      speed: 500
    });
  </script>
	<script type="text/javascript">
	function check() {
		var email = document.formforget.email.value
		var pass = document.formforget.password.value
		var conpass = document.formforget.confirmpass.value
		if (email == '' || pass == '' || conpass == '') {
			alert('Khong duoc de trong')
			return false
		} else if(!(pass===conpass)){
		      alert('mat khau khong trung nhau')
		      return false
	    } else if (!(email.includes('@gmail.com'))) {
	        alert('khong dung la dinh dang Gmail')
	        return false
	    } else
			return true
	}
</script>
	<%
		String message = (String) request.getAttribute("alertMsg");
	%>
	<script type="text/javascript">
   	var msg = "<%=message%>";
		if (msg != "null" && msg != "")
			alert(msg);
	</script>
</body>

</html>