<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="./CSS/inscription.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Formulaire Inscription</title>
</head>
<body>
<h1>Formulaire d'inscription</h1>


<form action="./Inscription" method="POST">

	<div class="colonneG">

		<label for="pseudo">Pseudo : </label>
		<input  type="text" name="pseudo" placeholder="Soyez imaginatif" size="30" maxlength="50"><br>
		<br>
		<label for="prenom">Prenom : </label>
		<input type="text" name="prenom" placeholder="Mettez votre prenom" size="30" maxlength="50"><br>
		<br>
		<label for="rue">Rue : </label>
		<input type="text" name="rue" placeholder="Mettez votre Rue" size="30" maxlength="50"><br>
		<br>
		<label for="téléphone">Téléphone : </label>
		<input type="text" name="telephone" placeholder="Mettez votre 06-07" size="30" maxlength="50"><br>
		<br>
		<label for="mot de passe ">Mot De Passe : </label>
		<input type="text" name="motdepasse" placeholder="Inventez votre Mot De Passe" size="30" maxlength="50"><br>
		<br>
	</div>

	<div class="colonneD">

		<label for="email">Email : </label>
		<input type="text" name="email" placeholder="Mettez votre e-mail" size="30" maxlength="50"><br>
		<br>
		<label for="nom">Nom : </label>
		<input type="text" name="nom" placeholder="Mettez votre nom" size="30" maxlength="50"><br>
		<br>
		<label for="ville">Ville : </label>
		<input type="text" name="ville" placeholder="Mettez votre Ville" size="30" maxlength="50"><br>
		<br>
		<label for="codepostal">Code Postal : </label>
		<input type="text" name="codepostal" placeholder="Mettez votre Code Postal" size="30" maxlength="50"><br>
		<br>
		<label for="motdepasseconfirmation">Confirmation de Mot De Passe : </label>
		<input type="text" name="motdepasseconfirmation" placeholder="Confirmation de Mot De Passe" size="30" maxlength="50"><br>
		<br>
	</div>
	
	<div class="button">
		<button class="creer" type="submit">Créer</button>
	</div>

</form>
<button type="submit" name="annuler" onclick="document.location.href='${pageContext.request.contextPath}/Accueil'">Annuler</button>
<br>


</body>
</html>