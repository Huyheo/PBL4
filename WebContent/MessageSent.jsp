<%@page import="Model.BEAN.Message_Sent"%>
<%@page import="Model.BEAN.User"%>
<%@page import="Model.BEAN.Message"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Inbox</title>

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
<%
	String userName = String.valueOf(session.getAttribute("name"));
	session.setAttribute("userName", userName);
	String passWord = String.valueOf(session.getAttribute("pass"));
	session.setAttribute("passWord", passWord);
	String id_user = String.valueOf(session.getAttribute("id"));
	session.setAttribute("id_user", id_user);
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
									<li><a href="Authenticate"> <i class="fa fa-inbox"></i>
											Inbox <!-- <span class="label label-theme pull-right inbox-notification">3</span> --></a></li>
									<li class="active"><a href="MessageSent"> <i
											class="fa fa-envelope-o"></i> Sent Mail
									</a></li>
								</ul>
							</div>
						</section>
					</div>
					<div class="col-sm-9">
						<section class="panel">
							<header class="panel-heading wht-bg">
								<h4 class="gen-case">
									<%=userName%>'s Sentbox
									<form action="SearchMessageSent"
										class="pull-right mail-src-position">
										<div class="input-append">
											<input type="text" class="form-control "
												placeholder="Search Mail" name="search">
										</div>
									</form>
								</h4>
							</header>
							<div class="panel-body minimal">
								<div class="mail-option">
									<div class="chk-all">
										<div class="pull-left mail-checkbox">
											<input type="checkbox" class="" id="selectAll">
										</div>
										<div class="btn-group">
											<a data-toggle="dropdown" href="javascript:{}"
												class="btn mini all"> All </a>
											<!-- <ul class="dropdown-menu">
                        <li><a href="#"> Read</a></li>
                        <li><a href="#"> Unread</a></li>
                      </ul> -->
										</div>
									</div>
									<div class="btn-group">
										<a data-original-title="Refresh" data-placement="top"
											data-toggle="dropdown" href="javascript:{}"
											onclick="document.getElementById('refesh').submit();"
											class="btn mini tooltips"> <i class=" fa fa-refresh"></i>
										</a>
									</div>
									<div class="btn-group">
										<a data-original-title="Delete" data-placement="top"
											data-toggle="dropdown" class="btn mini tooltips"
											href="javascript:{}"
											onclick="document.getElementById('formdelete').submit();">
											<i class="fa fa-trash"></i>
										</a>
									</div>
									<!-- <ul class="unstyled inbox-pagination">
                    <li><span>1-50 of 99</span></li>
                    <li>
                      <a class="np-btn" href="#"><i class="fa fa-angle-left  pagination-left"></i></a>
                    </li>
                    <li>
                      <a class="np-btn" href="#"><i class="fa fa-angle-right pagination-right"></i></a>
                    </li>
                  </ul> -->
								</div>
								<div class="table-inbox-wrap ">
									<form action="DeleteMessageSent" method="POST" id="formdelete">
										<table class="table table-inbox table-hover">
											<%
												ArrayList<Message_Sent> listMessage = (ArrayList<Message_Sent>) request.getAttribute("listMessage");
												if (listMessage.size() != 0) {
											%>
											<tbody>
												<%
													for (int i = 0; i < listMessage.size(); i++) {
												%>

												<tr class="inbox-small-cells">
													<td align='center' class="inbox-small-cells"><input
														type="checkbox" name="listDelete" id="listDelete"
														value="<%=listMessage.get(i).getid()%>"></td>
													<td class="view-message dont-show"><a
														href="ShowMessageSent?id_mess=<%=listMessage.get(i).getid()%>">
															<b>To:</b> <%=listMessage.get(i).getreceivers()%>
													</a></td>
													<td class="view-message"><a
														href="ShowMessageSent?id_mess=<%=listMessage.get(i).getid()%>"><%=listMessage.get(i).gettitle()%></a></td>
													<td class="view-message inbox-small-cells"><a
														href="ShowMessageSent?id_mess=<%=listMessage.get(i).getid()%>"></a></td>
													<td class="view-message text-right"><%=listMessage.get(i).getcreate_at()%></td>
												</tr>
												<%
													}
												%>
												<%
													} else {
												%>
												<div class="centerDiv">
													<h3>Empty</h3>
												</div>
												<%
													}
												%>
											</tbody>
										</table>
									</form>
									<form action="MessageSent" name="refesh" id="refesh"
										method="POST"></form>
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
				<a href="inbox.html#" class="go-top"> <i class="fa fa-angle-up"></i>
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
	<script type="text/javascript">
	var auto_refresh = setInterval(function() {
		submitform();
	}, 15000);

	function submitform() {
		var checkboxes = document.getElementsByName("listDelete");
		var checkboxesChecked = [];
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked == true) {
				var check = true;
			}
		}

		if (check != true) {
			document.getElementById("refesh").submit();
		}
	}
	</script>
	<script type="text/javascript">
	document.getElementById('selectAll').onclick = function() {
		  var checkboxes = document.querySelectorAll('input[type="checkbox"]');
		  for (var checkbox of checkboxes) {
			  checkbox.checked = this.checked;
		  }
		}
	</script>
	<%
		String message = (String) request.getAttribute("alertMsg");
	%>
	<script type="text/javascript">
	   	var msg = "<%=message%>";
	   	if (msg!="null"&&msg!="")
	   		alert(msg);
	</script>
</body>
</html>


