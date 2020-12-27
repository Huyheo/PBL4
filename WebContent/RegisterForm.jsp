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
<title>Register page</title>

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
			<form name="formRegister" class="form-login" action="Register"
				onsubmit="return check()">
				<h2 class="form-login-heading">sign up now</h2>
				<div class="login-wrap">
					<input type="text" class="form-control" placeholder="User Name"
						name="username" autofocus required> <br> <input
						type="text" class="form-control" placeholder="Email" name="email"
						required> <br> <input type="password"
						class="form-control" placeholder="Password" name="password"
						required> <br> <input type="password"
						class="form-control" placeholder="Retype Password"
						name="confirmpass" required> <br>
					<button class="btn btn-theme btn-block" type="submit">
						<i class="fa fa-lock"></i> SIGN UP
					</button>
					<hr>
					<div class="registration">
						You already have an account?<br /> <a class="" href="Login.jsp">
							Sign in by account </a>
					</div>
				</div>
			</form>
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
    var email = document.formRegister.email.value
    var username = document.formRegister.username.value
    var pass = document.formRegister.password.value
    var conpass = document.formRegister.confirmpass.value
    if(!(pass===conpass)){
      alert('mat khau khong trung nhau')
      return false
    }
    else if (!(email.includes('@gmail.com'))) {
        alert('khong dung la dinh dang Gmail')
        return false
    }
    else return true
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