<%@page import="com.skillshare.metier.Skill"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.skillshare.metier.User"%>

<%
	HttpSession currentSession = request.getSession(false);
	if (currentSession == null) {
		response.sendRedirect("connexion.jsp");
		return;
	}

	User user = (User) currentSession.getAttribute("user");

	if (user == null) {
		response.sendRedirect("connexion.jsp");
		return;
	}

	String userName = user.getPrenom() + " " + user.getNom();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SkillShare</title>

<meta name="description" content="">
<meta name="author" content="">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">

</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SkillShare</a>
			</div>
			<ul class="nav nav-tabs">

				<li class="active"><a>Recherche</a></li>
				<li><a href="modifProfil.jsp">Profil</a></li>
				<li class="disabled"><a href="#">Demandes</a></li>
				<li class="dropdown pull-right"><a data-toggle="dropdown"
					class="dropdown-toggle"><%=userName%><strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a onclick="signOut()">Se déconnecter</a></li>

					</ul></li>
			</ul>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">

			<section class="content">
				<div class="col-md-8 col-md-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<select id='skillItem'>
								<%
									for (Skill skill : Skill.values()) {
								%>
								<option value='<%=skill.toString()%>'>
									<%=skill.toString()%>
								</option>
								<%
									}
								%>

							</select>
							<div class="pull-right">
								<div class="btn-group">
									<button type="button" class="btn btn-success btn-filter"
										data-target="base">Base</button>
									<button type="button" class="btn btn-warning btn-filter"
										data-target="avance">Avancé</button>
									<button type="button" class="btn btn-danger btn-filter"
										data-target="expert">Expert</button>
									<button type="button" class="btn btn-default btn-filter"
										data-target="all">All</button>
								</div>
							</div>
							<div class="table-container">
								<table class="table table-filter">
									<tbody>
										<tr data-status="base">
											<td>
												<div class="media">
													<div class="media-body">
														<h4 class="title">Lorem Impsum</h4>
														<p class="summary">Ut enim ad minim veniam, quis
															nostrud exercitation...</p>
													</div>
												</div>
											</td>
										</tr>
										<tr data-status="base">
											<td>
												<div class="media">
													<div class="media-body">
														<h4 class="title">Lorem Impsum</h4>
														<p class="summary">Ut enim ad minim veniam, quis
															nostrud exercitation...</p>
													</div>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>

		</div>

	</div>

	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>