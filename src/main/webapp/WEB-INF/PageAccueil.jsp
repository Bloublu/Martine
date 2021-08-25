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
<div class="bloctitre">

	<div class="">
		<img src="<c:url value="/images/Martine.jpg"/>"/>
		<h2 class="bienvenue">Bienvenue ${user.nom} ${user.prenom}</h2> 
	</div>
	
	<div class="titre">
		<h1 class="chezmartine">Chez Martine !!</h1>
	</div>
	
</div>
	
	
<div class="header">

		<h3>Chez Martine,<br> On Chine !!</h3>
		<h1 class="liste">Liste des enchères</h1>
	
	<div class="fonctionnalites">
	
		<a class="vente" href = "./NouvelleVente">Nouvelle vente</a>
		<c:if test="${empty user}">
			<a class="co" href = "./connection">Connexion</a>
		</c:if>

		  <a class="inscription" href ="./Inscription">Inscription</a>
		  <a class="monprofil" href ="./MonProfil">MonProfil</a>
		
		<c:if test="${!empty user}">
			
			<a class ="deco" href = "./Deconnection">Deconnexion</a>
		</c:if>
	</div>
</div>




<c:if test="${!empty enchereList }"> 
	<ul class="ulEnchere">
			<c:forEach items="${enchereList}" var="enchere">
			<li class="liEnchere"><a href="./Encheres?no_article=${enchere.article.noArticle}">
   			 <p> date enchere : ${enchere.dateEnchere} </p>
   			 <p> montant enchere : ${enchere.montantEnchere} &euro; </p>
   			
   			 <p> prenom nom du vendeur : <a href="./Profil?idutilisateur=${enchere.user.id}">"${enchere.user.nom}" "${enchere.user.prenom}"</a></p>
            
   			 <p> nom article : "${enchere.article.nomArticle}"</p>
   			</a></li>
			</c:forEach>
	</ul>
</c:if>			
              


</body>
</html>