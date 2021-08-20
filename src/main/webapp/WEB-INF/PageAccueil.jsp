<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

<h1>ACCUEIL</h1>
<h2>Bienvenue ${user.nom} ${user.prenom}</h2> 

	
<a href = "./private/NouvelleVente">Nouvelle vente</a><br><br>

<c:if test="${empty user}">
<a href = "./connection">Connexion</a><br><br>
</c:if>




<c:if test="${!empty user}">
	<a href ="./Profil">Profil</a><br>
	<a href = "./Deconnection">Deconnexion</a><br>
</c:if>





</body>
</html>