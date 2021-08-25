<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MonProfil</title>
</head>
<body>
<h1>MON PROFIL</h1>

<p> ${user.pseudo}</p> 
<p> ${user.nom}</p> 
<p> ${user.prenom}</p> 
<p> ${user.email}</p> 
<p> ${user.telephone}</p> 
<p> ${user.rue}</p>
<p> ${user.codepostal}</p>
<p> ${user.ville}</p>
<p> ${user.motDePasse}</p><br>

<p> ${user.credit}</p>
</body>
</html>