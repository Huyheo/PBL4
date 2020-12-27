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
			<form name="formconfirm" class="form-login" action="Confirm">
				<h2 class="form-login-heading">Enter verification codes</h2>
				<div class="login-wrap">
					<input type="text" class="form-control" placeholder="Code"
						name="confirmcode" autofocus required> <br>
					<button class="btn btn-theme btn-block" type="submit">
						<i class="fa fa-lock"></i> Submit
					</button>
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
	<%
		String message = (String) request.getAttribute("alertMsg");
	%>
	<script type="text/javascript">
   	var msg = "<%=message%>
		";
		if (msg != "null" && msg != "")
			alert(msg);
	</script>
</body>

</html>