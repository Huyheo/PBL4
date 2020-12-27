<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Compose mail</title>

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Bootstrap core CSS -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--external css-->
<link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="lib/bootstrap-wysihtml5/bootstrap-wysihtml5.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet">
</head>
<%
	String name_sender = (String) request.getAttribute("name_sender");
	if (name_sender == null) {
		name_sender = "";
	}
%>
<body>
	<section id="container" class="sidebar-closed">
		<!--header start-->
		<header class="header black-bg">
			<!--logo start-->
			<a href="Authenticate" class="logo"><b>MY<span>Mail</span></b></a>
			<!--logo end-->
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="logout">Logout</a></li>
				</ul>
			</div>
		</header>
		<!--header end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<!-- page start-->
				<div class="row mt">
					<div class="col-sm-3">
						<section class="panel">
							<div class="panel-body">
								<a href="Compose.jsp" class="btn btn-compose"> <i
									class="fa fa-pencil"></i> Compose Mail
								</a>
								<ul class="nav nav-pills nav-stacked mail-nav">
									<li><a href="Authenticate"> <i
											class="fa fa-inbox"></i> Inbox <!-- <span class="label label-theme pull-right inbox-notification">3</span> --></a></li>
									<li><a href="MessageSent"> <i class="fa fa-envelope-o"></i>
											Sent Mail
									</a></li>
								</ul>
							</div>
						</section>
					</div>
					<div class="col-sm-9">
						<section class="panel">
							<header class="panel-heading wht-bg">
								<h4 class="gen-case">
									Compse email
									<form action="SearchMessage"
										class="pull-right mail-src-position">
										<div class="input-append">
											<input type="text" class="form-control "
												placeholder="Search Mail" name="search">
										</div>
									</form>
								</h4>
							</header>
							<div class="panel-body">
								<div class="compose-btn pull-right">
									<button class="btn btn-theme btn-sm"
										onclick="document.getElementById('formcompose').submit();">
										<i class="fa fa-check"></i> Send
									</button>
									<button class="btn btn-sm" onclick="javascript:history.back()">
										<i class="fa fa-times"></i> Discard
									</button>
								</div>
								<div class="compose-mail">
									<form role="form-horizontal" method="post" action="Compose"
										id="formcompose" enctype="multipart/form-data">
										<div class="form-group">
											<label for="to" class="">To:</label> <input type="text"
												tabindex="1" class="form-control" name="receiver"
												value="<%=name_sender%>" required>
										</div>
										<div class="form-group">
											<label for="subject" class="">Subject:</label> <input
												type="text" tabindex="1" name="title" class="form-control">
										</div>
										<div class="compose-editor">
											<textarea class="wysihtml5 form-control" rows="9"
												name="content"></textarea>
											<input type="file" class="default" name="file" size="35"
												multiple>
										</div>
									</form>
									<div class="compose-btn">
										<button class="btn btn-theme btn-sm"
											onclick="document.getElementById('formcompose').submit();">
											<i class="fa fa-check"></i> Send
										</button>
										<button class="btn btn-sm" onclick="javascript:history.back()">
											<i class="fa fa-times"></i> Discard
										</button>
									</div>
								</div>
							</div>
						</section>
					</div>
				</div>
			</section>
			<!-- /wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<!--main content end-->
		<!--footer start-->
		<footer class="site-footer">
			<div class="text-center">
				<p>
					&copy; Copyrights <strong>Dashio</strong>. All Rights Reserved
				</p>
				<div class="credits">
					<!--
            You are NOT allowed to delete the credit link to TemplateMag with free version.
            You can delete the credit link only if you bought the pro version.
            Buy the pro version with working PHP/AJAX contact form: https://templatemag.com/dashio-bootstrap-admin-template/
            Licensing information: https://templatemag.com/license/
          -->
					Created with Dashio template by <a href="https://templatemag.com/">TemplateMag</a>
				</div>
				<a href="mail_compose.html#" class="go-top"> <i
					class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="lib/jquery.scrollTo.min.js"></script>
	<script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="lib/common-scripts.js"></script>
	<!--script for this page-->
	<script type="text/javascript"
		src="lib/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
	<script type="text/javascript"
		src="lib/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>

	<script type="text/javascript">
		//wysihtml5 start

		$('.wysihtml5').wysihtml5();

		//wysihtml5 end
	</script>
</body>

</html>
