<!DOCTYPE html>
<%@page import="Model.BEAN.User"%>
<%@page import="Model.BEAN.Attachment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.BEAN.Message"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>View email</title>

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
									<li><a href="Authenticate"> <i class="fa fa-inbox"></i>
											Inbox <!-- <span class="label label-theme pull-right inbox-notification">3</span> --></a></li>
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
									<%
										String userName = String.valueOf(session.getAttribute("name"));
										session.setAttribute("userName", userName);
									%>
									View Inbox message's
									<%=userName%>
									<form action="SearchMessage"
										class="pull-right mail-src-position">
										<div class="input-append">
											<input type="text" class="form-control "
												placeholder="Search Mail" name="search">
										</div>
									</form>
								</h4>
							</header>
							<%
								Message message = (Message) request.getAttribute("mess");
								ArrayList<Attachment> attachment = (ArrayList<Attachment>) request.getAttribute("attachment");
								ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
							%>
							<%
								String name = "";
								for (int j = 0; j < listUser.size(); j++) {
									if (listUser.get(j).getid() == message.getid_sender()) {
										name = listUser.get(j).getusername();
										break;
									}
								}
								String name_sender = name;
								session.setAttribute("name_sender", name_sender);
							%>
							<div class="panel-body ">
								<div class="mail-header row">
									<div class="col-md-8">
										<h4 class="pull-left">
											<%=message.gettitle()%>
										</h4>
									</div>
									<div class="col-md-4">
										<div class="compose-btn pull-right">
											<a href="Compose?name_sender=<%=name%>"
												class="btn btn-sm btn-theme"><i class="fa fa-reply"></i>
												Reply</a> <a data-original-title="Delete" data-placement="top"
												class="btn mini tooltips"
												href="DeleteMessage?id_mess=<%=message.getid()%>"
												onclick="return confirm('Are you sure?')"><i
												class="fa fa-trash"></i></a>
										</div>
									</div>
								</div>
								<div class="mail-sender">
									<div class="row">
										<div class="col-md-8">
											<strong><%=name%></strong> to <strong>me</strong>
										</div>
										<div class="col-md-4">
											<p class="date"><%=message.getcreate_at()%></p>
										</div>
									</div>
								</div>
								<div class="view-mail">
									<%=message.getcontent()%>
								</div>
								<%
									if (attachment.size() != 0) {
								%>
								<div class="attachment-mail">
									<p>
										<span><i class="fa fa-paperclip"></i> <%=attachment.size()%>
										</span> attachments
										<!-- <a href="#">Download all attachments</a> |
                    <a href="#">View all images</a> -->
									</p>
									<ul>
										<%
											for (int i = 0; i < attachment.size(); i++) {
													String f_n = (attachment.get(i)).getfile_name();
										%>
										<li>
											<div class="links">
												<a
													href="DownloadAttachment?id_attachment=<%=attachment.get(i).getid()%>"><%=f_n%></a>
											</div>
										</li>
										<%
											}
										%>
									</ul>
								</div>
								<%
									} else {
								%>
								<hr>
								<%
									}
								%>
								<div class="compose-btn pull-left">
									<a href="Compose?name_sender=<%=name%>"
										class="btn btn-sm btn-theme"><i class="fa fa-reply"></i>
										Reply</a> <a data-original-title="Delete" data-placement="top"
										class="btn mini tooltips"
										href="DeleteMessage?id_mess=<%=message.getid()%>"
										onclick="return confirm('Are you sure?')"><i
										class="fa fa-trash"></i></a>
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
				<a href="mail_view.html#" class="go-top"> <i
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

</body>

</html>
