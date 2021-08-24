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
<div>
<div class="mamartine"><a href="./Accueil"><img src="<c:url value="/images/Martine.jpg"/>"/></div></a>
<h1>Chez Martine !!</h1>
</div>
	<h2>Bienvenue ${user.nom} ${user.prenom}</h2> 
	
<div class="header">
	<h3>Chez Martine,<br> On Chine !!</h3>
	<h1 class="liste">Liste des ench�res</h1>
	
	<div class="fonctionnalites">
	
		<a class="vente" href = "./NouvelleVente">Nouvelle vente</a>
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



<form action="" method="post">
<div class="recherch">
<label for="filteEnchere">Filtre : </label><br>
<input type="text" name="recherche" id="rech" placeholder="Le nom de l'article contient" size="30" maxlenght="80"><br>
<label  for="favorite" class="cat" >Cat�gorie :</label>
<select name="categ" size="1">

<optgroup label="Maison">
<option value="electromenager">electrom�nager</option>
<option value="ameublement">Ameublement</option>
<option value="jardin">Jardin</option>
</optgroup>
<optgroup label="V�hicules">
<option value="Voiture">Voiture</option>
<option value="Moto">Moto</option>
<option value="Bateau">Bateau</option>
</optgroup>
<optgroup label="Mode">
<option value="Vetement">Vetement</option>
<option value="Chaussures">Chaussures</option>
<option value="Montres & Bijoux">Montres & Bijoux</option>
</optgroup>
</select><br>
<button type="submit" class="validRech">Rechercher</button><br>
</div>
<div class="radio">
<div class="Rachat"><input type="radio" name="Achat"/>Achat</div>
<div class="Rvente"><input type="radio" name="Ventes"/>Mes Ventes<br></div>
</div>
<div class="check">
	<div class="Cachat">	
		<input type="checkbox" name="ouverte" />encheres Ouvertes <br>
		<input type="checkbox" name="encheres" />mes encheres<br>
		<input type="checkbox" name="remporte" />mes ench�res remport�es <br>
	</div>
	<div class="Cvente">
		<input type="checkbox" name="encours"/>mes ventes en cours <br>
		<input type="checkbox" name="nonDebuter"/>ventes non d�but�es  <br>
		<input type="checkbox" name="termine"/>ventes termin�es  <br>
	</div>
</div>

</form>






<c:if test="${!empty enchereList }"> 
	<ul class="ulEnchere">
			<c:forEach items="${enchereList}" var="enchere">
			<li class="liEnchere"><a href="#">
   			 <p> date enchere : ${enchere.dateEnchere} </p>
   			 <p> montant enchere : ${enchere.montantEnchere} &euro; </p>
   			
   			 <p> prenom nom du vendeur : <a href="./Profil">"${enchere.user.nom}" "${enchere.user.prenom}"</a></p>
   			 <p> nom article : "${enchere.article.nomArticle}"</p>
   			</a></li>
			</c:forEach>
	</ul>
</c:if>			




</body>
</html>