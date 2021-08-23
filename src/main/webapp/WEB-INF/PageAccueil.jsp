<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="fr.eni.martine.bo.Enchere" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<link href="./CSS/accueil.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Chez MARTINE !!</title>
</head>
<body>
<h1>Chez Martine !!</h1>
	<h2>Bienvenue ${user.nom} ${user.prenom}</h2> 
	
<div class="header">
	<h3>Chez Martine, On Chine !!</h3>
	<h1 class="liste">Liste des ench�res</h1>
	
	<div class="fonctionnalites">
	
		<a class="vente" href = "./private/NouvelleVente">Nouvelle vente</a>
		<c:if test="${empty user}">
			<a class="co" href = "./connection">Connexion</a>
		</c:if>

		  <a class="inscription" href ="./Inscription">Inscription</a>

		<c:if test="${!empty user}">
			<a class="profil" href  ="./Profil">Profil</a>
			<a class ="deco" href = "./Deconnection">Deconnexion</a>
		</c:if>
	</div>
</div>




<c:if test="${!empty enchereList }"> 
	<ul class="ulEnchere">
			<c:forEach items="${enchereList}" var="enchere">
			<li class="liEnchere"><a href="#">
   			 <p> date enchere : ${enchere.dateEnchere} </p>
   			 <p> montant enchere : ${enchere.montantEnchere} &euro; </p>
   			
   			 <p> prenom nom du vendeur : "${enchere.user.nom}" "${enchere.user.prenom}" </p>
   			 <p> nom article : "${enchere.article.nomArticle}"</p>
   			</a></li>
			</c:forEach>
	</ul>
</c:if>			




</body>
</html>