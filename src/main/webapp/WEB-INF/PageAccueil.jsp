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

<a href = "./connection">Connexion</a><br><br>

<a href ="./Profil">Profil</a><br><br>


<%--<c:if test="${user }">
	<a href = >Deconnexion</a>
</c:if>  --%>




</body>
</html>