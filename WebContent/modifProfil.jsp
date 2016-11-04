<%@page import="com.skillshare.metier.Skill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.skillshare.metier.User"%>

<%
	/* HttpSession currentSession = request.getSession(false);
	if(currentSession ==null){
		response.sendRedirect("connexion.jsp");
		return;
	}
	
	User user = (User)currentSession.getAttribute("user");
	
	if(user == null){
		response.sendRedirect("connexion.jsp");
		return;
	}
	
	String userName = user.getPrenom() + " " + user.getNom(); */
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SkillShare - Modifier son profil</title>

<meta name="description" content="">
<meta name="author" content="">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">

				<ul class="nav nav-tabs">
					<li class="navbar-header">
						<div class="navbar-brand">
							<h2>SkillShare</h2>
						</div>
					</li>
					<li><a href="main.html">Recherche</a></li>
					<li class="active"><a>Profil</a></li>
					<li class="disabled"><a href="#">Demandes</a></li>
					<li class="dropdown pull-right"><a data-toggle="dropdown"
						class="dropdown-toggle">johnB<strong class="caret"></strong></a>
						<ul class="dropdown-menu">
							<li><a onclick="signOut()">Se déconnecter</a></li>

						</ul></li>
				</ul>
			</div>
		</div>
		<form id="modifProfilForm" class="row">

			<div id="infos" class="col-md-6">

				<div class="row">
					<label for="inputEmail3" class="col-sm-2 control-label">
						Prenom </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							value="John" />
					</div>
				</div>
				<div class="row">
					<label for="inputEmail3" class="col-sm-2 control-label">
						Nom </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							value="Bauer" />
					</div>
				</div>

				<div class="row">
					<label for="inputEmail3" class="col-sm-2 control-label">
						Email </label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3"
							value="john.bauer@gmail.com" />
					</div>
				</div>

				<div class="row">
					<label for="inputPassword3" class="col-sm-2 control-label">
						Mot de passe </label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3"
							value="salut" />
					</div>
				</div>

				<div class="row">
					<label for="inputPassword3" class="col-sm-2 control-label">
						Confirmation</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3"
							value="salut" />
					</div>
				</div>
			</div>
			<div id="infos" class="col-md-6">

				<ul id="skillList">
				</ul>
				<select>
					<%
						for (Skill skill : Skill.values()) {
					%>
					<option>
						<%=skill.toString()%>
					</option>
					<%
						}
					%>

				</select> <select>
					<option>Base</option>
					<option>Avancé</option>
					<option>Expert</option>
				</select> <a onClick="addSkill()" class="btn btn-success">Ajouter le skill</a>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">

						<button type="submit" class="btn btn-success">Enregistrer
							les modifications</button>
					</div>
				</div>
			</div>
		</form>
	</div>

	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
	<script src="js/modifProfil.js"></script>
</body>
</html>