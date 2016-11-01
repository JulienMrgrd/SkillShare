<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	HttpSession currentSession = request.getSession(false);
	if(currentSession !=null && currentSession.getAttribute("user") != null)
		response.sendRedirect("main.jsp");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SkillShare - Connexion</title>

<meta name="description" content="">
<meta name="author" content="">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="page-header">
					<h1>
						SkillShare <small>Vivez pleinement l'UPMC!</small>
					</h1>
				</div>
			</div>
		</div>
		<div id="connexionForm" class="row">
			<div class="col-xs-12">
				<form action="login()">
					<div class="row">
						<div class="col-xs-12">
							<input type="email" class="form-control" id="email"
								placeholder="Email" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<input type="password" class="form-control" id="password"
								placeholder="Mot de passe" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<a onclick="signIn()" class="btn btn-success">Se connecter</a>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<a href="inscription.html" class="btn btn-danger">S'inscrire</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>