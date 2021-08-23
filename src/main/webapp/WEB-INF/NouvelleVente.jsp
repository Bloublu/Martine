<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nouvelle vente</title>
<link rel="stylesheet" href="css/nouvelleVente.css" />
</head>
<body>



<a href="/Encheres">Retour Liste des ench�res</a>
<a href ="/Accueil">Deconnexion</a>




<h1>Nouvelle vente</h1>

<h3>ENI-Ench�res</h3>


<form action="./NouvelleVente" method="POST">


		<label for="article">Article : </label>
		<input  type="text" name="nom_article" placeholder="Nom de l'article" size="30" maxlength="50" required="required"><br>
		<br>
		
		<label for="description">Description : </label>
		<input type="text" name="description" placeholder="D�crivez votre article" size="70" maxlength="70"><br>
		<br>
		
		<label for="Cat�gorie">Cat�gorie :</label>
		<select id="selectionCategorie" name="no_categorie" required="required">
 		<option value="1" selected>Informatique</option>
  		<option value="2">Ameublement</option>
  		<option value="3">V�tement</option>
  		<option value="4">Sport & loisir</option>
		</select><br><br>
		
		<label for="image">Photo de l'article :</label>
		<input type="file" id="image" name="image" accept="image/png, image/jpeg" required="required"><br><br>
		
		<label for="MiseAPrix">Mise � prix :</label>
		<input type="number" name="prix_initial" id="miseAPrix" required="required"><br><br>
		
					
		<label for="start">D�but de l'ench�re :</label>
		<input type="date" id="start" name="date_debut_enchere" value="2021-08-18" required="required"><br><br><br>
		<input type="time" id="start_time" name="time_debut_enchere" required="required"><br><br><br>
       
   		<label for="start">Fin de l'ench�re :</label>
		<input type="date" id="end" name="date_fin_enchere" value="2021-08-18" required="required"><br><br><br>
       	<input type="time" id="end_time" name="time_fin_enchere" required="required"><br><br><br>
       	
   
 		<fieldset>
		<legend>Retrait</legend>
	
		<label for="rue">Rue : </label>
		<INPUT TYPE="TEXT" value ="${User.rue}"><br><br>

		<label for="codePostal">Code postal : </label>
		<INPUT TYPE="TEXT" value ="${User.codepostal}"><br><br>

		<label for="ville">Ville : </label>
		<INPUT TYPE="TEXT" value ="${User.ville}"><br><br>
		</fieldset><br><br>



<input class="creer" type="submit" value="Enregistrer">
</form>

<button type="submit" name="annuler" onclick="document.location.href='${pageContext.request.contextPath}/Accueil'">Annuler</button>

</body>
</html>