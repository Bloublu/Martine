<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="fr.eni.martine.bo.Enchere" %>
<%@page import="java.util.List" %>

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


<c:if test="${!empty enchereList }"> 
	<ul>
			<c:forEach items="${enchereList}" var="enchere">
			<li>
   			 <p> date enchere : ${enchere.dateEnchere} </p>
   			 <p> heure enchere : ${enchere.timeEnchere} </p>
   			 <p> montant enchere : ${enchere.montantEnchere} </p>
   			
   			 <p> prenom nom du vendeur : "${enchere.user.nom}" "${enchere.user.prenom}" </p>
   			 <p> nom article : "${enchere.article.nomArticle}"</p>
   			 </li>
			</c:forEach>
	</ul>
</c:if>			




</body>
</html>