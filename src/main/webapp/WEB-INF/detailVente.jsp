<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="fr.eni.martine.bo.Enchere" %>
<%@page import="java.util.List" %> 
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./CSS/detailVente.css" rel="stylesheet">
<title>Détail vente</title>

</head>

<body>

<form action="./DetailVente" method="POST">


<div class="header">

<h1>Détail de la vente</h1>
<div class="mamartine"><img src="<c:url value="/images/Martine.jpg"/>"/></div>
</div><br><br>


	
		<div class="colonne">
		<label for="article">Article : </label>
		<input  type="text" name="nom_article" placeholder="Nom de l'article" size="30" maxlength="50"><br>
		<br>
		
		
		<label for="description">Description : </label>
		<textarea name="description" id="description" rows="10" cols="30" placeholder="Décrivez votre article"></textarea>
		
		<br><br>
		
		<label for="Catégorie">Catégorie :</label>
		<select id="selectionCategorie" name="no_categorie">
 		<option value="1" selected>Informatique</option>
  		<option value="2">Ameublement</option>
  		<option value="3">Vêtement</option>
  		<option value="4">Sport & loisir</option>
		</select><br><br>
		
		
		
		
		<label for="image">Photo de l'article :</label>
		<input type="file" id="image" name="image" accept="image/png, image/jpeg"/><br><br>
		
		
		<label for="MiseAPrix">Mise à prix :</label>
		<input type="number" name="prix_initial" id="miseAPrix" min="1" placeholder="Veuillez rentrer une valeur"><br><br>
		
					
		      
   		<label for="start">Fin de l'enchère :</label>
		<input type="date" id="end" name="date_fin_enchere" value="LocalDate" required>
       	<input type="time" id="end_time" name="time_fin_enchere" value="LocalTime"><br><br><br>
       	
   
 		<fieldset>
		<legend>Retrait</legend>
	
		<label for="rue">Rue : </label>
		<INPUT TYPE="TEXT" value ="${user.rue}"><br><br>

		<label for="codePostal">Code postal : </label>
		<INPUT TYPE="TEXT" value ="${user.codepostal}"><br><br>

		<label for="ville">Ville : </label>
		<INPUT TYPE="TEXT" value ="${user.ville}"><br><br>
		</fieldset><br><br>
		
		<label for="vendeur">Vendeur :</label>
		<input  type="text" name="vendeur"><br>
		</div>


<input class="creer" type="submit" value="Encherir">
</form><br><br>

<a class="accueil" href = "./Accueil">Retour à l'accueil</a>

<footer>
        <p>© 2021 - PROJET ENI - MARTINE</p>
    </footer>
    
    
</body>
</html>