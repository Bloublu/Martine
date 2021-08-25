<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="fr.eni.martine.bo.Enchere" %>
<%@page import="fr.eni.martine.bo.User" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Encheres</title>
</head>
<body>
<h1>Liste des Enchères</h1>
<h1>tester les liens</h1>
<h2>Bienvenue ${user.nom} ${enchere.user.prenom}</h2> 

<form action="" method="post">
<label for="filteEnchere">Filtre : </label><br>
<input type="text" name="recherche" id="rech" placeholder="Le nom de l'article contient" size="30" maxlenght="80"><br>
<label for="favorite">Catégorie</label>
<select name="categ" size="1">

<optgroup label="Maison">
<option value="electromenager">electroménager</option>
<option value="ameublement">Ameublement</option>
<option value="jardin">Jardin</option>
</optgroup>
<optgroup label="Véhicules">
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

<input type="radio" name="Achat"/>Achat<br>
	
	<input type="checkbox" name="ouverte" />encheres Ouvertes <br>
	<input type="checkbox" name="encheres" />mes encheres<br>
	<input type="checkbox" name="remporte" />mes enchères remportées <br>
	
<br>
<input type="radio" name="Ventes"/>Mes Ventes<br>
	<input type="checkbox" name="encours"/>mes ventes en cours <br>
	<input type="checkbox" name="nonDebuter"/>ventes non débutées  <br>
	<input type="checkbox" name="termine"/>ventes terminées  <br>

<button type="submit">Rechercher</button>
</form>

<p> on tente d'afficher l'article d'un GUS. nom: ${enchere.user.nom}</p>



</body>
</html>