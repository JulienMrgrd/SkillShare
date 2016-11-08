<%@page import="com.skillshare.metier.Skill"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.skillshare.metier.User"%>
<%@ page import="java.util.Map"%>


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
	 Map<Skill,Integer> competences = user.getCompetences();

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

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SkillShare</a>
			</div>
			<ul class="nav nav-tabs">

				<li><a href="main.jsp">Recherche</a></li>
				<li class="active"><a>Profil</a></li>
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
		<section class="content">
			<form id="modifProfilForm" class="row">

				<div id="infos" class="col-sm-6 panel panel-default">

					<div class="row">
						<label for="inputEmail3" class="col-sm-2 control-label">
							Prenom </label>
						<div class="col-sm-10">
							<!-- 						<input type="text" class="form-control" id="inputEmail3" -->
							<input type="text" class="form-control" id="firstname"
								value=<%= user.getPrenom() %> />
						</div>
					</div>
					<div class="row">
						<label for="inputEmail3" class="col-sm-2 control-label">
							Nom </label>
						<div class="col-sm-10">
							<!-- 						<input type="text" class="form-control" id="inputEmail3" -->
							<input type="text" class="form-control" id="lastname"
								value=<%= user.getNom() %> />
						</div>
					</div>

					<div class="row">
						<label for="inputEmail3" class="col-sm-2 control-label">
							Email </label>
						<div class="col-sm-10">
							<!-- 						<input type="email" class="form-control" id="inputEmail3" -->
							<input type="email" class="form-control" id="email"
								value="<%= user.getMail() %>" />
						</div>
					</div>

					<div class="row">
						<label for="inputPassword3" class="col-sm-2 control-label">
							Mot de passe </label>
						<div class="col-sm-10">
							<!-- 						<input type="password" class="form-control" id="inputPassword3" -->
							<input type="password" class="form-control" id="password"
								value="password" />
						</div>
					</div>

					<div class="row">
						<label for="inputPassword3" class="col-sm-2 control-label">
							Confirmation</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPassword3"
								value="password" />
						</div>
					</div>
				</div>
				<div id="skills" class="col-sm-6 panel panel-default">

					<ul id="skillList">
						<%
								for (Map.Entry<Skill, Integer> entry : competences.entrySet()) {
									Integer levelval = entry.getValue();
									String val =null;
									if (levelval==1) val ="Base";
									if (levelval==2) val ="Avancé";
									if (levelval==3) val ="Expert";


						%>
							
						<li id='<%="id"+entry.getKey()%>' 
						    class='skill-item' 
						    value='<%=entry.getKey()+"--"+entry.getValue()%>'						 > 
						<%=entry.getKey()+" "+val%>
						<a onclick="deleteSkill('<%="id"+entry.getKey()%>');"> Supprimer</a>
						</li>

						
						<%
						 
							}
						%>

						</ul>
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

					</select> <select id='skillLevel'>
						<option value='1'>Base</option>
						<option value='2'>Avancé</option>
						<option value='3'>Expert</option>
					</select> <a onClick="addSkill()" class="btn btn-success">Ajouter le
						skill</a>
				</div>
				<div class="row">
					<div class="col-sm-12">
<!-- 						<div class="form-group"> -->

<!-- 							<button type="submit" class="btn btn-danger" onClick="Modif()">Enregistrer -->
<!-- 								les modifications</button> -->
<!-- 						</div> -->
						
						<div class="form-group">
						<div class="col-xs-12">
							<a onclick="Modif()" class="btn btn-danger">Enregistrer 
 								les modifications</a>
						</div>
					</div>
					</div>
				</div>
			</form>
		</section>
	</div>

	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
	<script src="js/modifProfil.js"></script>
</body>
</html>